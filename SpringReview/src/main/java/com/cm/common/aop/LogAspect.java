package com.cm.common.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect  // 声明为切面类
@Slf4j          //用来创建日志对象
public class LogAspect {

//    定义切入点
    @Pointcut("@annotation(com.cm.common.aop.LogAnnotation)")
    private void logPointCut(){}

    @Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println("-----切入点的相关信息-----");
        //目标方法的传入参数
        Object[] args = joinPoint.getArgs();
        System.out.println("共"+args.length+"个参数");
        for (int i = 0; i < args.length; i++) {
            System.out.println("第"+i+1+"个参数为："+args[i]);
        }
        //获取目标方法信息
        Signature signature = joinPoint.getSignature();
        System.out.println("目标方法名为："+signature.getName());
        System.out.println("目标方法信息："+signature);
        //可获取所属类，然后获取所属类的相关信息
        System.out.println("目标方法所属类名："+signature.getDeclaringTypeName());
        System.out.println("目标方法所属类简单类名："+signature.getDeclaringType().getSimpleName());
        System.out.println("----切入点相关信息----");
        System.out.println("");

        System.out.println("step0(Before)-目标方法"+signature.getName()+"执行前的操作。。。。");
    }

//    返回后通知
    @AfterReturning("logPointCut()")
    public void doAfterReturning(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        System.out.println("step2(AfterReturning)-目标方法"+signature.getName()+"返回值后的操作。。。。");
    }

//    后置通知
    @After("logPointCut()")
    public void doAfter(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        System.out.println("step3(After)-目标方法"+signature.getName()+"执行后的操作。。。。");

    }

    @Around("logPointCut()")
    public Object doAround(ProceedingJoinPoint joinPoint){
        System.out.println("---以下内容会在Before之前执行---");
        Object[] args = joinPoint.getArgs();
        System.out.println("共"+args.length+"个参数");
        for (int i = 0; i < args.length; i++) {
            System.out.println("第"+(i+1)+"个参数的旧值为："+args[i]);
        }
        //改变参数值
        args[0]="New Hello";
        System.out.println("参数新值："+args[0]);
        System.out.println("---以上内容会在Before之前执行---");
        System.out.println();
        //执行目标方法
        Object result=null;
        try {
            result=joinPoint.proceed(args);
        } catch (Throwable throwable) {
            System.out.println("执行目标方法异常。");
        }

        System.out.println();
        System.out.println("---以下内容会在After之后执行---");
        if(result instanceof String){
            //改变返回值
            result="Happy New Year";
            System.out.println("增强后的返回值"+result);
        }
        System.out.println("---以上内容会在After之后执行---");

        return result;

    }



}
