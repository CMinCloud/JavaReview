package leetcode.day1;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void main(String[] args) {
        System.out.println("-----------创建链表---------------");
        ListNode head = Solution.createNode(new ListNode(0));

        ListNode temp;   //new一个节点来遍历，不影响节点顺序
        temp = head;
        while (temp.next != null) {
            temp = temp.next;          //遍历输出（不输出首节点）
            System.out.print(temp.val + " ");
        }

        System.out.println("\n-----------插入节点---------------");
        ListNode insertNode = Solution.insertNode(head, 5, 55);
        temp = insertNode;
        while (temp.next != null) {
            temp = temp.next;          //遍历输出（不输出首节点）
            System.out.print(temp.val + " ");
        }

        System.out.println("\n-----------删除节点---------------");
        ListNode deleteNode = Solution.deleteNode(head, 6);
        temp = deleteNode;
        while (temp.next != null) {
            temp = temp.next;          //遍历输出（不输出首节点）
            System.out.print(temp.val + " ");
        }

        System.out.println("\n-----------替换节点---------------");
        ListNode newNode = new ListNode(8888);
        ListNode replaceNode = Solution.replaceNode(head, 5, newNode);
        temp = replaceNode;
        while (temp.next != null) {
            temp = temp.next;          //遍历输出（不输出首节点）
            System.out.print(temp.val + " ");
        }

        System.out.println("\n-----------找寻中间节点---------------(包含头节点的值)");
        temp = replaceNode;
        while (temp.next != null) {
            temp = temp.next;          //遍历输出（不输出首节点）
            System.out.print(temp.val + " ");
        }
        ListNode middleNode = Solution.middleNode(head);
        temp = middleNode;
        System.out.println();
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;          //遍历输出（不输出首节点）

        }
    }
}


class Solution {

    //    创建链表
    public static ListNode createNode(ListNode head) {
        int[] arr = new int[]{1, 2, 3, 4, 5};

        ListNode node;  //创建一个变量来在移动过程中指向当前节点
        node = head;    //指向首节点

        for (int i : arr) {
            ListNode temp = new ListNode(i);   //创建一个新节点
            node.next = temp;    //将新节点接在尾节点后
            node = temp;   //指向下一个节点（新节点）   /  node = node.next;
        }
        return head;
    }


    //    插入节点
    public static ListNode insertNode(ListNode head, int index, int value) {  //index代表插入到 第几个节点后(不包括头节点)

        ListNode newNode = new ListNode(value);   //创建需要插入的节点

        ListNode node = head;     //用来移动过程中指向当前节点
//        默认第一个节点为0，不用考虑是否插在头节点前

        for (int i = 0; i < index; i++) {
            node = node.next;
        }   //移动到目标插入节点后

        newNode.next = node.next;
        node.next = newNode;

        return head;
    }


    //    删除节点（第一个节点为头节点后的节点开始）
    public static ListNode deleteNode(ListNode head, int index) {        //删除目标位置的节点
        ListNode node = head;    //新建一个节点指向当前节点

        if (index == 1) {
//            删除第一个节点
            head = node.next;
        } else {
            for (int i = 0; i < index - 1; i++) {
                node = node.next;    //遍历到需要删除的前一个节点位置处
            }
            ListNode temp = node.next;
            node.next = temp.next;
        }
        return head;
    }

    //    替换节点
    public static ListNode replaceNode(ListNode head, int index, ListNode newNode) {
        ListNode node = head;   //新建一个节点指向当前节点

//        遍历到需要替换的前一个节点位置
        for (int i = 0; i < index - 1; i++) {
            node = node.next;
        }

        ListNode temp = node.next;   //需要替换的节点位置
        newNode.next = temp.next;       //接上被删除元素的尾部
        node.next = newNode;        // 接上被删除元素的头部

        return head;
    }


    //返回链表的中间节点：

    /**
     * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     * 使用快指针慢指针方法，快指针走两布，慢指针走一步
     */
    public static ListNode middleNode(ListNode head) {
/*        ListNode node = head;   //新建一个节点指向当前节点位置
        ListNode temp = head;           //用来返回新链表
        int count = 0;
        while (node != null) {     //用来集数
            count++;
            node = node.next;
        }
//        System.out.println(count);      //打印节点个数
        if (count == 1) {
            return head;
        } else if (count % 2 != 0) {
            for (int i = 0; i < (count - 1) / 2; i++) {
                temp = temp.next;
            }
        } else {
            for (int i = 0; i < count / 2 ; i++) {
                temp = temp.next;
            }
        }
        return temp;*/
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null &&fast.next != null){   //一定要把fast ！= null放在起那面
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
