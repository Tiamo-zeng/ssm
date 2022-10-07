package com.zs.controller;

import com.zs.exception.BusinessException;
import com.zs.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjeckExceptionAdvice {

    @ExceptionHandler(SystemException.class)
    public Restult doSystemException(SystemException ex){

        return new Restult(ex.getCode(),null,ex.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public Restult doBusinessException(BusinessException ex){

        return new Restult(ex.getCode(),null,ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Restult doException(Exception ex){

        return new Restult(Code.SYSTEM_UNO_ERR,null,"系统繁忙，请稍后再试！");
    }

}
