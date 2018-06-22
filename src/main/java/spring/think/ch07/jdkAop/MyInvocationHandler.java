package spring.think.ch07.jdkAop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @create 2018/6/21
 */
public class MyInvocationHandler implements InvocationHandler {
    //目标对象
    private  Object target;
    public MyInvocationHandler(Object target){
        this.target = target;
    }

    /**
     * 执行目标对象的方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //目标对象方法执行之前打印一行
        System.out.println("---before---"+method.getName());
        //执行目标方法
        Object result = method.invoke(target, args);
        //目标对象方法执行之后打印一行
        System.out.println("---after---"+method.getName());
        return result;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(),this);
    }
}
