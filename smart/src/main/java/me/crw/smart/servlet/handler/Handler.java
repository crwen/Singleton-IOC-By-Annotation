package me.crw.smart.servlet.handler;

import java.lang.reflect.Method;

/**
 * ClassName: HandlerHelper
 * Description:
 * date: 2020/1/23 11:19
 *
 * @author crwen
 * @create 2020-01-23-11:19
 * @since JDK 1.8
 */
public class Handler {

	private Class<?> handlerClass;

	private Method requestMethod;

	public Handler(Class<?> handlerClass, Method requestMethod) {
		this.handlerClass = handlerClass;
		this.requestMethod = requestMethod;
	}

	public Class<?> getHandlerClass() {
		return handlerClass;
	}

	public Method getRequestMethod() {
		return requestMethod;
	}
}
