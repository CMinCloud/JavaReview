package iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：CM
 * @Package：iterator
 * @Project：JavaReview
 * @name：StudentAggregateImpl
 * @Date：2023/4/29 13:33
 * @Filename：StudentAggregateImpl
 */
public class StudentAggregateImpl implements StudentAggregate {

    private List<Student> list = new ArrayList<>();


    @Override
    public void addStudent(Student student) {
        list.add(student);
    }

    @Override
    public void removeStudent(Student student) {
/*        StudentIterator iterator = getIterator();
        while (iterator.hasNext()) {
            if (iterator.next() == student) {
                iterator.remove();
                break;
            }
        }*/
        list.remove(student);
    }

    @Override
    public StudentIterator getIterator() {
        return new StudentIteratorImpl<>(this.list);
    }
}
