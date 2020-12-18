package com.book.service;

import com.book.entity.Admin;

public interface AdminService {
	//登陆
	Admin login(String adminacc,String adminpwd);
}
