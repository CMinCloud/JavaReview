package observer;

/**
 * @Author：CM
 * @Package：observer
 * @Project：JavaReview
 * @name：Client
 * @Date：2023/4/23 16:53
 * @Filename：Client
 */
public class Client {

    public static void main(String[] args) {

/*        SubscriptionSubject subject = new SubscriptionSubject();
//       创建微信用户
        SubscriptionSubject mSubscriptionSubject=new SubscriptionSubject();
        //创建微信用户
        WeixinUser user1=new WeixinUser("孙悟空");
        WeixinUser user2=new WeixinUser("猪悟能");
        WeixinUser user3=new WeixinUser("沙悟净");
        //订阅公众号
        mSubscriptionSubject.attach(user1);
        mSubscriptionSubject.attach(user2);
        mSubscriptionSubject.attach(user3);
        //公众号更新发出消息给订阅的微信用户
        mSubscriptionSubject.notify("传智黑马的专栏更新了");*/


        //创建小偷对象
        Thief t = new Thief("隔壁老王");
        //创建警察对象
        Policemen p = new Policemen("小李");
        //让警察盯着小偷
        t.addObserver(p);       //为被观察者添加观察者对象
        //小偷偷东西
        t.steal();
    }
}
