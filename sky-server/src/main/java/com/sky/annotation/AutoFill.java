package com.sky.annotation;

import com.sky.enumeration.OperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 确保注解在运行时可见
@Target(ElementType.METHOD) // 注解可以应用在方法上
public @interface AutoFill {
    // 定义注解的属性
    OperationType value();
}
