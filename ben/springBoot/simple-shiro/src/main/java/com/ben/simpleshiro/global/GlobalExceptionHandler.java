//package com.ben.simpleshiro.global;
//
//import org.apache.shiro.ShiroException;
//import org.apache.shiro.authc.UnknownAccountException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
///**
// * @author yangkun
// */
//@ControllerAdvice
//public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
//
//    @ExceptionHandler(ShiroException.class)
//    @ResponseBody
//    public String handlerShiroException() {
//        return "ShiroException";
//    }
//
//    @ResponseBody
//    @ExceptionHandler(UnknownAccountException.class)
//    public String handlerUnknownAccount() {
//        return "UnknownAccountException";
//    }
//}
