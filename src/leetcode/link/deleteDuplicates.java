package leetcode.link;

public class deleteDuplicates {

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        ListNode head = new ListNode(1, null);
        ListNode p1 = new ListNode(1, null);
        ListNode p2 = new ListNode(1, null);
        ListNode p3 = new ListNode(2, null);
        ListNode p4 = new ListNode(3, null);
        ListNode p5 = new ListNode(4, null);
        ListNode p6 = new ListNode(4,null);
        ListNode p7 = new ListNode(4,null);

        head.next = p1; p1.next = p2; p2.next = p3; p3.next = p4; p4.next = p5; p5.next = p6; p6.next = p7;

        ListNode listNode = solution.deleteDuplicates(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }


}

class Solution3 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }

//        一个指针对另一个指针的操作不具有可靠性
        ListNode newHead = new ListNode(-1,head);
        ListNode cur = newHead.next;
        while(cur != null && cur.next != null){
            if(cur.val == cur.next.val){
                int v = cur.val;
                while(cur != null && cur.val == v){
                    cur = cur.next;
                }
            }else{
                cur = cur.next;
            }
        }

        return newHead.next;
    }
}
