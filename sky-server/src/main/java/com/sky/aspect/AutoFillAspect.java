package com.sky.aspect;

import com.sky.annotation.AutoFill;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//自定义AOP实现自动填充
@Aspect
@Component
@Slf4j
public class AutoFillAspect {
    //指定切入点
    //@annotation：这是一个切入点指示符，用于匹配带有指定注解的方法。
    //com.sky.annotation.AutoFill：指定了注解的全限定名
    //意味着要匹配的方法必须使用 com.sky.annotation.AutoFill 注解进行标注。
    @Pointcut("execution(* com.sky.mapper.*.*(..)) && @annotation(com.sky.annotation.AutoFill)")
    public void autoFillPointCut() {}
    @Before("autoFillPointCut()")
    public void autoFill(JoinPoint joinPoint) {
        log.info("公共字段开始填充");
    }
}
