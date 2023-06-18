package com.oop4.d3_collection_set;
import java.util.*;

public class CollectionsDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -(o1 - o2);     // return o2 - o1
            }
        });
        Integer set = list.set(3, 8);       // 会返回原先位置处的值
        System.out.println(set);

        System.out.println(list);
        Collections.swap(list,0,1);



//        打乱集合顺序
//        Collections.shuffle(list);
        System.out.println(list);

        System.out.println("---------------------");

//        一定要声明对象类型为LinkedList才能调用对应方法
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
//        将指定元素添加导开头
        linkedList.push(111);
        linkedList.push(222);
        linkedList.push(4568);
        System.out.println(linkedList.getLast());
        System.out.println(linkedList.getFirst());


    }
}
