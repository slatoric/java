package ru.learnhub.spring.boot.guess_springboot.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Aspect
@Slf4j
public class LoggingAspectUnused {
//    @After("execution (* ru.learnhub.spring.boot.guess_springboot.service.*.*(..))")
    public void log(@NotNull JoinPoint point){
        String methodName=point.getSignature().getName();
        List<String> args= Arrays.stream(point.getArgs()).map(Object::toString).collect(Collectors.toList());
        log.info("Invoked method {}, with params {}",methodName,args);
    }
}
