package me.crw.smart.servlet;

import me.crw.smart.annotated.Controller;
import me.crw.smart.annotated.Processing;
import me.crw.smart.ioc.DiscoverClass;
import me.crw.smart.utils.ArrayUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ClassName: ProcessManager
 * Description:
 * date: 2020/1/22 12:41
 *
 * @author crwen
 * @create 2020-01-22-12:41
 * @since JDK 1.8
 */
public class ProcessManager {

	private static Set<Class<?>> CONTROLLER_SET = new HashSet<Class<?>>();

	private static final Map<Class<?>, Map<Class<?>, Map<Method, String>>> PROCESSING_MAP =
			new HashMap<Class<?>, Map<Class<?>, Map<Method, String>>>();

	//static  {
	//
	//}

	public static void init() {
		CONTROLLER_SET = DiscoverClass.getClassesByAnnotation(Controller.class);
		createHandleProcessingMap();
	}

	public static Map<Class<?>, Map<Class<?>, Map<Method, String>>> getProcessMap() {
		return PROCESSING_MAP;
	}

	/**
	 *  创建 处理类与路径的映射
	 * @return
	 */
	private static void  createHandleProcessingMap() {
		if (null == CONTROLLER_SET || CONTROLLER_SET.size() == 0) {
			return ;
		}

		for (Class<?> cls : CONTROLLER_SET) {
			if (cls.isAnnotationPresent(Processing.class)) {
				String value = cls.getAnnotation(Processing.class).value();
				Map<Class<?>, Map<Method, String>> map = createHandleRequestMap(cls);
				PROCESSING_MAP.put(cls, map);
			}
		}
	}

	/**
	 *  创建 类 中方法与请求路径之间的映射
	 * @param clazz
	 * @return
	 */
	private static Map<Class<?>, Map<Method, String>> createHandleRequestMap(Class<?> clazz) {
		Map<Class<?>, Map<Method, String>> map = new HashMap<Class<?>, Map<Method, String>>();
		if (null == clazz) {
			return map;
		}

		Method[] methods = clazz.getDeclaredMethods();
		if (ArrayUtils.isEmpty(methods)) {
			return map;
		}

		Map<Method, String> requestMap = new HashMap<Method, String>();
		for (Method method : methods) {
			if (method.isAnnotationPresent(Processing.class)) {
				String value = method.getAnnotation(Processing.class).value();
				requestMap.put(method, value);
			}
		}
		map.put(clazz, requestMap);

		return map;
	}
}
