package responseChain;

/**
 * @Author：CM
 * @Package：responseChain
 * @Project：JavaReview
 * @name：Client
 * @Date：2023/4/28 12:59
 * @Filename：Client
 */
public class Client {


    public static void main(String[] args) {

        LeaveRequest leaveRequest = new LeaveRequest("zs", 4, "虚");
        GeneralManage generalManage = new GeneralManage();
        Manager manager = new Manager();
        GroupLeader groupLeader = new GroupLeader();

//        构建职责链
        groupLeader.setNextHandler(manager);
        manager.setNextHandler(generalManage);


//      向一级领导提交申请
        groupLeader.submit(leaveRequest);
    }
}
