package me.crw.smart.annotated;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: Configuration
 * Description:
 * date: 2020/3/30 12:52
 *
 * @author crwen
 * @create 2020-03-30-12:52
 * @since JDK 1.8
 */
@Stereotype
@Target(ElementType.TYPE) // 描述类、接口或enum声明
@Retention(RetentionPolicy.RUNTIME)
public @interface Configuration {

}
