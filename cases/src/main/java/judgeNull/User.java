package judgeNull;

/**
 * @Author：CM
 * @Package：judgeNull
 * @Project：JavaReview
 * @name：User
 * @Date：2023/5/7 15:53
 * @Filename：User
 */
public class User {

    private long id;

    private String name;

    private Integer age;

    private String birthday;

    private Company Company;

    public User(){

    }

    public User(long id, String name, Integer age, String birthday, judgeNull.Company company) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        Company = company;
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

    public judgeNull.Company getCompany() {
        return Company;
    }

    public void setCompany(judgeNull.Company company) {
        Company = company;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday='" + birthday + '\'' +
                ", Company=" + Company +
                '}';
    }
}
