package me.crw.smart.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * ClassName: JsonUtils
 * Description:
 * date: 2020/1/23 13:23
 *
 * @author crwen
 * @create 2020-01-23-13:23
 * @since JDK 1.8
 */
public final class JsonUtils {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	/**
	 *  将 POJO 转为 JSON
	 * @param obj
	 * @param <T>
	 * @return
	 */
	public static <T> String toJson(T obj) {
		String json;
		try {
			json = OBJECT_MAPPER.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
		return json;
	}

	public static <T> T fromJson(String json, Class<T> type) {
		T pojo;
		try {
			pojo = OBJECT_MAPPER.readValue(json, type);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return pojo;
	}
}

