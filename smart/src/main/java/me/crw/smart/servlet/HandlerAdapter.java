package me.crw.smart.servlet;

import me.crw.smart.servlet.handler.Handler;
import me.crw.smart.servlet.renderer.ModelAndView;

import java.util.Map;

/**
 * ClassName: HandelAdapter
 * Description:
 * date: 2020/1/23 12:58
 *
 * @author crwen
 * @create 2020-01-23-12:58
 * @since JDK 1.8
 */
public interface HandlerAdapter {

	ModelAndView handler(Handler handler, Map<String, Object> parameterMap);

}
