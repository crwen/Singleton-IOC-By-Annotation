package me.crw.smart.helper;

import me.crw.smart.constant.ConfigConstant;
import me.crw.smart.utils.PropsUtil;

import java.util.Properties;

/**
 * ClassName: ConfigHelper
 * Description:
 * date: 2020/1/18 21:01
 *
 * @author crwen
 * @create 2020-01-18-21:01
 * @since JDK 1.8
 */
public class ConfigHelper {


	private static final Properties CONFIG_PROPS = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);

	/**
	 *  获取JDBC驱动
	 * @return
	 */
	public static String getJdbcDriver() {
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_DRIVER);
	}

	/**
	 *  获取JDBC_URL
	 * @return
	 */
	public static String getJdbcUrl() {
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_URL);
	}

	/**
	 *  获取 JDBC 用户名
	 * @return
	 */
	public static String getJdbcUsername() {
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_USERNAME);
	}

	/**
	 *  获取 JDBC 密码
	 * @return
	 */
	public static String getJdbcPassword() {
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_PASSWORD);
	}

	/**
	 *  获取应用基础包名
	 * @return
	 */
	public static String getBasePackage() {
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_BASE_PACKAGE);
	}

	/**
	 *  获取 应用 JSP 路径
	 * @return
	 */
	public static String getJspPath() {
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_JSP_PATH, "/WEB-INF/view");
	}

	/**
	 * 获取应用静态资源路径
	 * @return
	 */
	public static String getAssetPath() {
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_ASSET_PATH, "/asset");
	}

}
