package com.algorithm.digraph;


import com.algorithm.stack.Stack;

/**
 * 顶点排序
 */
public class DepthFirstOrder {


    //    索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] isMarked;

    //    使用栈，存储顶点序列
    private Stack<Integer> reversePost;

    //    创建一个 顶点排序对象 ，生成顶点线性序列
    public DepthFirstOrder(DiGraph G) {
        this.isMarked = new boolean[G.V()];
        reversePost = new Stack<>();
//        遍历图中的每一个顶点，让每个顶点作为入口，完成一次深度优先搜索
        for (int v = 0; v < G.V(); v++) {
            if (!isMarked[v]) {
                dfs(G, v);
            }
        }
    }

    //    基于 深度优先搜索 ，生成顶点线性序列
    private void dfs(DiGraph G, int v) {
//        标记当前v已经作为statr被搜索过
        isMarked[v] = true;
//        通过循环深度搜索顶点v
        for (Integer w : G.adj(v)) {
            if (!isMarked[w]) {
                dfs(G, w);
            }
        }
 //        将该顶点入栈
        reversePost.push(v);
    }

    //   获取顶点线性序列
    public Stack<Integer> getReversePost() {
        return reversePost;
    }
}
