package com.algorithm.hash;


import com.algorithm.queue.Queue;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希表：哈希集合:hashset由hashmap实现
 */
public class HashSet<T> {

    //    通过数组+链表实现
    private HashMap<T, Object> map;

    //    用来填充map的value
    private static final Object PRESENT = new Object();


    public HashSet() {
//        初始化
        map = new HashMap<>();
    }

    public boolean contains(T v) {
        return map.containsKey(v);
    }

    public void add(T v) {
        map.put(v, PRESENT);
    }

    /**
     * 删除目标节点
     *
     * @param v
     */
    public void remove(T v) {
        map.remove(v);
    }


    @Override
    public String toString() {
        return map.toString();
    }
}
