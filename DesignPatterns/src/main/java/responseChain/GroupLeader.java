package responseChain;

/**
 * @Author：CM
 * @Package：responseChain
 * @Project：JavaReview
 * @name：GroupLeader
 * @Date：2023/4/28 12:26
 * @Filename：GroupLeader
 */
public class GroupLeader extends Handler{

//    使用父类的构造方法
    public GroupLeader(){
        super(0,Handler.NUM_ONE);
    }

    @Override
    protected void handleLeave(LeaveRequest request) {
        System.out.println(request.getName()+"请假"+request.getNum()+"天，请假理由："+request.getContent());
        System.out.println(this);
    }
}
