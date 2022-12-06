package com.hmp.springboot.service;

import java.util.List;
import com.hmp.springboot.entity.Doctor;

public interface DoctorService {
	
	public Doctor saveDoctor(Doctor doctor);
	public Doctor loginDoctor(Doctor doctor);
	public Doctor updateDoctor(Doctor doctor,int DoctorId);
	public Doctor getDoctorById(int DoctorId);
	public List<Doctor> getAllDoctor();
	public Doctor getDoctorByEmail(Doctor doctor);
	public void deleteDoctor(int DoctorId);

}
