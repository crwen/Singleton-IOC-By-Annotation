package me.crw.smart.annotated;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: Post
 * Description:
 * date: 2020/1/23 11:47
 *
 * @author crwen
 * @create 2020-01-23-11:47
 * @since JDK 1.8
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Post {
	String value() default "";
}
