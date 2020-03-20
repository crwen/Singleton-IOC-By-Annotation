package me.crw.smart.ioc;

import me.crw.smart.annotated.Inject;
import me.crw.smart.utils.ArrayUtils;
import me.crw.smart.utils.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: BeanFactory
 * Description:
 * date: 2020/1/16 20:41
 *
 * @author crwen
 * @create 2020-01-16-20:41
 * @since JDK 1.8
 */
public class BeanFactory {

	// 存放管理 bean 的 类 到 实例的映射
	private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<Class<?>, Object>();

	/**
	 *  为单个对象注入属性
	 * @param obj
	 * @param field
	 */
	private static void inject(Object obj, Field field) {
		Class<?> beanFieldClass = field.getType();
		Object beanFieldInstance = BEAN_MAP.get(beanFieldClass);
		if (beanFieldClass != null) {
			ReflectionUtils.setField(obj, field, beanFieldInstance);
		}
	}

	/**
	 *  注入属性
	 */
	public static void inject() {
		for (Map.Entry<Class<?>, Object> beanEntry : BEAN_MAP.entrySet()) {
			Class<?> beanClass = beanEntry.getKey();
			Object beanInstance = beanEntry.getValue();

			// 获取类属性
			Field[] fields = beanClass.getDeclaredFields();
			if (!ArrayUtils.isEmpty(fields)) {
				for (Field field : fields) {
					if (field.isAnnotationPresent(Inject.class)) {
						inject(beanInstance, field);
					}
				}
			}

		}
	}



	public static Object getBean(Class<?> beanClass) {
		if (BEAN_MAP.containsKey(beanClass)) {
			return BEAN_MAP.get(beanClass);
		}
		return null;
	}

	/**
	 *  创建被管理 bean 的 Class 到 Instance 之间的映射
	 * @param classes
	 */
	public static void createBeans(final Collection<Class<?>> classes) {
		if (null == classes || classes.isEmpty()) {
			return;
		}

		for (Class<?> cls : classes) {
			if (!BEAN_MAP.containsKey(cls)) {
				Object bean = createBean(cls);
				BEAN_MAP.put(cls, bean);
			}
		}

	}

	/**
	 *  根据 Class 创建对应实例，并返回
	 * @param beanClass
	 * @return
	 */
	public static Object createBean(Class<?> beanClass) {
		Object ret;

		ret = ReflectionUtils.newInstance(beanClass);

		// 注入属性
		//Field[] fields = beanClass.getDeclaredFields();

		return ret;
	}

	/**
	 *  返回被管理 bean Class 到 实例 的集合
	 * @return
	 */
	public static Map<Class<?>, Object> getBeanMap() {
		return BEAN_MAP;
	}
}
