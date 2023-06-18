package iterator;

import java.util.List;
import java.util.Objects;

/**
 * @Author：CM
 * @Package：iterator
 * @Project：JavaReview
 * @name：Student
 * @Date：2023/4/29 13:21
 * @Filename：Student
 */
public class Student {


    private String name;
    private String number;

    public Student(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    @Override
    public boolean equals(Object obj) {

        if (obj == this) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student stu = (Student) obj;
        return Objects.equals(this.name, stu.getName()) && Objects.equals(name, stu.name);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
