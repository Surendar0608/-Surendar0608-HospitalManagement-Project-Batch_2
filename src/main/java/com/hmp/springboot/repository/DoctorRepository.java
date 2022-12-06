package com.hmp.springboot.repository;

import java.util.Optional;

import com.hmp.springboot.entity.Doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
Optional<Doctor> findByEmailIDAndPassword(String emailID,String password);
Optional<Doctor> findByEmailID(String emailID);
}
