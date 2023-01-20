package ru.learnhub.spring.boot.guess_springboot.service;

import org.springframework.stereotype.Service;
import ru.learnhub.spring.boot.guess_springboot.annotation.LogMethod;
import ru.learnhub.spring.boot.guess_springboot.annotation.WorkTime;

@Service
public class MyService {
    @LogMethod
    public void saySomething(){
        System.out.println("Something!");
    }
    @WorkTime
    public void sayOtherthing(){
        System.out.println("Otherthing!");
    }
}
