package hkmu.comps380f.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect {
    // intercept any method execution in the class
    @Before("execution(* hkmu.comps380f.op.Operation.*(..))")
    public void logMethodExecution(JoinPoint jp) {
        Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
        logger.info("AOP logging: " + jp.toShortString());
    }
}