package removeDuplicates;




import java.util.ArrayList;
import java.util.List;

/**
 * @Author：CM
 * @Package：removeDuplicates
 * @Project：JavaReview
 * @name：client
 * @Date：2023/5/6 10:16
 * @Filename：client
 */
public class client {


    public static void main(String[] args) {
        UserBean bob1 = new UserBean(1, "bob", 17, "2005-11-02");
        UserBean jane1 = new UserBean(1, "jane", 19, "2003-11-02");
        UserBean kangkang1 = new UserBean(5, "kangakang", 21, "2001-12-02");
        UserBean alice1 = new UserBean(1, "alice", 20, "2002-11-02");
        UserBean jane2 = new UserBean(1, "jane", 19, "2003-11-02");
        UserBean jack1 = new UserBean(1, "jack", 18, "2004-11-02");
        UserBean bob2 = new UserBean(1, "bob", 17, "2005-11-02");
        List<UserBean> userBeanList = new ArrayList<>();

        userBeanList.add(bob1);
        userBeanList.add(kangkang1);
        userBeanList.add(alice1);
        userBeanList.add(jane2);
        userBeanList.add(jane1);
        userBeanList.add(jack1);
        userBeanList.add(bob2);

//        System.out.println(userBeanList);
//        UniqueUtils.handleRepeatByHashMap(userBeanList);

//        UniqueUtils.handleRepeatByStream(userBeanList);

        UniqueUtils.handleRepeatByTreeSet(userBeanList);

//

    }


}
