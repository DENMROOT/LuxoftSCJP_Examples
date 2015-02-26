package aspects;

import exceptions.ValidationException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by Denis Makarov on 26.02.2015.
 */
@Aspect
public class ValidationAspect {
@Pointcut("execution(* *.setAge(..))")
public void setAgeMethod() {
        }
@Before("setAgeMethod()")
public void checkAge(JoinPoint joinPoint) throws Throwable {
        Object[] methodArgs = joinPoint.getArgs();
        Integer age = (Integer) methodArgs[0];
        if (age > 100) {
        throw new ValidationException("Wrong age: "+age);
        }
    }
}
