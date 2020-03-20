package me.crw.smart.servlet.handler;

import me.crw.smart.ioc.BeanFactory;
import me.crw.smart.servlet.HandlerAdapter;
import me.crw.smart.servlet.renderer.ModelAndView;
import me.crw.smart.servlet.renderer.View;
import me.crw.smart.utils.ReflectionUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Map;

/**
 * ClassName: AnnotationHandlerAdapter
 * Description:
 * date: 2020/1/23 12:59
 *
 * @author crwen
 * @create 2020-01-23-12:59
 * @since JDK 1.8
 */
public class AnnotationHandlerAdapter implements HandlerAdapter {
	private Parameter arg;

	@Override
	public ModelAndView handler(Handler handler, Map<String, Object> parameterMap) {
		// 获取处理方法参数列表
		Method requestMethod = handler.getRequestMethod();
		Parameter[] args = requestMethod.getParameters();


		Object handleClass = BeanFactory.getBean(handler.getHandlerClass());
		// 通过反射调用方法
		Object result;
		if (args == null || args.length == 0) {
			result = ReflectionUtils.invokeMethod(handleClass, requestMethod);
		} else {
			result = ReflectionUtils.invokeMethod(handleClass, requestMethod, parameterMap);
		}

		ModelAndView mv = new ModelAndView();
		if ((result instanceof View) || (result instanceof String)) {
			mv.setView(result);
		} else {
			mv.setModel(result);
		}
		return mv;
	}

}
