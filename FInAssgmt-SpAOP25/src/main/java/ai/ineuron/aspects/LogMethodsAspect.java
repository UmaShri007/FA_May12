package ai.ineuron.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogMethodsAspect {

	//advice will be called on all methods
	 @Before("execution(* ai.ineuron.service.MyService.*(..))")
	    public void logMethodCall(JoinPoint joinPoint) {
	        String methodName = joinPoint.getSignature().getName();
	        Object[] args = joinPoint.getArgs();

	        System.out.println("Calling method: " + methodName);
	        System.out.print("Input parameters:");

	        for (Object arg : args) {
	            System.out.println(arg);
	        }
	    }

	    @AfterReturning(pointcut = "execution(* ai.ineuron.service.MyService.*(..))", returning = "result")
	    public void logMethodReturn(JoinPoint joinPoint, Object result) {
	        String methodName = joinPoint.getSignature().getName();

	        System.out.println("Method " + methodName + " returned: " + result);
	        System.out.println("-----------------------------");
	    }
	}

