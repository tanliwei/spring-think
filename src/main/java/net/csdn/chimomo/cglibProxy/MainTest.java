package net.csdn.chimomo.cglibProxy;

public class MainTest {
    public static void main(String[] args) {
        InvokeHandler invokeHandler = new InvokeHandler();

        TargetObject targetObject = (TargetObject) invokeHandler.getProxy(TargetObject.class);

        targetObject.proxyMethod("this reflect method user cglib method");

        targetObject.finalMethod();

        targetObject.staticMethod();
    }
}
