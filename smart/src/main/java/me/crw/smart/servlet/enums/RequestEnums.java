package me.crw.smart.servlet.enums;

/**
 * ClassName: RequestEnums
 * Description:
 * date: 2020/1/23 13:11
 *
 * @author crwen
 * @create 2020-01-23-13:11
 * @since JDK 1.8
 */
public enum RequestEnums {

	GET("GET"),

	POST("POST"),
	;

	String requestMethod;

	RequestEnums(String requestMethod) {
		this.requestMethod = requestMethod;
	}

	public String getRequestMethod() {
		return requestMethod;
	}
}
