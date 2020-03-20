package me.crw.smart.servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * ClassName: EncodingFilter
 * Description:
 * date: 2020/1/23 17:39
 *
 * @author crwen
 * @create 2020-01-23-17:39
 * @since JDK 1.8
 */
@WebFilter(urlPatterns = "/*")
public class EncodingFilter implements Filter {

	/**
	 * Request encoding.
	 */
	private String requestEncoding = "UTF-8";

	/**
	 * Response encoding.
	 */
	private String responseEncoding = "UTF-8";

	private String contentType = "text/html;charset=UTF-8";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(requestEncoding);
		response.setCharacterEncoding(responseEncoding);

		response.setContentType(contentType);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}
}
