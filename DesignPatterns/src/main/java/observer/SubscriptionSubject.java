package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：CM
 * @Package：observer
 * @Project：JavaReview
 * @name：SubscriptionSubject
 * @Date：2023/4/23 16:51
 * @Filename：SubscriptionSubject（被观察者的具体实现类）
 */
public class SubscriptionSubject implements Subject {

//    存储订阅微信公众号的用户
    private List<Observer> weixinUserList = new ArrayList<>();


    @Override
    public void attach(Observer observer) {
        weixinUserList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        weixinUserList.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : weixinUserList) {
            observer.update(message);
        }
    }
}
