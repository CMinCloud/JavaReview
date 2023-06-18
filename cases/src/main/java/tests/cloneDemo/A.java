package tests.cloneDemo;

/**
 * @Author：CM
 * @Package：tests.cloneDemo
 * @Project：JavaReview
 * @name：A
 * @Date：2023/5/26 22:02
 * @Filename：A
 */
public class A implements Cloneable{

    private String str;

    private B b;

    public A(){
        System.out.println("调用了A的构造方法");
        this.str = "aaa";
        b = new B();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public B getB(){
        return this.b;
    }
}
