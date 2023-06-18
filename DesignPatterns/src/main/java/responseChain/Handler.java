package responseChain;


/**
 * @Author：CM
 * @Package：responseChain
 * @Project：JavaReview
 * @name：Handler（管理者抽象类）
 * @Date：2023/4/28 12:18
 * @Filename：Handler
 */
public abstract class Handler {

    //    仅供当前包和其他包的子类使用
    protected static int NUM_ONE = 1;

    protected static int NUM_THREE = 3;

    protected static int NUM_SEVEN = 7;

    private int start;

    private int numEnd;

    private Handler nextHandler;


    public Handler(int start) {
        this.start = start;
    }

    public Handler(int start, int numEnd) {
        this.start = start;
        this.numEnd = numEnd;
    }

    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

//    子类不能重写
    public final void submit(LeaveRequest request){
//        进行审批
        if(this.nextHandler != null && request.getNum() > this.numEnd){
            this.nextHandler.submit(request);  //传递请求给下一个
        }else {
            handleLeave(request);
            System.out.println("流程结束");
        }

    }

    protected abstract void handleLeave(LeaveRequest request);
}
