package com.springboot.system.Library.testare.pointcut;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectTest {

    @AfterReturning("execution(* com.springboot.system.Library.testare.PentruAfterReturning.method())")
    public void afterReturning(){
        System.out.println("Mesaj dupa return din method");
    }
}
