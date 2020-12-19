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
		String sql = "select * from tb_book limit ?,?";
		List<Book> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class),start,pagenum);
		return books;
	}

	@Override
	public List<Book> selectBooksLikePublicLimit(String pname, int start, int pagenum) {
		String sql = "select * from tb_book where publicName like concat('%',?,'%') limit ?,?";
		List<Book> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class),pname,start,pagenum);
		return books;
	}

	@Override
	public boolean addBook(Book book) {
		String sql = "insert into tb_book values(?,?,?,?,?)";
		int count = jdbcTemplate.update(sql, book.getName(), book.getAuthor(), book.getPublicName(), book.getPrice(),
				book.getHardCode());
		return count > 0 ? true : false;
	}

	@Override
	public boolean deleteBookByName(String bname) {
		String sql = "delete from tb_book where name=?";
		int count = jdbcTemplate.update(sql, bname);
		return count > 0 ? true : false;
	}

	@Override
	public boolean updateBook(Book book) {
		String sql = "update tb_book set author=?,publicName=?,price=?,hardCode=? where name = ?";
		int count = jdbcTemplate.update(sql, book.getAuthor(), book.getPublicName(), book.getPrice(),
				book.getHardCode(), book.getName());
		return count > 0 ? true : false;
	}

	@Override
	public int allBooksCount() {
		String sql = "select count(*) from tb_book";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}

	@Override
	public int countByPublicName(String pname) {
		String sql = "select count(*) from tb_book where publicName like concat('%',?,'%')";
		int count = jdbcTemplate.queryForObject(sql, Integer.class,pname);
		return count;
	}

	@Override
	public List<Book> selectAllBooksWithNoPage() {
		String sql = "select * from tb_book";
		List<Book> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
		return books;
	}

	@Override
	public List<Book> selectBookByName(String bname) {
		String sql = "select * from tb_book where name=?";
		List<Book> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class),bname);
		return books;
	}

}
