package com.hmp.springboot.service;

import com.hmp.springboot.entity.Admin;

public interface AdminService {
	Admin saveAdmin(Admin admin);
	Admin loginAdmin(Admin admin);
}
