package me.crw.smart;

import me.crw.smart.ioc.BeanFactory;
import me.crw.smart.ioc.DiscoverClass;

import java.util.Set;

/**
 * ClassName: BeanManager
 * Description:
 * date: 2020/1/3 22:48
 *
 * @author crwen
 * @create 2020-01-03-22:48
 * @since JDK 1.8
 */
public class BeanManager {

	/**
	 * Bean初始化（加载、实例化、注入）
	 */
	public static void init() {
		// 加载并获取 注解对应类
		Set<Class<?>> beanClass = DiscoverClass.getBeanClassSet();

		// 创建 bean 容器
		BeanFactory.createBeans(beanClass);

		// 注入属性
		BeanFactory.inject();
	}


}
