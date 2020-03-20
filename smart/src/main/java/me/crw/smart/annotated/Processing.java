package me.crw.smart.annotated;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: Process
 * Description:
 * date: 2020/1/3 22:47
 *
 * @author crwen
 * @create 2020-01-03-22:47
 * @since JDK 1.8
 */
@Target({ElementType.TYPE, ElementType.METHOD}) // 描述类、接口或enum声明
@Retention(RetentionPolicy.RUNTIME)
public @interface Processing {
	String value() default "";

}
