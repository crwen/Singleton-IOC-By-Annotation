package me.crw.smart.servlet.handler;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * ClassName: Request
 * Description:
 * date: 2020/1/23 11:16
 *
 * @author crwen
 * @create 2020-01-23-11:16
 * @since JDK 1.8
 */
public class Request {

	/**
	 *  请求方法
	 */
	private String requestMethod;

	/**
	 *  请求路径
	 */
	private String requestURL;

	public Request(String requestMethod, String requestURL) {
		this.requestMethod = requestMethod;
		this.requestURL = requestURL;
	}

	public String getRequestMethod() {
		return requestMethod;
	}

	public String getRequestURL() {
		return requestURL;
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
}
