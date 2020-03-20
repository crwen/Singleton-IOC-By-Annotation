package me.crw.smart.annotated;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * ClassName: Stereotype
 * Description:
 * date: 2020/1/16 21:47
 *
 * @author crwen
 * @create 2020-01-16-21:47
 * @since JDK 1.8
 */
@Retention(RUNTIME)
@Target(ANNOTATION_TYPE)
@Documented
public @interface Stereotype {
}
