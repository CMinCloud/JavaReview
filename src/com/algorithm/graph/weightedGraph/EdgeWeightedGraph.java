package com.algorithm.graph.weightedGraph;


import com.algorithm.queue.Queue;

/**
 * 加权无向图的实现
 */
public class EdgeWeightedGraph {

    //    记录顶点数量
    private final int V;

    //    记录边的数量
    private int E;

    //    邻接表
    private Queue<Edge>[] adj;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new Queue[V];   //每个顶点都有一个队列存储相连通的边
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<>();
        }
    }

    //    获取图中顶点的数量
    public int V() {
        return this.V;
    }

    //    获取图中边的数量
    public int E() {
        return this.E;
    }

    //    向加权无向图中添加一条边
    public void addEdge(Edge e) {
//        让E同时出现在e的两个顶点的邻接表中
        int v = e.either();
        int w = e.other(v);

        adj[v].enqueue(e);
        adj[w].enqueue(e);
        E++;

    }

    //    获取和顶点v关联的所有边
    public Queue<Edge> adj(int v) {
        return adj[v];
    }


    //    获取加权无向图的所有边
    public Queue<Edge> edges() {
//        创建一个队列存储所有边
        Queue<Edge> allEdgesQueue = new Queue<>();
        for (int v = 0; v < V; v++) {
            for (Edge edge : adj[v]) {
                if (edge.either() < edge.other(v)) {
//                    讨巧的方法：每个顶点是用下标表示的，那么肯定一大一小
//                    判断小的时候才如队列，那么每条边只会添加一次
                    allEdgesQueue.enqueue(edge);
                }

            }
        }
        return allEdgesQueue;
    }
}
