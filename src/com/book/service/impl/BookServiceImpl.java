package com.book.service.impl;

import java.util.List;

import com.book.dao.BookDao;
import com.book.dao.impl.BookDaoImpl;
import com.book.entity.Book;
import com.book.entity.PageBean;
import com.book.service.BookService;

public class BookServiceImpl implements BookService {
	private BookDao bookDao = new BookDaoImpl();

	@Override
	public PageBean<Book> showAllBooks(int curPage, int pageNum) {
		int startLine=(curPage-1)*pageNum;
		List<Book> books = bookDao.selectAllBooks(startLine, pageNum);
		int count = bookDao.allBooksCount();
		return new PageBean<Book>(curPage, books, count, pageNum);
	}

	@Override
	public PageBean<Book> showBooksByPublicName(String pname, int curPage, int pageNum) {
		int startLine=(curPage-1)*pageNum;
		List<Book> books = bookDao.selectBooksLikePublicLimit(pname, startLine, pageNum);
		int count = bookDao.countByPublicName(pname);
		return new PageBean<Book>(curPage, books, count, pageNum);
	}

	@Override
	public boolean addBook(Book book) {
		// TODO Auto-generated method stub
		return bookDao.addBook(book);
	}

	@Override
	public boolean deleteBookByName(String bname) {
		// TODO Auto-generated method stub
		return bookDao.deleteBookByName(bname);
	}

	@Override
	public boolean updateBookInfo(Book book) {
		// TODO Auto-generated method stub
		return bookDao.updateBook(book);
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookDao.selectAllBooksWithNoPage();
	}

	@Override
	public List<Book> getBookByName(String bname) {
		// TODO Auto-generated method stub
		return bookDao.selectBookByName(bname);
		
	}

}
