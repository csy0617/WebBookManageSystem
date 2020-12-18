package com.book.service.impl;

import com.book.dao.AdminDao;
import com.book.dao.impl.AdminDaoImpl;
import com.book.entity.Admin;
import com.book.service.AdminService;

public class AdminServiceImpl implements AdminService {
	private AdminDao adminDao = new AdminDaoImpl();

	@Override
	public Admin login(String adminacc, String adminpwd) {
		return adminDao.selectAdminByAccAndPwd(adminacc, adminpwd);
	}

}
