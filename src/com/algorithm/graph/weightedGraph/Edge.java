package com.algorithm.graph.weightedGraph;


/**
 * 加权边的实现：
 * 加权无向图的边不能直接用v-w两个顶点表示
 * 需要给每条边设置一个权重，因此采用一个对象来描述边
 */
public class Edge implements Comparable<Edge> {
    //    顶点1
    private final int v;
    //    顶点2
    private final int w;
    //    当前边的权重
    private final double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /**
     * 获取边的权重值
     *
     * @return
     */
    public double weight() {
        return this.weight;
    }

    //    获取边上的一个点
    public int either() {
        return this.v;
    }

    //    获取边上除了顶点vertex外的另一个顶点
    public int other(int vertex) {
        return this.v == vertex ? this.w : this.v;
    }

    /**
     * 比较当前边和参数that边的权重，如果当前边权重较大，返回1，相同反返回0
     * 如果当前权重小，返回-1
     * 实际上是在插入散列集合时做一个排序
     * @param o
     * @return
     */
    @Override
    public int compareTo(Edge o) {
        return this.weight >= o.weight() ? (this.weight == o.weight ? 0 : 1) : -1;
    }
}
