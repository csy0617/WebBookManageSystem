package com.book.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * 拦截的页面 拦截所有页面/*
 * @WebFilter("/CharacterFilter")
 */
@WebFilter("/*")
public class CharacterFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CharacterFilter() {
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
		// TODO Auto-generated method stub
		//拦下来之后做的事情(页面上就没有必要做处理了，统一做处理)
		request.setCharacterEncoding("utf-8");
		//服务器给客户端的响应
		response.setCharacterEncoding("utf-8");
		//过滤器链 多个过滤器 可能经过多个过滤器 该过滤器放行
		chain.doFilter(request, response);//放行
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
