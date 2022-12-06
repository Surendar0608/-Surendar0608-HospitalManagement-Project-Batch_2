package com.hmp.springboot.repository;

import java.util.List;

import com.hmp.springboot.entity.Patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
//public List<Patient> findByDoctorId(int doctorId);
}
