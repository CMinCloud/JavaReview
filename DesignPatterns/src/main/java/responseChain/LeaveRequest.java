package responseChain;

/**
 * @Author：CM
 * @Package：responseChain
 * @Project：JavaReview
 * @name：请假条类
 * @Date：2023/4/28 12:18
 * @Filename：LeaveReuqest
 */
public class LeaveRequest {


    protected String name;
    protected int num;
    protected String content;

    public LeaveRequest(String name, int num, String content) {
        this.name = name;
        this.num = num;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
