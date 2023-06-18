package leetcode.day2;

import leetcode.day1.ListNode;

public class addList {
    public static void main(String[] args) {

    }
}

class Solutions {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list = new ListNode();
        ListNode node = list;           //创建一个指针指向当前节点
        while (list1 != null && list2 != null) {
            ListNode temp = new ListNode();
            if (list1.val >= list2.val) {
                temp.val = list1.val;
                list1 = list1.next;
            } else {
                temp.val = list2.val;
                list2 = list2.next;
            }
            node = temp;    //拼接新字符串
            node = node.next;
        }
        return list;
    }
}
