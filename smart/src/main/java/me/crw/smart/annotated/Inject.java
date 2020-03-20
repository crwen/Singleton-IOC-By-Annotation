package me.crw.smart.annotated;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * ClassName: Inject
 * Description:
 * date: 2020/1/17 13:02
 *
 * @author crwen
 * @create 2020-01-17-13:02
 * @since JDK 1.8
 */
@Target({METHOD, CONSTRUCTOR, FIELD})
@Retention(RUNTIME)
@Documented
public @interface Inject {
}
