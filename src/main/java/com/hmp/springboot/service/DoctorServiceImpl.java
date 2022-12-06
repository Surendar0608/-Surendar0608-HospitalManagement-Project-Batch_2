package com.hmp.springboot.service;

import java.util.List;


import com.hmp.springboot.entity.Doctor;
import com.hmp.springboot.exception.DoctorNotFoundException;
import com.hmp.springboot.repository.DoctorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	private DoctorRepository doctorRepository;
	
	

	public DoctorServiceImpl() {
		super();
	}

	public DoctorServiceImpl(DoctorRepository doctorRepository) {
		super();
		this.doctorRepository = doctorRepository;
	}

	@Override
	public Doctor saveDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	@Override
	public Doctor loginDoctor(Doctor doctor) {
		return this.doctorRepository.findByEmailIDAndPassword(doctor.emailID,doctor.password).orElseThrow(()->new DoctorNotFoundException("Doctor ", "Id",doctor.emailID+" and password "+doctor.password ));
	}

	@Override
	public Doctor updateDoctor(Doctor doctor, int DoctorId) {

		Doctor existingDoctor=doctorRepository.findById(DoctorId).orElseThrow(()->new DoctorNotFoundException("Doctor","Id",DoctorId));	
		existingDoctor.setDoctorName(doctor.getDoctorName());
		existingDoctor.setGender(doctor.getGender());
		existingDoctor.setMobile(doctor.getMobile());
		existingDoctor.setQualification(doctor.getQualification());
		existingDoctor.setSpecialization(doctor.getSpecialization());
		existingDoctor.setCity(doctor.getCity());
		existingDoctor.setEmailID(doctor.getEmailID());
		existingDoctor.setPassword(doctor.getPassword());
		doctorRepository.save(existingDoctor);
		return existingDoctor;	}

	@Override
	public Doctor getDoctorById(int DoctorId) {
		return doctorRepository.findById(DoctorId).orElseThrow(()->new DoctorNotFoundException("Doctor","DoctorId",DoctorId));
			}

	@Override
	public List<Doctor> getAllDoctor() {
		return doctorRepository.findAll();
	}

	@Override
	public Doctor getDoctorByEmail(Doctor doctor) {
		return this.doctorRepository.findByEmailID(doctor.emailID).orElseThrow(()->new DoctorNotFoundException("Doctor ", "Email",doctor.emailID));
	}

	@Override
	public void deleteDoctor(int DoctorId) {
		doctorRepository.findById(DoctorId).orElseThrow(()->new DoctorNotFoundException("Doctor","Id",DoctorId));
		doctorRepository.deleteById(DoctorId);
	}
	
	

}
