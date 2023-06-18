package proxy.cglib_proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory {

    private Transaction target = new Transaction();

    public Transaction getProxyObject(){
        //创建Enhancer对象，类似于JDK动态代理的Proxy类，下一步就是设置几个参数
        Enhancer enhancer = new Enhancer();
        //设置父类的字节码对象(superClass,有说明了生成的代理对象是原始对象的父类)
        enhancer.setSuperclass(target.getClass());
        //设置回调函数
     /*
        intercept方法参数说明：
            o ： 代理对象
            method ： 真实对象中的方法的Method实例
            objects ： 实际参数
            methodProxy ：代理对象中的方法的method实例
     */
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("代理点收取一些服务费用(CGLIB动态代理方式)");
//                父类Object强转为子类Transaction
                Transaction result = (Transaction) methodProxy.invokeSuper(o, objects);
                return result;
            }
        });

        //创建代理对象
        Transaction obj = (Transaction) enhancer.create();
        return obj;
    }
}
