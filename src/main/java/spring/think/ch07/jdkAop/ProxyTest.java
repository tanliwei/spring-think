package spring.think.ch07.jdkAop;

/**
 * @create 2018/6/21
 */
public class ProxyTest {
    public static void main(String[] args) {
        //实例化目标对象
        UserService userService = new UserServiceImpl();
        //实例化InvocationHandler
        MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);
        //根据目标对象生成代理对象
        UserService proxy = (UserService) invocationHandler.getProxy();
        //调用代理对象的方法
        proxy.add();
        //代理了部分方法
        System.out.println(proxy);
    }
}
