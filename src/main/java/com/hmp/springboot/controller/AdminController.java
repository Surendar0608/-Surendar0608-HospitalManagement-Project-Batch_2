package com.hmp.springboot.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import com.hmp.springboot.entity.Admin;
import com.hmp.springboot.service.AdminService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/admin")
public class AdminController {
	@Autowired
	private AdminService adminservice;

	public AdminController(AdminService adminservice) {
		super();
		this.adminservice = adminservice;
	}
	//admin register
	@PostMapping("/register")
	public ResponseEntity< Admin> saveAdmin(@Valid @RequestBody  Admin admin)
	{
	System.out.println("admin register "+admin);
		return new ResponseEntity<Admin>(adminservice.saveAdmin(admin),HttpStatus.CREATED);
	}
	//admin login
	@PostMapping("/login")
	public  ResponseEntity<Admin> loginAdmin( @RequestBody Admin admin)
	{
	return new ResponseEntity<Admin>(adminservice.loginAdmin(admin),HttpStatus.OK);
		
}
	
}
