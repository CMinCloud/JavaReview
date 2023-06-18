package com.cm.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;



/*
    还是要细细琢磨
    ABA: 问题：
        一般在使用CAS实现乐观锁时，要判断对象的version值是否改变，如果没改变说明可以修改
        但是可能会出现 version被修改过之后又修改回来的情况，那么CAS操作会误认为没有被修改过
 */
public class ABADemo {

    public static void main(String[] args) {

//        一般使用会引用一个 自定义引用 如user，不会出现包装类内部缓存的问题  （比如实体类中添加一个版本号）
        AtomicStampedReference atomicStampedReference = new AtomicStampedReference(1, 1);

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println("a1=>" + stamp);     //     获得版本号
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //            修改数值及版本号
            atomicStampedReference.compareAndSet(1, 2,
                    atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println("a2=>" +  atomicStampedReference.getStamp());

            atomicStampedReference.compareAndSet(2, 1,
                    atomicStampedReference.getStamp(), 1);
            System.out.println("a3=>" +  atomicStampedReference.getStamp());

        },"A").start();



        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println("b1=>" + stamp); //            获得版本号
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+
                    atomicStampedReference.compareAndSet(1, 6,
                    atomicStampedReference.getStamp(),
                    atomicStampedReference.getStamp() + 1));
            System.out.println("b2=>" + atomicStampedReference.getStamp());
        },"B").start();
    }
}
