package leetcode.link;

public class swapNodes {

    public static void main(String[] args) {


        ListNode head = new ListNode(100,null);
        head.next = new ListNode(90,null);

        ListNode node = new Solution().swapNodes(head, 2);

        while(node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }


    }


}

class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        // 先遍历一遍看有多少节点
        int count = 0;
        ListNode node = head;
        while(node != null){
            count ++ ;
            node = node.next;
        }

 /*       if(count == 1){
            return head;
        }*/

        node = head;    //归位
        ListNode first = new ListNode(-1,null);  // 记录需要交换的两个节点
        ListNode last = new ListNode(-1,null);
        for(int i = 0; i < count ;i++ ){
            if(i == k-1){
                first = node;
            }
            if(i == count - k){
                last = node;
            }
            node = node.next;
        }

        int temp = first.val;
        first.val = last.val;
        last.val = temp;
        return head;
    }
}