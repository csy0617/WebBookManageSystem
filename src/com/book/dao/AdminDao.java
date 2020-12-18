package com.book.dao;

import com.book.entity.Admin;

public interface AdminDao {
	//登陆
	Admin selectAdminByAccAndPwd(String adminname,String adminpwd);
}
