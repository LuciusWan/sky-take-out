package com.sky.aspect;

import com.sky.annotation.AutoFill;
import com.sky.constant.AutoFillConstant;
import com.sky.context.BaseContext;
import com.sky.enumeration.OperationType;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
    public void autoFill(JoinPoint joinPoint) throws NoSuchMethodException, IllegalAccessException {
        log.info("公共字段开始填充");
        Class<?> targetClass = joinPoint.getTarget().getClass();
        String methodName = joinPoint.getSignature().getName();
        Class<?>[] parameterTypes = new Class<?>[joinPoint.getArgs().length];
        log.info("Target Class: {}", targetClass.getName());
        log.info("Method Name: {}", methodName);
        for (int i = 0; i < joinPoint.getArgs().length; i++) {
            parameterTypes[i] = joinPoint.getArgs()[i].getClass();
        }
        Method method = targetClass.getMethod(methodName, parameterTypes);
        //TODO 了解为什么会得不到注解对象
        /*AutoFill autoFill = method.getAnnotation(AutoFill.class);
        //获取注解下方法的操作类型
        OperationType operationType = autoFill.value();
        log.info("获取到的方法的操作类型为{}", operationType);*/
        //获取被拦截的方法的参数-实体对象
        Object[] arg=joinPoint.getArgs();
        if(arg==null||arg.length==0){
            return;
        }
        Object entity=arg[0];
        log.info("{}",entity);

        //准备赋值数据
        LocalDateTime now = LocalDateTime.now();
        Long currentId= BaseContext.getCurrentId();

        //对应不同操作类型（insert/update）给对象赋值
        if(methodName.contains("insert")){
            try {
                // 调用实体类的 setCreateTime 方法
                Method setCreateTimeMethod = entity.getClass().getMethod(AutoFillConstant.SET_CREATE_TIME, LocalDateTime.class);
                setCreateTimeMethod.invoke(entity, now);

                // 调用实体类的 setCreateUser 方法
                Method setCreateUserMethod = entity.getClass().getMethod(AutoFillConstant.SET_CREATE_USER, Long.class);
                setCreateUserMethod.invoke(entity, currentId);

                // 插入操作时也可以设置更新时间和更新用户
                Method setUpdateTimeMethod = entity.getClass().getMethod(AutoFillConstant.SET_UPDATE_TIME, LocalDateTime.class);
                setUpdateTimeMethod.invoke(entity, now);

                Method setUpdateUserMethod = entity.getClass().getMethod(AutoFillConstant.SET_UPDATE_USER, Long.class);
                setUpdateUserMethod.invoke(entity, currentId);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }else if(methodName.contains("update")){
            try {
                // 调用实体类的 setUpdateTime 方法
                Method setUpdateTimeMethod = entity.getClass().getMethod(AutoFillConstant.SET_UPDATE_TIME, LocalDateTime.class);
                setUpdateTimeMethod.invoke(entity, now);

                // 调用实体类的 setUpdateUser 方法
                Method setUpdateUserMethod = entity.getClass().getMethod(AutoFillConstant.SET_UPDATE_USER, Long.class);
                setUpdateUserMethod.invoke(entity, currentId);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
