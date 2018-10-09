package com.aaa.aop;

import java.util.Date;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class ClassesLog {
   @Pointcut("execution(* com.aaa.biz.ClassesBizImpl.save(..))")
   public void work(){};
   
   @Before("work()")
   public void printLog(){
	   System.out.println(new Date()+"添加了一个班级！");
   }
   
}
