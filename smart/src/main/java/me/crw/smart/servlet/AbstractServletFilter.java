package me.crw.smart.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * ClassName: AbstractServletFilter
 * Description:
 * date: 2020/1/23 15:47
 *
 * @author crwen
 * @create 2020-01-23-15:47
 * @since JDK 1.8
 */
//@WebFilter(urlPatterns = "/*")
public class AbstractServletFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("filter");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}
}
