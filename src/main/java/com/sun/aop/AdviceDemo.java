package com.sun.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class AdviceDemo {
    //增强的代码，在调用之前来执行这个通知
    public void before(){
        System.out.println("======前置通知======");
    }

    //再在这个方法执行完成之后来执行的代码块 ，
    // 后者通知 出现异常就不执行
    // 可以获取 方法的返回值
    public void afterReturning(Integer num){
        System.out.println("=====后置通知========="+num);
    }

    //异常通知
    // 出现异常的时候，会执行 可以获得异常的信息
    public void afterThrowing(Exception e){
        System.out.println("=====异常通知========="+e);
    }

    //再在这个方法执行完成之后来执行的代码块
    // 无论是否有异常都会执行
    public void after(){
        System.out.println("=====最终通知=========");
    }


    //环绕通知：  可以 在业务代码 之前 之后  异常  执行 ， 就相当于同时添加了  before after afterReturning throwing等
    //需要获得链接点
    public void around(ProceedingJoinPoint pjp){

        try {
            System.out.println("=====around前置通知=========");
            pjp.proceed();//执行业务方法
            System.out.println("=====around后置通知=========");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("=====around异常通知========="+throwable);
        }finally {
            System.out.println("=====around最终通知=========");
        }

    }



}
