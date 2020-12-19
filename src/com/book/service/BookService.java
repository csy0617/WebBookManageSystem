package com.book.service;

import java.util.List;

import com.book.entity.Book;
import com.book.entity.PageBean;

public interface BookService {
	//图书列表
	PageBean<Book> showAllBooks(int curPage,int pageNum);
	
	//图书列表（不分页）
	List<Book> getAllBooks();
	
	//根据书名查找图书
	List<Book> getBookByName(String bname);
	
	//根据出版社查找图书
	PageBean<Book> showBooksByPublicName(String pname,int curPage,int pageNum);
	
	//添加图书
	boolean addBook(Book book);
	
	//删除图书
	boolean deleteBookByName(String bname);
	
	//修改除书名外的信息
	boolean updateBookInfo(Book book);
}
