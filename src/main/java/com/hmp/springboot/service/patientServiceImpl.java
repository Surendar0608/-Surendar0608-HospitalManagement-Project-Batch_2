package com.hmp.springboot.service;

import java.util.List;
import java.util.Objects;

import com.hmp.springboot.entity.Doctor;
import com.hmp.springboot.entity.Patient;
import com.hmp.springboot.exception.ResourceNotFoundException;
import com.hmp.springboot.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class patientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;
	@Autowired 
	private DoctorService doctorService;
	
	
	public patientServiceImpl(PatientRepository patientRepository, DoctorService doctorService) {
		super();
		this.patientRepository = patientRepository;
		this.doctorService = doctorService;
	}

	@Override
	public Patient savePatient(Patient patient,int doctorId) {
		Doctor doctor = doctorService.getDoctorById(doctorId);
		patient.setDoctor(doctor);
		return patientRepository.save(patient) ;
	}
	
	@Override
	public List<Patient> fetchPatientList() {
		return patientRepository.findAll();
	}

	@Override
	public Patient fetchPatientById(int Patient_Id) {
		return patientRepository.findById(Patient_Id).get();
	}

	@Override
	public void deletePatientById(int Patient_Id) {
		patientRepository.findById(Patient_Id).orElseThrow(()-> new ResourceNotFoundException("Patient","Id",Patient_Id));
		patientRepository.deleteById(Patient_Id);
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public Patient updatePatient(int Patient_Id, Patient patient) {
		Patient patDB= patientRepository.findById(Patient_Id).get();
		
		if(Objects.nonNull(patient.getPatient_Name())&& !"".equalsIgnoreCase(patient.getPatient_Name())) {
			patDB.setPatient_Name(patient.getPatient_Name());
		}
		if(Objects.nonNull(patient.getGender())&& !"".equalsIgnoreCase(patient.getGender())) {
			patDB.setGender(patient.getGender());
		}
		
		if(Objects.nonNull(patient.getBirthdate())&& !"".equalsIgnoreCase(patient.getBirthdate())) {
			patDB.setBirthdate(patient.getBirthdate());
		}
		
		if(Objects.nonNull(patient.getBloodGroup())&& !"".equalsIgnoreCase(patient.getBloodGroup())) {
			patDB.setBloodGroup(patient.getBloodGroup());
		}
		
		if(Objects.nonNull(patient.getMobileNo())&& !"".equals(patient.getMobileNo())) {
			patDB.setMobileNo(patient.getMobileNo());
		}
		
		if(Objects.nonNull(patient.getCity())&& !"".equalsIgnoreCase(patient.getCity())) {
			patDB.setCity(patient.getCity());
		}
		
		if(Objects.nonNull(patient.getAddress())&& !"".equalsIgnoreCase(patient.getAddress())) {
			patDB.setAddress(patient.getAddress());
		}
		
//		if(Objects.nonNull(patient.getPatient_Id())&& !"".equals(patient.getPatient_Id())) {
//			patDB.setPatient_Id(patient.getPatient_Id());
//		}
		return patientRepository.save(patDB);
		
	}

	

//	@Override
//	public List<Patient> getPatientDetailsByDoctorId(int doctorId) {
//		return patientRepository.findByDoctorId(doctorId);
//	}

}
