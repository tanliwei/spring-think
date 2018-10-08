package net.csdn.chimomo.cglibProxy;

/**
 * 关于JDK动态代理和CGLIB动态代理 private, final, static修饰的方法不能被代理
 * https://www.cnblogs.com/stefanking/articles/5059325.html
 */
public class TargetObject {

    public void proxyMethod(String name){
        System.out.println(this.getClass().getName()+" ---> " + name);
    }

    private void privateMethod(){
        System.out.println("private method");
    }

    public final void finalMethod(){
        System.out.println("final method");
    }

    public static void staticMethod(){
        System.out.println("static method");
    }
}
