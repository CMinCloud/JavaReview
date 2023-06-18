package com.algorithm.tree.blancetree;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class RedBlackTree<Key extends Comparable<Key>, Value> {

    //    根节点
    private Node<String, Integer> root;
    //树中元素个数
    private int N;
    //        表示红色连接（表示和父节点共同构成一个 3-节点）
    private static final boolean RED = true;
    //      表示黑色连接
    private static final boolean BLACK = false;

    public RedBlackTree() {
    }


    //    设置红黑树节点
    private class Node<Key, Value> {
        private Key key;
        //        存储值
        private Value value;
        //        记录左子节点
        private Node<Key, Value> left;
        //        记录右子节点
        private Node<Key, Value> right;

        //        判断父指向连接颜色
        private boolean color;


        public Node(Key key, Value value, Node<Key, Value> left, Node<Key, Value> right, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }

    /**
     * 判断当前节点的父指向连接是否位红色
     *
     * @param x
     * @return
     */
    private boolean isRed(Node x) {
        return x != null && x.color == RED;
    }

    /**
     * 左旋调整,当节点的右子树为红色需要左旋
     *
     * @return
     */
    private Node rotateLeft(Node h) {
//        获取h节点的右子节点x
        Node x = h.right;
//        h的右子树指向x的左子树
        h.right = x.left;
//        x的左子树指向h
        x.left = h;
//        x的color变为red（也是h的color）
        x.color = h.color;
//        h的color变为RED
        h.color = RED;
//
        return x;  //返回新的父节点
    }

    /**
     * 右旋调整
     *
     * @param h
     * @return
     */
    private Node rotateRight(Node h) {
        Node x = h.left;
//        h的左子树指向x的右子树
        h.left = x.right;
//        x的右子树指向h
        x.right = h;
//      x的color变为Black（也是h的color）
        x.color = h.color;
//        h的color变为RED(可能会不满足红黑树特征，右链出现红色，但之后颜色反转可以调整)
        h.color = RED;
//        返回新的父节点
        return x;
    }

    /**
     * 颜色反转，相当于完成拆分4-节点
     *
     * @param h
     */
    private void flipColors(Node h) {
//           h的两个子树的color变为black
        h.left.color = BLACK;
        h.right.color = BLACK;
//        h的color变为red
        h.color = RED;
    }


    /**
     * 在整个树上完成插入操作
     *
     * @param
     * @param key
     * @param val
     */
    public void put(Key key, Value val) {
        root = put(root, key, val);
//        每次插入将根节点颜色赋为black，防止修改到根节点改变颜色
        root.color = BLACK;
    }


    /**
     * 在指定树中，完成插入操作
     * 使用递归操作完成
     *
     * @param h
     * @param key
     * @return
     */
    private Node put(Node h, Key key, Value val) {
//        判断h是否为空，如果为空则直接返回一个Red的节点
        if (Objects.isNull(h)) {
            return new Node(key, val, null, null, RED);    //默认插入红色
        }
//        如果不为空，比较h左右子树的大小
        int flag = key.compareTo((Key) h.key);
        if (flag < 0) {
//            往左插入
            h.left = put(h.left, key, val);
        } else if (flag > 0) {
//            往右插入
            h.right = put(h.right, key, val);
        } else {
//            key已存在，发生值的替换
            h.value = val;
        }

//        当前节点左子节点为黑色，右子节点为红色，需要左旋
        if (!isRed(h.left) && isRed(h.right)) {
            h = rotateLeft(h);
        }
//        当前节点左子节点为红色，左子节点的左子节点也为红色（避免了二分查找树顺序插入出现的链表化问题 ）,需要右旋
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
//        当前节点的左子节点为红色右子节点也为红色，需要进行颜色反转
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }


//        返回添加了新子树后的h
        return h;
    }

    /**
     * 根据Key，从树中找出对应的值
     *
     * @param key
     * @return
     */
    public Value get(Key key) {
        return get(root, key);
    }

    /**
     * 从指定的树x中，找出key对应的值
     *
     * @param x
     * @param key
     * @return
     */
    private Value get(Node x, Key key) {
        if (Objects.isNull(x)) {
            return null;
        }
        while (!Objects.isNull(x)) {
            if (x.key == key) {
                return (Value) x.value;
            }
            if (key.compareTo((Key) x.key) < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return null;
    }


    public int size() {
        return this.N;
    }


}
