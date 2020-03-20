package me.crw.smart.servlet;

import me.crw.smart.BeanManager;
import me.crw.smart.config.Config;
import me.crw.smart.helper.ConfigHelper;
import me.crw.smart.servlet.handler.HandlerManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * ClassName: AbstractServletListener
 * Description:
 * date: 2020/1/16 18:32
 *
 * @author crwen
 * @create 2020-01-16-18:32
 * @since JDK 1.8
 */
@WebListener("/*")
public class AbstractServletListener implements ServletContextListener {


	/**
	 * 当Servlet 容器启动Web 应用时调用该方法。在调用完该方法之后，容器再对Filter 初始化，
	 * 并且对那些在Web 应用启动时就需要被初始化的Servlet 进行初始化。
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		Config.setPath(ConfigHelper.getBasePackage());
		BeanManager.init();
		//ProcessManager.init();
		// 创建 请求与处理器的映射关系
		HandlerManager.init();
	}

	/**
	 * 当Servlet 容器终止Web 应用时调用该方法。在调用该方法之前，容器会先销毁所有的Servlet 和Filter 过滤器。
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}


}
