package prototype;

public class Candidate implements Cloneable{

    private TestFiled testFiled;


    public Candidate() {
        System.out.println("调用构造方法了捏~");
        testFiled = new TestFiled();
    }


    public TestFiled getTestFiled(){
        return testFiled;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        System.out.println("执行克隆方法");
        return super.clone();
    }
}
