package com.algorithm.graph;

import com.algorithm.queue.Queue;

public class Graph {
    //    记录顶点数量
    private int V;
    //    记录边数目
    private int E;
    //    领接表:用自己当时实现的队列,每一个下标代表一个顶点，每一个队列存储与其相连的顶点
    private Queue<Integer> queue[];

    public Graph(int v) {
//        初始构造包含v个顶点但不包含边的图
        queue = new Queue[v];
        for (int i = 0; i < queue.length; i++) {
            queue[i] = new Queue<Integer>();
        }
        this.V = v;
    }

    //    获取图中顶点数量
    public int V() {
        return this.V;
    }

    //    获取图中边的数量
    public int E() {
        return this.E;
    }

    //    向途中添加一条边：v-w
    public void addEdge(int v, int w) {
//        无向图中的连接是双向的
        queue[v].enqueue(w);
        queue[w].enqueue(v);
        this.E++;
    }

    //    获取和顶点v相邻的所有顶点
    public Queue<Integer> adj(int v) {
        return queue[v];
    }
}
