package com.example.demo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class EnvUser {

    @Autowired
    Environment environment;

    @PostConstruct
    void init(){
        System.out.println(environment.getProperty("my.name"));
        System.out.println(environment.getProperty("my.phone","001-0023-2333"));//없을 경우 디폴트 값 설정: "001-0023-2333"
        System.out.println(environment.getProperty("my.age",Integer.class));//int 형으로 자동 캐스팅
        System.out.println(environment.getProperty("my.weight",Integer.class, 64));// 없을 경우 디폴트 값 설정: 64
        try{
            environment.getRequiredProperty("my.money");//없을 경우 에러 발생
        }catch (IllegalStateException E){
            System.out.println("에러 발생");
        }
        System.out.println(environment.containsProperty("my.name"));//프로퍼티가 존재하는지 유무 불리언 값
    }
}
