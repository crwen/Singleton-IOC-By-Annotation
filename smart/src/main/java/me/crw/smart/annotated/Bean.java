package me.crw.smart.annotated;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: Bean
 * Description:
 * date: 2020/3/30 12:54
 *
 * @author crwen
 * @create 2020-03-30-12:54
 * @since JDK 1.8
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Bean {

}
