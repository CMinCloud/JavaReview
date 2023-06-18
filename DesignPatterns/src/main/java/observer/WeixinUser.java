package observer;

/**
 * @Author：CM
 * @Package：observer
 * @Project：JavaReview
 * @name：WeixinUser
 * @Date：2023/4/23 16:47
 * @Filename：WeixinUser
 */
public class WeixinUser implements Observer {

    private String name;

    public WeixinUser(String name){
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "-" + message);
    }
}
