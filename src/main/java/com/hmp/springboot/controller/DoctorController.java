package com.hmp.springboot.controller;

import java.util.List;

import com.hmp.springboot.entity.Doctor;
import com.hmp.springboot.service.DoctorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("api/doctor")
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	
	

	public DoctorController() {
		super();
	}

	public DoctorController(DoctorService doctorService) {
		this.doctorService = doctorService;
	}
	
	//register
	@PostMapping("/register")
	public ResponseEntity<Doctor> saveDoctor(@Valid @RequestBody Doctor doctor){
		return new  ResponseEntity<Doctor>(doctorService.saveDoctor(doctor),HttpStatus.CREATED);
	}
	
	//Login
	@PostMapping("/login")
	public  ResponseEntity<Doctor> loginDoctor(@RequestBody Doctor doctor){
		return new  ResponseEntity<Doctor>(doctorService.loginDoctor(doctor),HttpStatus.OK);
	}
	
	//Update doctor
	@PutMapping("{id}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable("id") int DoctorId,@RequestBody Doctor doctor){
		return new ResponseEntity<Doctor>(doctorService.updateDoctor(doctor,DoctorId), HttpStatus.OK); 
	}
	//Get All Customer
	@GetMapping
	public List<Doctor> getAllDoctor(){
		return doctorService.getAllDoctor();
	}
	//get Doctor by email
		@PostMapping("/forgotpass")
		public Doctor getDoctorByEmail(@RequestBody Doctor doctor)
		{
			return doctorService.getDoctorByEmail(doctor);
		}
		//get doctor by id
		@GetMapping("{id}")
		public ResponseEntity<Doctor> getDoctorById(@PathVariable("id") int DoctorId)
		{
			return new ResponseEntity<Doctor>(doctorService.getDoctorById(DoctorId),HttpStatus.OK);
		}
		
		//Delete Doctor	
		@DeleteMapping("{id}")
		public ResponseEntity<Boolean> deleteDoctor(@PathVariable("id") int DoctorId)
		{
			doctorService.deleteDoctor(DoctorId);
			boolean flag=true;
			return new ResponseEntity<Boolean>(flag,HttpStatus.OK);
		}
	
}

