package iterator;

/**
 * @Author：CM
 * @Package：iterator
 * @Project：JavaReview
 * @name：Client
 * @Date：2023/4/29 13:35
 * @Filename：Client
 */
public class Client {

    public static void main(String[] args) {
        StudentAggregate studentAggregate = new StudentAggregateImpl();
        Student zs = new Student("zs", "1");
        Student ls = new Student("ls", "2");
        Student ww = new Student("ww", "3");
        Student zl = new Student("zl", "4");
        studentAggregate.addStudent(zs);
        studentAggregate.addStudent(ls);
        studentAggregate.addStudent(ww);
        studentAggregate.addStudent(zl);

        StudentIterator iterator = studentAggregate.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        studentAggregate.removeStudent(ls);
        System.out.println("after remove :"+ls);
        iterator = studentAggregate.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
