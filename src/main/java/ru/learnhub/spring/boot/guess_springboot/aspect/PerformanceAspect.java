package ru.learnhub.spring.boot.guess_springboot.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@Aspect
@Slf4j
public class PerformanceAspect {
    @Around("@annotation(ru.learnhub.spring.boot.guess_springboot.annotation.WorkTime)")
    public Object logPerformanceData(@NotNull ProceedingJoinPoint point) throws Throwable{
        long start = Instant.now().toEpochMilli();
        String methodName = point.getSignature().getName();
        Object returnedValue = point.proceed();
        long end = Instant.now().toEpochMilli();
        long time = end-start;
        log.info("{} method invoked by {}ms.",methodName,time);
        return returnedValue;
    }
}
