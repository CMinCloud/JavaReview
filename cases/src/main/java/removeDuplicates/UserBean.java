package removeDuplicates;

/**
 * @Author：CM
 * @Package：ListSort
 * @Project：JavaReview
 * @name：UserBean
 * @Date：2023/5/4 10:39
 * @Filename：UserBean
 */
public class UserBean/* implements Comparable<UserBean>*/{
    private long id;

    private String name;

    private Integer age;

    private String birthday;

    public UserBean(long id, String name, Integer age, String birthday) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday='" + birthday + '\'' +
                '}'+'\n';
    }

/*    @Override
    public int compareTo(UserBean o) {
        return this.getAge() - o.getAge();
    }*/
}
