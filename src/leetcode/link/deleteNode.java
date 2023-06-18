package leetcode.link;

/**
 * @Author：CM
 * @Package：leetcode.link
 * @Project：JavaReview
 * @name：deleteNode
 * @Date：2023/6/17 10:58
 * @Filename：deleteNode
 */
public class deleteNode {


    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(-99);
        head.next = node1; node1.next = node2;
        ListNode listNode = deleteNode(head, -99);
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }


    public static ListNode deleteNode(ListNode head, int val) {
        // 节点为空
        if (head == null) {
            return head;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode node = pre;
        // 遍历到目标节点的前一个位置
        while (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
                return pre.next;
            }
            node = node.next;
        }
        return pre.next;
    }
}

