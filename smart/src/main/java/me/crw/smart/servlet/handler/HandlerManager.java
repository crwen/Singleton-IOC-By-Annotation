package me.crw.smart.servlet.handler;

import me.crw.smart.annotated.Controller;
import me.crw.smart.annotated.Get;
import me.crw.smart.annotated.Post;
import me.crw.smart.ioc.DiscoverClass;
import me.crw.smart.servlet.enums.RequestEnums;
import org.apache.commons.collections4.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/**
 * ClassName: HandlerManager
 * Description:
 * date: 2020/1/23 11:35
 *
 * @author crwen
 * @create 2020-01-23-11:35
 * @since JDK 1.8
 */
public class HandlerManager{

	/**
	 *  用于存放请求与处理器的映射关系
	 */
	private static final Map<Request, Handler> ACTION_MAP = new HashMap<Request, Handler>();


	public static void init() {
		// 找到 被 @Controller 修饰的类
		Set<Class<?>> classSet = DiscoverClass.getClassesByAnnotation(Controller.class);
		if (CollectionUtils.isNotEmpty(classSet)) {
			for (Class<?> cls : classSet) {
				// 获取方法
				Method[] methods = cls.getDeclaredMethods();

				for (Method method : methods) {
					boolean mayTarget = false;
					Request request = null;

					if (method.isAnnotationPresent(Get.class)) {
						// GET 方法
						mayTarget = true;
						String requestURL = method.getAnnotation(Get.class).value();
						request = new Request(RequestEnums.GET.getRequestMethod(), requestURL);
					} else if (method.isAnnotationPresent(Post.class)) {
						// POST 方法
						mayTarget = true;
						String requestURL = method.getAnnotation(Post.class).value();
						request = new Request(RequestEnums.POST.getRequestMethod(), requestURL);
					}

					if (mayTarget) {
						//添加请求与处理器的映射关系
						Handler handler = new Handler(cls, method);
						ACTION_MAP.put(request, handler);
					}

				}
			}
		}
	}

	/**
	 *  根据 request 请求获取请求处理器
	 * @param request
	 * @return
	 */
	public static Handler getHandler(HttpServletRequest request) {
		Request req = new Request(request.getMethod().toUpperCase(), request.getPathInfo());
		return ACTION_MAP.get(req);
	}

}
