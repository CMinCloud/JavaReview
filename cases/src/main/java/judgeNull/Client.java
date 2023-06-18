package judgeNull;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * @Author：CM
 * @Package：judgeNull
 * @Project：JavaReview
 * @name：Client
 * @Date：2023/5/7 16:09
 * @Filename：Client
 */
public class Client {



    public static void main(String[] args) {

        /*Optional测试*/
        testAssert(new User());
    }


    /**
     * 使用Optional判空
     * @param user
     */
    public static void testOptional(User user){
        Optional<User> optional = Optional.ofNullable(user);
        optional.map(User::getCompany)
                .map(Company::getAddress)
                .map(Address::getCountry)
                .orElseGet(new Supplier<String>() {
                    @Override
                    public String get() {
                        return "默认值";
                    }
                });
    }


    /**
     * 使用assert判空
     * @param user
     */
    public static void testAssert(User user){
        assert user != null :  "用户不可用为空";
        assert user.getCompany() != null : "公司不可以为空";
//        Objects.requireNonNull(user.getCompany(),"公司不可用为空！");

        System.out.println("aaa");
    }
}
