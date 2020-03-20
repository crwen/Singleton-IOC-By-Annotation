package me.crw.smart.utils;

import java.util.Arrays;

/**
 * ClassName: ArrayUtils
 * Description:
 * date: 2020/1/3 23:25
 *
 * @author crwen
 * @create 2020-01-03-23:25
 * @since JDK 1.8
 */
public final class ArrayUtils {

	public static <T> T[] concatenate(final T[] first, final T[]... rest) {
		int totalLength = first.length;

		for (final T[] array : rest) {
			totalLength += array.length;
		}

		final T[] ret = Arrays.copyOf(first, totalLength);
		int offset = first.length;

		for (final T[] array : rest) {
			System.arraycopy(array, 0, ret, offset, array.length);
			offset += array.length;
		}
		return ret;
	}

	public static boolean isEmpty(Object[] arrays) {
		return arrays== null ||arrays.length == 0;
	}
}
