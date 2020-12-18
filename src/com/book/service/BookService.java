package com.book.service;

import com.book.entity.Book;
import com.book.entity.PageBean;

public interface BookService {
	//图书列表
	PageBean<Book> showAllBooks(int curPage,int pageNum);
	
	//根据出版社查找图书
	PageBean<Book> showBooksByPublicName(String pname,int curPage,int pageNum);
	
	//添加图书
	boolean addBook(Book book);
	
	//删除图书
	boolean deleteBookByName(String bname);
	
	//修改除书名外的信息
	boolean updateBookInfo(Book book);
}
