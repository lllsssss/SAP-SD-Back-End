package com.lily.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author valarchie
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)//ElementType.FIELD表示该注解只能用于类/接口/枚举
public @interface ExcelSheet {

    /**
     * sheet名称
     */
    String name() default "";

}
