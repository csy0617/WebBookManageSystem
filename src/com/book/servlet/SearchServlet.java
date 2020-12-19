package com.book.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.service.impl.BookServiceImpl;
import com.book.entity.Book;
import com.book.entity.PageBean;
import com.book.service.BookService;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchkey = request.getParameter("searchkey");
		String scurPage = request.getParameter("curPage");
		int curPage=1;
		if (scurPage!=null&&!scurPage.equals("")) {
			curPage=Integer.parseInt(scurPage);
		}
		BookService bookService = new BookServiceImpl();
		PageBean<Book> page = bookService.showBooksByPublicName(searchkey, curPage, 4);
		request.setAttribute("page", page);
		request.setAttribute("curPage", curPage);
		request.setAttribute("pname", searchkey);
		request.getRequestDispatcher("/WEB-INF/jsp/searchbook.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
