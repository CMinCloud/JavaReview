package filterList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @Author：CM
 * @Package：removeDuplicate
 * @Project：JavaReview
 * @name：FilteringList
 * @Date：2023/5/6 9:49
 * @Filename：FilteringList
 */
public class FilteringList {


    /**
     * 使用list的stream进行过滤
     * @param userBeanList
     * @return 筛选满足条件的用户列表
     */
    public List<UserBean> filterBeanByStream(List<UserBean> userBeanList) {
        return userBeanList.stream().filter(userBean -> Objects.nonNull(userBean))      //先进行判空
                .filter(userBean -> userBean.getAge() >= 18).collect(Collectors.toList());
    }


    /**
     * for循环遍历元素，进行筛选
     *
     * @param userBeanList 用户列表
     * @return 筛选后满足条件的用户列表
     */
    public List<UserBean> filterBeanByFor(List<UserBean> userBeanList) {
        List<UserBean> newList = new ArrayList<>();
        for (UserBean userBean : userBeanList) {
            if (userBean.getAge() >= 18) {
                newList.add(userBean);
            }
        }
        return newList;
    }


    /**
     * 通过for-each来遍历（底层是通过iterator实现,有fail-fast机制）
     * @param userBeanList
     * @return
     */
    public List<UserBean> filterBeanByForEach(List<UserBean> userBeanList) {
        List<UserBean> newList = new ArrayList<>();
        userBeanList.forEach(userBean -> {
            if(userBean != null && userBean.getAge() >= 18){
                newList.add(userBean);
            }
        });
        return newList;
    }
}
