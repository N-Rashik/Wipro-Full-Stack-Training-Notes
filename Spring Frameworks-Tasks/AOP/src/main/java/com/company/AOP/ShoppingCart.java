package com.company.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ShoppingCart {

    // Before Advice
    @Before("execution(* com.company.AOP.ShoppingCart.checkout(..))")
    public void beforeLogger(JoinPoint jb) {
        System.out.println("Before Method: Arguments passed = " + java.util.Arrays.toString(jb.getArgs()));
    }

    // Around Advice
    @Around("execution(* com.company.AOP.ShoppingCart.checkout(..))")
    public Object aroundLogger(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Around (Before Checkout)");
        Object result = pjp.proceed();  // proceed with method execution
        System.out.println("Around (After Checkout)");
        return result;
    }

    // After Advice
    @After("execution(* com.company.AOP.ShoppingCart.checkout(..))")
    public void afterLogger(JoinPoint jb) {
        System.out.println("After Method executed: " + jb.getSignature());
    }

    // After Returning Advice
    @AfterReturning(pointcut = "execution(* com.company.AOP.ShoppingCart.checkout(..))", returning = "returnValue")
    public void afterReturningLogger(Object returnValue) {
        System.out.println("After Returning: Method returned value = " + returnValue);
    }

    // After Throwing Advice
    @AfterThrowing(pointcut = "execution(* com.company.AOP.ShoppingCart.checkout(..))", throwing = "ex")
    public void afterThrowingLogger(Exception ex) {
        System.out.println("After Throwing: Exception caught = " + ex.getMessage());
    }

	public void checkout(String string) {
		// TODO Auto-generated method stub
		
	}
}
