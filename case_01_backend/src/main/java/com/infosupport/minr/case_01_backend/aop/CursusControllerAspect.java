package com.infosupport.minr.case_01_backend.aop;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CursusControllerAspect {

    @Around("within(com.infosupport.minr.case_01_backend.*.*) and execution(public * *(..))")
    public Object logService(final ProceedingJoinPoint joinPoint) throws Throwable {
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        logger.debug(StringUtils.join(joinPoint.getSignature().getName(), "() called"));
        long currentTicks = System.currentTimeMillis();
        try {
            System.out.println("Testing Logging");
            Object result = joinPoint.proceed();
            logger.debug(StringUtils.join(joinPoint.getSignature().getName(), "() executed in ", Long.toString(System.currentTimeMillis() - currentTicks), "ms"));
            return result;
        } catch (Throwable ex) {
            logger.debug(StringUtils.join(joinPoint.getSignature().getName(), "() failed"));
            throw ex;
        }
    }
}
