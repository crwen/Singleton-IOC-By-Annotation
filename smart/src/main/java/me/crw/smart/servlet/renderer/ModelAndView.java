package me.crw.smart.servlet.renderer;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: ModelAndView
 * Description:
 * date: 2020/1/23 22:05
 *
 * @author crwen
 * @create 2020-01-23-22:05
 * @since JDK 1.8
 */
public class ModelAndView {

	private Object view;

	private Object model;

	private Map<String, Object> map = new HashMap<>();

	public ModelAndView() {
	}

	public ModelAndView(Object view, Map<String, Object> modle) {
		this.view = view;
		this.model = modle;
	}

	public void addAttribute(String attributeName, Object attributeValue) {
		map.put(attributeName, attributeValue);
	}

	public void setView(Object view) {
		this.view = view;
	}

	public Object getView() {
		return this.view;
	}

	public void setModel(Object modle) {
		this.model = modle;
	}

	public Object getModel() {
		return model;
	}
}
