package com.pedro.aopdemo.aspect;

import com.pedro.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @After("execution(* com.pedro.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("Executing @After (finally) on method: " + method);
    }

    @AfterThrowing(pointcut = "execution(* com.pedro.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "exc")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exc) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("Executing @AfterThrowing on method: " + method);
        System.out.println("The exception is: " + exc);
    }

    @AfterReturning(pointcut = "execution(* com.pedro.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("Executing @AfterReturning on method: " + method);
        System.out.println("Result is: " + result);
        convertAccountNamesToUpperCase(result);
        System.out.println("Result is: " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account account : result) {
            account.setName(account.getName().toUpperCase());
        }
    }

    @Before("com.pedro.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("Executing @Before advice on addAccount()");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        Object[] args = joinPoint.getArgs();

        for (Object object : args) {
            System.out.println(object);

            if(object instanceof Account) {
                Account account = (Account) object;
                System.out.println("account name: " + account.getName());
                System.out.println("account level: " + account.getLevel());
            }
        }

    }

}
