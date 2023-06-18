package ListSort;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author：CM
 * @Package：ListSort
 * @Project：JavaReview
 * @name：sort
 * @Date：2023/5/6 9:07
 * @Filename：sort
 */
public class sort {

    public static void main(String[] args) {
        List<UserBean> userBeanList = new ArrayList<>();

        UserBean bob1 = new UserBean(1, "bob", 17, "2005-11-02");
        UserBean jane1 = new UserBean(1, "jane", 19, "2003-11-02");
        UserBean kangkang1 = new UserBean(5, "kangakang", 21, "2001-12-02");
        UserBean alice1 = new UserBean(1, "alice", 20, "2002-11-02");
        UserBean jane2 = new UserBean(1, "jane", 19, "2003-11-02");
        UserBean jack1 = new UserBean(1, "jack", 18, "2004-11-02");
        UserBean bob2 = new UserBean(1, "bob", 17, "2005-11-02");

        userBeanList.add(bob1);
        userBeanList.add(kangkang1);
        userBeanList.add(alice1);
        userBeanList.add(jane2);
        userBeanList.add(jane1);
        userBeanList.add(jack1);
        userBeanList.add(bob2);

//        这里实现的是Arrays的内部类，并没有实现集合的修改方法
        List<UserBean> userBeanList1 = Arrays.asList(bob1, jane1, kangkang1, alice1, jane2, jack1, bob2);


//        使用comparator接口实现list排序
//        sortByComparator(userBeanList);

//        使用stream流来排序
//        sortByStream(userBeanList);

//        userBean实现comparable接口实现排序
        sortByComparable(userBeanList);



    }


    /**
     * 使用comparator接口实现list排序
     * @param userBeanList
     */
    public static void sortByComparator(List<UserBean> userBeanList) {
        Collections.sort(userBeanList, new Comparator<UserBean>() {
            @Override
            public int compare(UserBean o1, UserBean o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println(userBeanList);
    }

    /**
     * 使用stream流来排序
     */
    public static void sortByStream(List<UserBean> userBeanList) {
        userBeanList = userBeanList.stream().sorted(new Comparator<UserBean>() {
            @Override
            public int compare(UserBean o1, UserBean o2) {
                return o1.getAge() - o2.getAge();
            }
        }).collect(Collectors.toList());
        System.out.println(userBeanList);
    }


    /**
     * 使用用户自实现的Comparable来排序，这样存入List会自动排序
     */
    public static void sortByComparable(List<UserBean> userBeanList){
//        如果实现了Comparable接口，调用自排序
        Collections.sort(userBeanList);
        System.out.println(userBeanList);
    }
}
