package com.xuan.aspect;

import cn.hutool.core.util.StrUtil;
import com.xuan.util.dataSource.DataSource;
import com.xuan.util.dataSource.DataSourceHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class DataSourceAspect implements Ordered {
    private static final Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);

    @Before("execution(* com.xuan.*.mapper.*.*(..))")
    public void before() throws Throwable {
        logger.debug("before");
//        Object target = point.getTarget();
//        Object[] args = point.getArgs();
//        String kind = point.getKind();
//        Signature signature = point.getSignature();
//        String name = signature.getName();
//        logger.debug(StrUtil.format("target:{},targetName:{},args:{},kind:{},name:{}"), target, target.getClass().getName(), args, kind, name);
//        point.proceed();
    }

    @After("execution(* com.xuan.*.mapper.*.*(..))")
    public void after() throws Throwable {
        logger.debug("after");
//        Object target = point.getTarget();
//        Object[] args = point.getArgs();
//        String kind = point.getKind();
//        Signature signature = point.getSignature();
//        String name = signature.getName();
//        logger.debug(StrUtil.format("target:{},targetName:{},args:{},kind:{},name:{}"), target, target.getClass().getName(), args, kind, name);
//        point.proceed();
    }

    @Around("execution(* com.xuan.*.mapper.*.*(..))")
    public void around(ProceedingJoinPoint point) throws Throwable {
        logger.debug("around");
        Object target = point.getTarget();
        Object[] args = point.getArgs();
        Signature signature = point.getSignature();
        String name = signature.getName();
        Class<?>[] parameterTypes = ((MethodSignature) signature).getMethod().getParameterTypes();
        Class<?>[] interfaces = target.getClass().getInterfaces();

        Method method = interfaces[0].getMethod(name, parameterTypes);
        if (method.isAnnotationPresent(DataSource.class)) {
            DataSource annotation = method.getAnnotation(DataSource.class);
            DataSourceHolder.putDataSource(annotation.value());
        } else {
            DataSourceHolder.putDataSource((String) DataSource.class.getDeclaredMethods()[0].getDefaultValue());
        }
        logger.debug(StrUtil.format("target:{},targetName:{},args:{},name:{}"), target, target.getClass().getName(), args, name);
        point.proceed();
    }

    @Override
    public int getOrder() {
        logger.debug("getOrder");
        return 1;
    }
}
