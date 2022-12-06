package com.hmp.springboot.service;

import java.util.List;
import com.hmp.springboot.entity.Patient;

public interface PatientService {
	
	public Patient savePatient(Patient patient,int doctorId);
	
	public List<Patient> fetchPatientList();
	
	//public List<Patient> getPatientDetailsByDoctorId(int doctorId);
	
	public Patient fetchPatientById(int Patient_Id);
	
	public void deletePatientById(int Patient_Id);
	
	public Patient updatePatient(int Patient_Id,Patient patient);

}
