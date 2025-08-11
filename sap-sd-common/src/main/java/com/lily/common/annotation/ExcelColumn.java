package com.lily.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义导出Excel数据注解
 *
 * @author valarchie
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)//ElementType.FIELD表示该注解只能用于类的字段（成员变量）
public @interface ExcelColumn {

    String name() default "";

}
