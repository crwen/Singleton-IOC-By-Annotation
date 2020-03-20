package me.crw.smart.annotated;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: Common
 * Description:
 * date: 2020/1/16 19:56
 *
 * @author crwen
 * @create 2020-01-16-19:56
 * @since JDK 1.8
 */

@Target(ElementType.TYPE) // 描述类、接口或enum声明
@Retention(RetentionPolicy.RUNTIME)
public @interface Common {
}
