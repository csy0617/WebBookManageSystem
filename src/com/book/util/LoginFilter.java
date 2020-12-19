package com.book.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 拦截所有的请求
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//哪些请求可以放行，哪些请求需要拦截下来看是否登录成功
		//获得请求的路径
		HttpServletRequest req = (HttpServletRequest)request;
		String path=req.getRequestURI();
		//哪些页面不能直接访问，哪些可以直接访问
		//如果是点击登录按钮跳转的页面，查看购物车页面，需要判断是否登录成功
		if (path.contains("/AllBookListServlet")||path.contains("/DeleteBookServlet")||path.contains("/InsertBookServlet")
				||path.contains("/InsertServlet")||path.contains("/SearchServlet")
				||path.contains("/SearchBookServlet")||path.contains("/UpdateBookInfoServlet")
				||path.contains("/UpdateServlet"))
		{
			HttpSession session=req.getSession();
			Object admin = session.getAttribute("admin");
			if (admin!=null) {
				chain.doFilter(request, response);
			}else {
				//引导到登录页面
				HttpServletResponse res=(HttpServletResponse) response;
				res.sendRedirect(req.getServletContext().getContextPath()+"/ToLoginServlet");//跳转到登录页面
			}
		}
		else {//其他页面直接放行
			chain.doFilter(request, response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
