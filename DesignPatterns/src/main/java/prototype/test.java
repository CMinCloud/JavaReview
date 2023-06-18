package prototype;

public class test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Candidate candidate = new Candidate();
        Candidate clone = (Candidate) candidate.clone();

        System.out.println(candidate  == clone);
//        判断clone对象的引用变量是否相同：true说明是浅拷贝
        System.out.println(candidate.getTestFiled() == clone.getTestFiled());

    }
}
