package spring.think.ch12.service.impl;

import spring.think.ch12.service.HelloRMIService;

public class HelloRMIServiceImpl implements HelloRMIService {
    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
