package com.book.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.book.dao.BookDao;
import com.book.entity.Book;
import com.book.util.JDBCUtil;

public class BookDaoImpl implements BookDao {
	private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtil.getDataSource());

	@Override
	public List<Book> selectAllBooks(int start, int pagenum) {
		String sql ="select * from tb_book";
		List<Book> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
		return books;
	}

	@Override
	public List<Book> selectBooksLikePublicLimit(String bname, int start, int pagenum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addBook(Book book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBookByName(String bname) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBook(Book book) {
		// TODO Auto-generated method stub
		return false;
	}

}
