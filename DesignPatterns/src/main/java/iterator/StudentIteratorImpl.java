package iterator;

import java.util.List;

//    使用成员内部类，防止对外暴露迭代器
public class StudentIteratorImpl<T> implements StudentIterator {

    private List<Student> list;
    private int position;

    public StudentIteratorImpl(List<Student> list) {
        this.list = list;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < list.size();
    }

    @Override
    public Object next() {
        return list.get(position++);
    }
}