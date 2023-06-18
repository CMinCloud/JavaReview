package com.cm.cas;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABASolution {
    public static void main(String[] args) {

        String str1 = "aaa";
        String str2 = "bbb";
        AtomicStampedReference<String> reference = new AtomicStampedReference<String>(str1,1);
        System.out.println(reference.getStamp());
        reference.compareAndSet(str1,str2,reference.getStamp(),reference.getStamp()+1);
        System.out.println(reference.getStamp());
        System.out.println("reference.getReference() = " + reference.getReference());

        boolean b = reference.attemptStamp(str2, reference.getStamp() + 1);
        System.out.println("b: "+b);
        System.out.println("reference.getStamp() = "+reference.getStamp());

        boolean c = reference.weakCompareAndSet(str2,"ccc",4, reference.getStamp()+1);
        System.out.println("reference.getReference() = "+reference.getReference());
        System.out.println("c = " + c);
    }

/*    输出:
            reference.getReference() = bbb
    b: true
            reference.getStamp() = 3
            reference.getReference() = bbb
            c = false
    c为什么输出false呢, 因为版本戳不一致啦*/
}
