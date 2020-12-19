package com.book.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.entity.Book;
import com.book.service.BookService;
import com.book.service.impl.BookServiceImpl;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bname = request.getParameter("bname");
		String author = request.getParameter("author");
		String publicname = request.getParameter("publicname");
		Double price = Double.parseDouble(request.getParameter("price"));
		String code = request.getParameter("code");
		BookService bookService = new BookServiceImpl();
		Book book = bookService.getBookByName(bname).get(0);
		book.setAuthor(author);
		book.setPublicName(publicname);
		book.setPrice(price);
		book.setHardCode(code);
		bookService.updateBookInfo(book);
		response.sendRedirect(getServletContext().getContextPath()+"/AllBookListServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
