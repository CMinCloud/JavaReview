package com.algorithm.graph.path;


import com.algorithm.graph.Graph;
import com.algorithm.queue.Queue;
import com.algorithm.stack.Stack;

/**
 * 根据深度优先图 来实现路径查找
 * 类似路由表的实现，每个每个节点可以找到其上一个节点
 */
public class DepthFirstPaths {
    //    索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] isMarked;

    //    起点
    private int start;

    //    索引代表顶点，值代表从起点start到当前顶点路径上的最后一个顶点
    private int[] edgeTo;

    //    构造深度优先搜索对象，使用深度优先搜索找出G图中为s的所有路径
    public DepthFirstPaths(Graph g, int s) {
        this.isMarked = new boolean[g.V()];
        this.start = s;
        this.edgeTo = new int[g.V()];

//        先把路径连通起来
        dfs(g, start);
    }

    //    使用深度优先搜索找出G图中顶点v的所有相邻顶点
    private void dfs(Graph G, int v) {
//        先标记当前顶点是连通的
        isMarked[v] = true;
        Queue<Integer> nodes = G.adj(v);  // 找到v的所有相邻顶点
        for (Integer w : nodes) {
            if (!isMarked[w]) {
//                到达w的上一个顶点为v，类似计网里的路由表
                edgeTo[w] = v;
//                递归地去查询相邻节点（深度搜索）
                dfs(G, w);
            }
        }

    }

    //    判断顶点与s顶点是否存在路径
    public boolean hasPathTo(int v) {
        return isMarked[v];
    }

    //    找出从起点s到顶点v的路径（也就是该路径所经过的顶点）
//    利用栈先进后出的思想，从目标顶点往前找直到起点，出栈的顺序则是正确的路径
    public Stack<Integer> pathTo(int v) {

        Stack<Integer> stack = new Stack<>();
        while (v != start) {
            stack.push(v);
            v = edgeTo[v];   // 找到上一个节点
        }
        stack.push(start);  //别忘了将起点放入栈中

        return stack;
    }
}
