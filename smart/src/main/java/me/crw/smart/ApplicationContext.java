package me.crw.smart;

import me.crw.smart.config.Config;
import me.crw.smart.helper.ConfigHelper;
import me.crw.smart.ioc.BeanFactory;

import java.util.Map;

/**
 * ClassName: ApplicationContext
 * Description:
 * date: 2020/1/18 21:04
 *
 * @author crwen
 * @create 2020-01-18-21:04
 * @since JDK 1.8
 */
public class ApplicationContext {

	private Class<?> startClass;

	public ApplicationContext(Class<?> startClass) {
		this.startClass = startClass;

		Config.setPath(ConfigHelper.getBasePackage());
		init();
		Map<Class<?>, Object> beanMap = BeanFactory.getBeanMap();
	}

	private void init() {
		BeanManager.init();
	}

	public Object getBean(Class<?> clazz) {
		return BeanFactory.getBean(clazz);
	}
}
