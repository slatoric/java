package ru.learnhub.spring.boot.guess_springboot.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
    @Around("@annotation(ru.learnhub.spring.boot.guess_springboot.annotation.LogMethod)")
    public Object logPerformanceData(@NotNull ProceedingJoinPoint point) throws Throwable{
        String methodName = point.getSignature().getName();
        List<String> args= Arrays.stream(point.getArgs()).map(Object::toString).collect(Collectors.toList());
        Object returnedValue = point.proceed();
        log.info("Invoked method {}, with params {} and returned {}",methodName,args,returnedValue);
        return returnedValue;
    }
}
