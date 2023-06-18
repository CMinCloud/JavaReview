package proxy.jdk_proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理工厂，用来创建代理对象:用来做增强
 */
public class ProxyFactory {

    /*内部new出来一个对象*/
//    private TranStation station = new TranStation();
    /*通过传入参数自定义*/
    Object station;

    public ProxyFactory(Object obj){
        this.station = obj;
    }

    /*新建一个代理对象*/
    public SellTickets getProxyObject() {
        SellTickets proxyInstance = (SellTickets) Proxy.newProxyInstance(
                station.getClass().getClassLoader(), station.getClass().getInterfaces(), new InvocationHandler() {
                   /*
                        InvocationHandler中invoke方法参数说明：
                            proxy ： 代理对象
                            method ： 对应于在代理对象上调用的接口方法的 Method 实例
                            args ： 代理对象调用接口方法时传递的实际参数
                     */
                   //                    当调用代理对象时会调用该方法，用来做增强
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("代理对象做了一点增强~");
                        System.out.println("被调用的方法类型:"+method);
                        System.out.println("调用的执行对象："+station);
//                        执行真实对象
                        Object result = method.invoke(station, args);
                        return result;
                    }
                }
        );
        return proxyInstance;
    }


}
