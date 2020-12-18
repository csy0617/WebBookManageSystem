package com.book.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.entity.Admin;
import com.book.service.AdminService;
import com.book.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminacc = request.getParameter("adminacc");
		String adminpwd = request.getParameter("adminpwd");
		AdminService adminService = new AdminServiceImpl();
		Admin admin = adminService.login(adminacc, adminpwd);
		if (admin!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			request.getRequestDispatcher("/IndexServlet").forward(request, response);
		}
		else {
			getServletContext().setAttribute("eadminacc", adminacc);
			getServletContext().setAttribute("eadminpwd", adminpwd);
			getServletContext().setAttribute("error", "用户名或密码错误");
			request.getRequestDispatcher("/LoginErrorServlet").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
