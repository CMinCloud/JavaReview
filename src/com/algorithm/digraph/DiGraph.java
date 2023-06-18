package com.algorithm.digraph;


import com.algorithm.queue.Queue;

/**
 * 有向图的数据结构
 * 使用邻接表（存储队列的数组）
 */
public class DiGraph {

    //    记录定点数了
    private int V;

    //    记录边的数量
    private int E;

    //    邻接表：下标代表顶点，每一个顶点都包含一个邻接表
    private Queue<Integer>[] adj;


    public DiGraph(int V) {
//        创建一个包含V个顶点但不包含边的有向图
        this.adj = new Queue[V];
        this.E = 0;
        this.V = V;

        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<>();     //对数组中每一个队列初始化
        }

    }

    //    获取图中顶点数量
    public int V() {
        return this.V;
    }

    //    获取图中边的数量
    public int E() {
        return this.E;
    }

    //    向有向图中添加一条边 v->w：只需要w出现在v的邻接表中即可
    public void addEdge(int v, int w) {
        adj[v].enqueue(w);
        E++;
    }

    //    获取由v指出的边所连接的所有顶点
    public Queue<Integer> adj(int v) {
        return adj[v];
    }

    //    获取该图的反向图
    public DiGraph reverse() {
//        创建一个有向图对象，向新有向图中反向添加节点
        DiGraph reverse = new DiGraph(this.V);

        for (int v = 0; v < adj.length; v++) {
            for (Integer w : adj[v]) {   //原队列出队列,使  方向改为w->v
                reverse.addEdge(w, v);
            }
        }
        return reverse;
    }
}
