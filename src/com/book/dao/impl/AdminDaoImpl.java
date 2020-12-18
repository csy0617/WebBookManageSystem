package com.book.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.book.dao.AdminDao;
import com.book.entity.Admin;
import com.book.util.JDBCUtil;

public class AdminDaoImpl implements AdminDao {
	private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtil.getDataSource());

	@Override
	public Admin selectAdminByAccAndPwd(String adminname, String adminpwd) {
		String sql = "select * from tb_admin where adminAcc=? and adminPwd=?";
		List<Admin> admins = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Admin>(Admin.class), adminname, adminpwd);
		if (admins != null && admins.size() != 0) {
			return admins.get(0);
		}
		return null;
	}

}
