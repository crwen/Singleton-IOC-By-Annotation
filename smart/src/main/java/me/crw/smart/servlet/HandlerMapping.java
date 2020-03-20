package me.crw.smart.servlet;

import me.crw.smart.servlet.handler.Handler;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName: HandlerMapping
 * Description:
 * date: 2020/1/23 11:36
 *
 * @author crwen
 * @create 2020-01-23-11:36
 * @since JDK 1.8
 */
public interface HandlerMapping {

	Handler getHandler(HttpServletRequest request);

}
