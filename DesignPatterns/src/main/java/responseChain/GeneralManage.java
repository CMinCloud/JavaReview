package responseChain;

/**
 * @Author：CM
 * @Package：responseChain
 * @Project：JavaReview
 * @name：GroupLeader
 * @Date：2023/4/28 12:26
 * @Filename：GroupLeader
 */
public class GeneralManage extends Handler{

//    使用父类的构造方法
    public GeneralManage(){
        super(NUM_THREE,Handler.NUM_SEVEN);
    }

    @Override
    protected void handleLeave(LeaveRequest request) {
        System.out.println(request.getName()+"请假"+request.getNum()+"天，请假理由："+request.getContent());
        System.out.println(this);
    }
}
