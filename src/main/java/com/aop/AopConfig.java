package com.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 纯注解模式
 */


@Configuration//代表当前类是以一个配置类
@ComponentScan("com.sun")//开始包扫描
@EnableAspectJAutoProxy//切面
public class AopConfig {
}
