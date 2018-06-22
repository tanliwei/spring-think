package net.csdn.chimomo.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @create 2018/6/21
 */
public class ListProxy<T> implements InvocationHandler {
    private List<T> target;
    public ListProxy(List<T> target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("---before---"+method.getName()+":"+args[0]);
        //     * @param target  the object the underlying method is invoked from
        //     * @param args    the arguments used for the method call
        Object retVal = method.invoke(target,args);
        System.out.println("---after---size:"+target.size());
        return retVal;
    }
}
