package me.crw.smart.config;

/**
 * ClassName: Config
 * Description:
 * date: 2020/1/16 20:30
 *
 * @author crwen
 * @create 2020-01-16-20:30
 * @since JDK 1.8
 */
public class Config {

	private static String path;

	public static String getPath() {
		return path;
	}

	public static void setPath(String path) {
		Config.path = path;
	}
}
