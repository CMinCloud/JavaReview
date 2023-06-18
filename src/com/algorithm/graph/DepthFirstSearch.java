package com.algorithm.graph;

import com.algorithm.queue.Queue;

/**
 * 深度优先搜索,对某一节点的连通表中所有子节点进行深度遍历
 */
public class DepthFirstSearch {

    //    索引代表顶点，值表示当前顶点是否以及被搜索过
    private boolean[] marked;
    //    记录有多少个顶点与s顶点相同
    private int count;

    //    构造优先搜索对象，使用深度优先搜索查找出G图中s顶点的所有相通顶点
    public DepthFirstSearch(Graph G, int s) {
//        初始化为G的顶点数量
        this.marked = new boolean[G.V()];
        this.count = 0;
        dfs(G, s);
    }

    //   使用深度优先搜索找出G图中v顶点的所有相通顶点
    private void dfs(Graph G, int v) {
//        将顶点表示为已经搜索
        marked[v] = true;
//        深度遍历该顶点的子节点
        Queue<Integer> queue = G.adj(v);
        for (Integer integer : queue) {
            if (!marked[integer]) {
//                没有被搜索过,深度遍历其子节点
                dfs(G, integer);
            }
        }
//        相通顶点数目+1
        count++;
    }

    //    判断w顶点与s顶点是否相通
    public boolean marked(int w) {
        return marked[w];
    }

    //    获取与顶点s相同的所有顶点的总数
    public int count() {
        return count;
    }
}
