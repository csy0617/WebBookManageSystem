package com.book.dao;

import java.util.List;

import com.book.entity.Book;

public interface BookDao {
	//查询所有图书列表
	List<Book> selectAllBooks(int start, int pagenum);
	
	//查询所有图书（不分页）
	List<Book> selectAllBooksWithNoPage();
	
	//根据书名查找图书
	List<Book> selectBookByName(String bname);
	
	//查询所有图书的数量
	int allBooksCount();
	
	//根据出版社关键字查找图书
	List<Book> selectBooksLikePublicLimit(String pname,int start,int pagenum);
	
	//查询所有根据出版社关键字查找到的图书的数量
	int countByPublicName(String pname);
	
	//添加图书
	boolean addBook(Book book);
	
	//根据书名删除图书
	boolean deleteBookByName(String bname);
	
	//修改图书信息
	boolean updateBook(Book book);
}
