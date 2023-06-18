package builder.demo2;

public class OuterClass {
    static {
        System.out.println("加载外部类");  //初始化时才会被加载，处事方法执行前执行
    }
    static class InnerClass{
        public InnerClass() {}
        static {
            System.out.println("加载静态内部类");      //在加载内部类的成员对象时加载(静态成员变量和方法)
        }
        static void innerMethod() {
            System.out.println("内部类的静态方法");
        }
        static int a;
    }

    public static void main(String[] args) {
        OuterClass out=new OuterClass();
        System.out.println("=============");
//		OuterClass.InnerClass.a=1;
        OuterClass.InnerClass.innerMethod();
    }

}
