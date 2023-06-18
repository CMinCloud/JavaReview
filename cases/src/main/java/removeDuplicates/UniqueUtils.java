package removeDuplicates;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author：CM
 * @Package：removeDuplicates
 * @Project：JavaReview
 * @name：UniqueUtils
 * @Date：2023/5/6 10:15
 * @Filename：UniqueUtils
 */
public class UniqueUtils {


    /**
     * 通过hashmap实现去重
     *
     * @param userBeanList
     */
    public static void handleRepeatByHashMap(List<UserBean> userBeanList) {
        Map<String, UserBean> map = new HashMap<>();
        for (UserBean userBean : userBeanList) {
//            直接put是通过覆盖先前的元素来实现去重
            map.put(userBean.getName(), userBean);
//            先containsKey判断就可以保留后面的元素
            if (!map.containsKey(userBean.getName())) {
                map.put(userBean.getName(), userBean);
            }
        }
        Collection<UserBean> values = map.values();
        values.forEach(System.out::println);
    }

    /**
     * 使用Stream流来过滤
     *
     * @param userBeanList
     */
    public static void handleRepeatByStream(List<UserBean> userBeanList) {
        /*这种方式是根据集合元素地址去重*/
//        List<UserBean> collect = userBeanList.stream().distinct().collect(Collectors.toList());

        /*着种方式根据集合元素的某一个属性来进行去重*/
        userBeanList = userBeanList.stream().collect(Collectors
                .collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(UserBean::getName))),
                        ArrayList::new));
        System.out.println(userBeanList);
    }


    /**
     * 通过treeSet去重
     *
     * @param userBeanList
     */
    public static void handleRepeatByTreeSet(List<UserBean> userBeanList) {
        /*上面使用stream流本质还是使用了TreeSet，因此一般直接使用treeSet去重就好*/
        TreeSet<UserBean> treeSet = new TreeSet<>(Comparator.comparing(UserBean::getName));
        treeSet.addAll(userBeanList);
        for (UserBean userBean : treeSet) {
            System.out.println(userBean);
        }
    }


}
