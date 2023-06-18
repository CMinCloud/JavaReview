package leetcode.link;

public class isPalindrome {

    public static void main(String[] args) {
        ListNode head = new ListNode(1,null);
        head.next = new ListNode(2,null);

        boolean palindrome = new Solution2().isPalindrome(head);

    }
}


class Solution2 {
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return false;
        }

        int count = 0;
        ListNode node = null;       // 头插法得到倒叙链表
        ListNode l1 = head;
        while(head != null){
            head.next = node;
            node = head;
            head = head.next;
            count ++;
        }
        if(count % 2 != 0){
            return false;
        }
        while(node != null){
            if(node.val != l1.val){
                return false;
            }
            node = node.next;
            l1 = l1.next;
        }
        return true;
    }
}
