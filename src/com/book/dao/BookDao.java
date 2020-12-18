package com.book.dao;

import java.util.List;

import com.book.entity.Book;

public interface BookDao {
	//查询所有图书列表
	List<Book> selectAllBooks(int start, int pagenum);
	
	//根据出版社关键字查找图书
	List<Book> selectBooksLikePublicLimit(String bname,int start,int pagenum);
	
	//添加图书
	boolean addBook(Book book);
	
	//根据书名删除图书
	boolean deleteBookByName(String bname);
	
	//修改图书信息
	boolean updateBook(Book book);
}