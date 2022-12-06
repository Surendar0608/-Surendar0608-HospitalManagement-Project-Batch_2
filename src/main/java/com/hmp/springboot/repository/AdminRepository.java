package com.hmp.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hmp.springboot.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer>{
	Optional<Admin> findByAdminEmailIdAndAdminPassword(String emailId,String password);
}
