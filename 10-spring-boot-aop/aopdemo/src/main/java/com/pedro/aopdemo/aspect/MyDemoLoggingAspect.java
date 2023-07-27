package com.pedro.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    //    @Before("execution(public void add*())")
//    @Before("execution(void add*())") //modifier is optional
//    @Before("execution(* add*())") //match any return type
//    @Before("execution(* add*(com.pedro.aopdemo.Account))") //match param type
//    @Before("execution(* add*(com.pedro.aopdemo.Account, ..))") //match with Account and any number of arguments
//    @Before("execution(* add*(..))") //match on any parameters
    @Before("execution(* com.pedro.aopdemo.dao.*.*(..))") //march any method on a package
    public void beforeAddAccountAdvice() {
        System.out.println("Executing @Before advice on addAccount()");

    }


}
