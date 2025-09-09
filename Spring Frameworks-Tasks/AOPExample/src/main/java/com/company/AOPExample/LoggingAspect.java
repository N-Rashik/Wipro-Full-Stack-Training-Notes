package com.company.AOPExample;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // Before Advice
    @Before("execution(* com.company.AOPExample.Checkout.checkoutOrder(..))")
    public void beforeCheckout(JoinPoint jp) {
        System.out.println("[BEFORE] Method: " + jp.getSignature().getName() +
                " | Args: " + java.util.Arrays.toString(jp.getArgs()));
    }

    // After Advice
    @After("execution(* com.company.AOPExample.Checkout.checkoutOrder(..))")
    public void afterCheckout() {
        System.out.println("[AFTER] Checkout method finished.");
    }

    // After Returning Advice
    @AfterReturning(pointcut = "execution(* com.company.AOPExample.Checkout.calculation(..))", returning = "result")
    public void afterReturningCalc(Object result) {
        System.out.println("[AFTER RETURNING] Calculation returned: " + result);
    }

    // After Throwing Advice
    @AfterThrowing(pointcut = "execution(* com.company.AOPExample.Checkout.calculation(..))", throwing = "ex")
    public void afterThrowingCalc(Exception ex) {
        System.out.println("[AFTER THROWING] Exception caught: " + ex.getMessage());
    }

    // Around Advice
    @Around("execution(* com.company.AOPExample.Checkout.calculation(..))")
    public Object aroundCalc(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("[AROUND] Before execution of: " + pjp.getSignature());
        Object result = pjp.proceed();
        System.out.println("[AROUND] After execution of: " + pjp.getSignature());
        return result;
    }
}

