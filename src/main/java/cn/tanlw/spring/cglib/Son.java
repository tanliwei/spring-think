package cn.tanlw.spring.cglib;

import org.springframework.stereotype.Component;

@Component("son")
public class Son extends Parent {
    private void privateMethod(){
        System.out.println("privateMethod");
    }

    public void publicSonMethod(){}
}
