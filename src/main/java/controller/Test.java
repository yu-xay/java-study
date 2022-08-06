package controller;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;
import java.util.concurrent.*;

interface IHello {
    void sayHello(String name);

    void sayGoogBye(String name);
}

class Helloimplements implements IHello {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }

    @Override
    public void sayGoogBye(String name) {
        System.out.println(name + " GoodBye!");
    }
}

class DynaProxyHello implements InvocationHandler {
    private Object delegate;

    public Object bind(Object oo){
        this.delegate = oo;
       return  Proxy.newProxyInstance(this.delegate.getClass().getClassLoader(), this.delegate.getClass().getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try {
            System.out.println(method.getName());
            System.out.println("问候之前的日志记录...");
            // JVM通过这条语句执行原来的方法(反射机制)
            result = method.invoke(this.delegate, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
};
class cl extends Object implements Cloneable{

    public int a = 3;
    @Override
    public cl clone() {
        try {
            return (cl) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
public class Test {
    public static void main(String[] args) {
        cl c1 = new cl();
        cl c2 = c1.clone();
        System.out.println(c1 == c2);
        DynaProxyHello helloproxy = new DynaProxyHello();
        Helloimplements hello = new Helloimplements();
        IHello ihello = (IHello) helloproxy.bind(hello);
        String s = "33";
    }
}
