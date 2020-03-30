package me.crw.smart.ioc;

import me.crw.smart.annotated.Configuration;
import me.crw.smart.config.Config;
import me.crw.smart.annotated.Controller;
import me.crw.smart.annotated.Service;
import me.crw.smart.utils.ClassUtils;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: Discover
 * Description:
 * date: 2020/1/16 19:06
 *
 * @author crwen
 * @create 2020-01-16-19:06
 * @since JDK 1.8
 */
public class DiscoverClass {

	// 存放基础包下所有的类
	private static final Set<Class<?>> CLASS_SET;

	// 存放管理的 bean 对象（被 @Service、@Controller 注解修饰的类）
	private static final Set<Class<?>> BEAN_SET;


	static {
		// 获取所有的基础包下所有的类
		CLASS_SET = ClassUtils.getClasses(Config.getPath());
		BEAN_SET = new HashSet<Class<?>>();
		//for (Class<?> aClass : CLASS_SET) {
		//	System.out.println(aClass.isAnnotationPresent(Controller.class));
		//}
		discover();
	}

	/**
	 *  查找带有 @Controller 和 @Service 注解的类
	 * @return
	 */
	 private static void discover() {
		for (Class<?> cls : CLASS_SET) {
			boolean mybeanClass = false;


			if (cls.isAnnotationPresent(Controller.class) ||
					cls.isAnnotationPresent(Service.class) || cls.isAnnotationPresent(Configuration.class)) {
				mybeanClass = true;
			}
			try {
				if (mybeanClass) {
					cls.getClassLoader().loadClass(cls.getName()); // 加载类
					BEAN_SET.add(cls);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();

			}
		}
	}

	/**
	 *  寻找带有某注解的类
	 * @param annotation
	 * @return
	 */
	public static Set<Class<?>> getClassesByAnnotation(Class<? extends Annotation> annotation) {
		Set<Class<?>> classSet = new HashSet<Class<?>>();
		if (null == CLASS_SET)
			return null;
		for (Class<?> cls : CLASS_SET) {
			if (cls.isAnnotationPresent(annotation)) {
				classSet.add(cls);
			}
		}

		return classSet;
	}

	/**
	 *  返回管理的 bean 类对象集合
	 * @return
	 */
	public static Set<Class<?>> getBeanClassSet() {
		return BEAN_SET;
	}
}
