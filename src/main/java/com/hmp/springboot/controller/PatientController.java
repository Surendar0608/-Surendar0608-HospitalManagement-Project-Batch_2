package com.hmp.springboot.controller;

import java.util.List;

import com.hmp.springboot.entity.Patient;
import com.hmp.springboot.service.PatientService;

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
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	
	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}
	
	//save patient details
	@PostMapping("{doctorId}")
	public ResponseEntity<Patient> savePatient(@PathVariable int doctorId,@RequestBody Patient patient) {
		return new ResponseEntity<Patient>(patientService.savePatient(patient,doctorId),HttpStatus.CREATED);
	}
	
	//get all patient details
	@GetMapping()
	public List<Patient> fetchPatientList(){
		return patientService.fetchPatientList();
	}
	
	
	@GetMapping("/patient/{id}")
	public Patient fetchPatientById(@PathVariable("id") int Patient_Id) {
		return patientService.fetchPatientById(Patient_Id);
	}
	
	//get patient details by doctorId
//	@GetMapping("{doctorId}")
//	public List<Patient> getPatientDetailsByDoctorId(@PathVariable int doctorId){
//		return patientService.getPatientDetailsByDoctorId(doctorId);
//	}
	
	
	//to delete patient
	@DeleteMapping("{id}")
	public ResponseEntity<Boolean> deletePatientById(@PathVariable("id") int Patient_Id) {
		patientService.deletePatientById(Patient_Id);
		boolean flag=true;
		return new ResponseEntity<Boolean>(flag,HttpStatus.OK);
		}
	
	//updating patient details
	@PutMapping("{id}")
	public ResponseEntity<Patient>  updatePatient(@PathVariable("id") int Patient_Id, @RequestBody Patient patient) {
		return new ResponseEntity<Patient> (patientService.updatePatient(Patient_Id,patient), HttpStatus.OK);
		}
}

