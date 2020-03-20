package me.crw.smart.servlet.renderer;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: View
 * Description:
 * date: 2020/1/23 22:22
 *
 * @author crwen
 * @create 2020-01-23-22:22
 * @since JDK 1.8
 */
public class View {

	/**
	 *  视图路径
	 */
	private String path;

	/**
	 *  模型数据
	 */
	private Map<String, Object> model;

	public View(String path) {
		this.path = path;
		model = new HashMap<String, Object>();
	}

	public String getPath() {
		return this.path;
	}

	public Map<String, Object> getModel() {
		return this.model;
	}

	public View addModel(String key, Object value) {
		model.put(key, value);
		return this;
	}
}
