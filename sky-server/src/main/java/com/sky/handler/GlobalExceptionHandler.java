package com.sky.handler;

import com.sky.constant.MessageConstant;
import com.sky.exception.BaseException;
import com.sky.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.bridge.Message;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理器，处理项目中抛出的业务异常
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 捕获业务异常
     * @param ex
     * @return
     */
    @ExceptionHandler
    public Result exceptionHandler(BaseException ex){
        log.error("异常信息：{}", ex.getMessage());
        return Result.error(ex.getMessage());
    }
    @ExceptionHandler
    //unique关键词异常，不能创建重复的账号
    public Result exceptionHandler(SQLIntegrityConstraintViolationException ex){
        String message = ex.getMessage();
        //若这段异常信息包括字符串Duplicate entry，则这个异常是重复创建账号异常
        if(message.contains("Duplicate entry")){
            String[] result=message.split(" ");
            return Result.error("账号"+result[2]+MessageConstant.ALREADY_EXISTS);
        }
        //如果不是创建账号重复异常则返回未知错误
        return Result.error(MessageConstant.UNKNOWN_ERROR);
    }

}
