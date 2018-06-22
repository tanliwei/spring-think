package net.csdn.chimomo.dynamicProxy;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**https://blog.csdn.net/troubleshooter/article/details/78467637
 * Java - 你如何理解AOP中的连接点（Joinpoint）、切点（Pointcut）、增强（Advice）、引介（Introduction）、织入（Weaving）、切面（Aspect）这些概念？
 * @create 2018/6/21
 */
public class ProxyTest2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        Class<?> clazz = list.getClass();
        ListProxy<String> myProxy = new ListProxy<String>(list);
        // clazz.getInterfaces() @return an array of interfaces implemented by this class.
        List<String> newList = (List<String>)
                Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(),myProxy);
        //newList = {$Proxy@xxx}
        newList.add("Tom");
        newList.add("Jack");
    }
}
