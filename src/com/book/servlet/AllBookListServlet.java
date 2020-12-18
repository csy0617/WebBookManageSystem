package com.book.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.entity.Book;
import com.book.entity.PageBean;
import com.book.service.BookService;
import com.book.service.impl.BookServiceImpl;

/**
 * Servlet implementation class AllBookListServlet
 */
@WebServlet("/AllBookListServlet")
public class AllBookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllBookListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService bookService = new BookServiceImpl();
		String scurPage = request.getParameter("curPage");
		int curPage=1;
		if (scurPage!=null&&!scurPage.equals("")) {
			curPage=Integer.parseInt(scurPage);
		}
		PageBean<Book> page = bookService.showAllBooks(curPage, 5);
		request.setAttribute("page", page);
		request.setAttribute("curPage", curPage);
		request.getRequestDispatcher("/WEB-INF/jsp/allbooklist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
