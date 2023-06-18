package com.algorithm.tree;


import com.algorithm.queue.Queue;

import java.util.Objects;

/**
 * 实现一个二叉查找树，新节点的key小于当前节点对的key则插入左节点，否则插入右节点
 *
 * @param <Key>
 * @param <Value>
 */
//  设置泛型，根据key来查询value
public class BinaryTree<Key extends Comparable<Key>, Value> {

    //    记录根节点
    private Node<Key, Value> root;
    //    记录树中元素的个数
    private int N;

    public BinaryTree() {
//        this.root = new Node<>(null, null, null, null);
    }


    //    设置节点
    private class Node<Key, Value> {
        private Key key;
        //        存储值
        private Value value;
        //        记录左子节点
        private Node<Key, Value> left;
        //        记录右子节点
        private Node<Key, Value> right;

        public Node(Key key, Value value, Node<Key, Value> left, Node<Key, Value> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 向树中插入一个键值对
     *
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        this.root = put(root, key, value);
    }

    /**
     * 给指定的树x上，添加键一个键值对，并返回添加后的！新树！
     *
     * @param x
     * @param key
     * @param value
     * @return
     */
    public Node<Key, Value> put(Node<Key, Value> x, Key key, Value value) {
//        1.插入当前树中没有一个节点，将新节点作为根节点
        if (Objects.isNull(x)) {
            N++;
            return new Node<>(key, value, null, null);
        }
//        2.当前树不为空：
//        2.1.新节点key小于当前节点key，插入左边
        if (key.compareTo(x.key) < 0) {
            x.left = put(x.left, key, value);
        }
//        2.2.新节点key大于当前节点key，插入右边
        else if (key.compareTo(x.key) > 0) {
            x.right = put(x.right, key, value);
        } else {
//        2.3新节点key等于当前节点key，直接替换
            x.value = value;
        }
        return x;
    }

    /**
     * 根据key，从树中找出对应的值
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
    public Value get(Node<Key, Value> x, Key key) {
        if (x == null) {
            return null;
        }
        if (key == x.key) {
            return x.value;
        } else if (key.compareTo(x.key) < 0) {
//            向左子树查找
            return get(x.left, key);
        } else {
            //            向右子树查找
            return get(x.right, key);
        }
    }

    /**
     * 根据key，删除树中对应的键值对
     *
     * @param key
     */
    public void delete(Key key) {
        delete(root, key);
    }

    /**
     * 删除指定树x上的键为key的键值对，并返回删除后的新树
     *
     * @param x
     * @param key
     * @return
     */
    public Node delete(Node<Key, Value> x, Key key) {
//        1.节点为空
        if (x == null) {
            return null;
        }
//        2.节点不为空,找到被删除元素右子树的最小节点
        if (key.compareTo(x.key) < 0) {

            x.left = delete(x.left, key);
        } else if (key.compareTo(x.key) > 0) {

            x.right = delete(x.right, key);
        } else {
            N--;        //提前减去
//            //        先找到被删除的节点
//            2.1 删除节点没有右子树
            if (x.right == null)
                return x.left;   //用左子树替代被删除节点
            if (x.left == null) {
                return x.right;   //直接用右子树替代被删除节点  ,如果左右均为空其实就返回了一个null
            } else {
//                找到被删除元素右子树的最小节点,以及最小节点的父节点（便于下一步删除）
                Node minNode = x.right;
                Node preNode = null;
                while (minNode.left != null) {
                    if (minNode.left.left == null) {
                        preNode = minNode;      // 最小节点的父节点
                    }
                    minNode = minNode.left;
                }
//                3.删除最小节点
//                3.1如果最小节点的右子树不为空，则将其赋给最小节点的父节点
                preNode.left = minNode.right;           //如果右节点为空直接为null
//                4.将被删除节点x替换为最小节点minNode
//                4.1 连接左右子树
                minNode.left = x.left;
                minNode.right = x.right;
//                4.2连接父节点
                x = minNode;
            }
        }
        return x;
    }


    /**
     * 查找整个树中的最小键
     *
     * @return
     */
    public Key minKey() {
        return (Key) minNode(root).key;
    }

    public Key maxKey() {
        return (Key) maxNode(root).key;
    }

    public Node maxNode(Node x) {
        if (x == null) {
            return null;
        }
        Node node = x;
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    /**
     * 找到最小键所在的节点
     *
     * @return
     */
    public Node minNode(Node x) {
        if (x == null) {
            return null;
        }
        Node node = x.left;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    /**
     * 获取树中元素的个数
     *
     * @return
     */
    public int size() {
        return N;
    }

    //    前序获取树中的所有键
    public Queue<Key> preErgodic() {
        Queue<Key> keys = new Queue<>();
        preErgodic(root, keys);          // 存储keys
        return keys;
    }

    //  前序获取树中的所有键，并放到Queue中
    public void preErgodic(Node x, Queue<Key> keys) {
        if (x == null) {
            return;
        }
//        将节点x存入keys中
        keys.enqueue((Key) x.key);

//        递归遍历左子树
/*        if (x.left != null) {
            preErgodic(x.left, keys);
        }
        if (x.right != null) {
            preErgodic(x.right, keys);
        }*/
        preErgodic(x.left, keys);
        preErgodic(x.right, keys);
    }

    /**
     * 中序遍历一般用的最多：按从小到大的顺序
     *
     * @return
     */
    public Queue<Key> midErgodic() {
        Queue<Key> keys = new Queue<>();
        midErgodic(root, keys);          // 存储keys
        return keys;
    }

    public void midErgodic(Node x, Queue<Key> keys) {
        if (x == null) {
            return;
        }
//        递归遍历左子树
        midErgodic(x.left, keys);
        //        将节点x存入keys中
        keys.enqueue((Key) x.key);
        midErgodic(x.right, keys);
    }


    /**
     * 层序遍历
     *
     * @return
     */
    public Queue<Key> layerErgodic() {
//        定义两个队列，分别存储树中的键 和  树中的节点
        Queue<Key> keys = new Queue<>();
        Queue<Node> nodes = new Queue<>();

//        存入根节点
        nodes.enqueue(root);
        while (!nodes.isEmpty()) {
//            弹出一个节点，并存储其key值
            Node node = nodes.dequeue();
            keys.enqueue((Key) node.key);
            if (node.left != null) {
//                存入左节点
                nodes.enqueue(node.left);
            }
            if (node.right != null) {
//                存入右节点
                nodes.enqueue(node.right);
            }
        }
        return keys;
    }

    public Queue<Key> layerErgodic2() {
        Queue<Key> keys = new Queue<>();
        Queue<Node> nodes = new Queue<>();

        if (root == null) {
            return keys;
        }
        keys.enqueue(root.key);
        nodes.enqueue(root);

        while (!nodes.isEmpty()) {
            Node node = nodes.dequeue();
            if(node.left != null){
                keys.enqueue((Key) node.left.key);
                nodes.enqueue(node.left);
            }
            if(node.right != null){
                keys.enqueue((Key) node.right.key);
                nodes.enqueue(node.right);
            }
        }
        return keys;
    }


    /**
     * 获取整个树的最大深度
     *
     * @return
     */
    public int maxDepth() {
        return maxDepth(root);
    }

    /**
     * 获取指定树的最大深度
     *
     * @param x
     * @return
     */
    public int maxDepth(Node x) {
        if (x == null) {
            return 0;
        }
        int left = 0;
//        计算左子树最大节点
        if (x.left != null) {
            left += maxDepth(x.left);
        }
        int right = 0;
//        计算右子树最大节点
        if (x.right != null) {
            right += maxDepth(x.right);
        }
//        比较左右子树最大节点，取更大的 + 1（当前层）一个返回
        return left > right ? left + 1 : right + 1;
    }


}
