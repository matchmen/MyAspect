package com.aspect.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class MyAspect {


    /***
     * 这里简单介绍一下AspectJ的Pointcut，在Spring中使用最多的是excution切入点，匹配方法的执行，完整的表达式如下：
     * excution([修饰符] 返回类型 [声明类型] 方法名称 （参数类型） [异常类型])
     * 其中返回类型、方法名称、参数类型是必须的，其他为可选的。
     * 最常用的匹配模式是“*”，用来表示任意的返回类型或匹配部分命名模式。
     * “()”匹配一个无参数的方法。
     * “(..)”匹配一个含有任意个参数的方法。
     * “(String,*)”匹配含有两个参数的方法，首个参数类型为String。
     * “(String,..)”匹配至少含有一个参数的方法，首个参数类型为String。
     */

    @Pointcut("within(com.aspect.demo.service..*) && @annotation(org.springframework.scheduling.annotation.Scheduled) && @args()")
    public void pointcut(){}

    @Before("execution(public void print())")
    public void before(){
        log.info("Before execute task !");
    }

    @After("pointcut()")
    public void after(){
        log.info("After execute task !");
    }



}
