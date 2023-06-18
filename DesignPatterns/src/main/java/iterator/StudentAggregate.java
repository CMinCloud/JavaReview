package iterator;

/**
 * @Author：CM
 * @Package：iterator
 * @Project：JavaReview
 * @name：StudentAggregate
 * @Date：2023/4/29 13:32
 * @Filename：StudentAggregate
 */
public interface StudentAggregate {


    void addStudent(Student student);

    void removeStudent(Student student);

    StudentIterator getIterator();
}
