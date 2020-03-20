package me.crw.smart.annotated;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: Get
 * Description:
 * date: 2020/1/22 12:37
 *
 * @author crwen
 * @create 2020-01-22-12:37
 * @since JDK 1.8
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Get {

	String value() default "";

}
