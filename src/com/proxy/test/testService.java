package com.proxy.test;

import com.proxy.handler.CostTimeInvocationHandler;
import com.proxy.service.IService;
import com.proxy.service.IUserService;
import com.proxy.service.Impl.ServiceA;
import com.proxy.service.Impl.ServiceB;
import com.proxy.service.Impl.UserServiceA;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class testService {

    public static void main(String[] args) throws Exception {
        /*m1();
        m2();*/

        IService serviceA = CostTimeInvocationHandler.createProxy(new ServiceA(), IService.class);
        IService serviceB = CostTimeInvocationHandler.createProxy(new ServiceB(), IService.class);
//      每次使用代理对象调用方法都i
        serviceA.m1();
        serviceA.m2();
        serviceA.m3();

        serviceB.m1();
        serviceB.m2();
        serviceB.m3();

        IUserService userService = CostTimeInvocationHandler.createProxy(new UserServiceA(), IUserService.class);
        userService.insert("测试用例");
    }

    public static void m1() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 1. 获取接口对应的代理类
        Class<IService> proxyClass = (Class<IService>) Proxy.getProxyClass(IService.class.getClassLoader(), IService.class);
        // 2. 创建代理类的处理器
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("我是InvocationHandler，被调用的方法是：" + method.getName());
                return null;
            }
        };
        // 3. 创建代理实例
        IService proxyService = proxyClass.getConstructor(InvocationHandler.class).newInstance(invocationHandler);
        // 4. 调用代理的方法
        proxyService.m1();
        proxyService.m2();
        proxyService.m3();
    }


    public static void m2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 1. 创建代理类的处理器
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("我是InvocationHandler，被调用的方法是：" + method.getName());
                return null;
            }
        };
        // 2. 创建代理实例
        IService proxyService = (IService) Proxy.newProxyInstance(IService.class.getClassLoader(), new Class[]{IService.class}, invocationHandler);
        // 3. 调用代理的方法
        proxyService.m1();
        proxyService.m2();
        proxyService.m3();
    }
}
