package com.algorithm.graph;


import com.algorithm.queue.Queue;

/**
 * 广度优先遍历
 */
public class BreadthFirstSearch {

    //    索引代表顶点，值表示当前顶点是否以及被搜索过
    private boolean[] marked;
    //    记录有多少个顶点与s顶点相同
    private int count;
    //    用队列来存储需要被遍历的节点以实现广度优先
    private Queue<Integer> waitedSearchQueue;


    //    初始化图:在构造阶段完成广度优先的建立
    public BreadthFirstSearch(Graph G, int v) {
        //        初始化为G的顶点数量
        waitedSearchQueue = new Queue<Integer>();
        this.marked = new boolean[G.V()];
        this.count = 0;
        waitedSearchQueue.enqueue(v);
        bfs(G, v);
    }


    //   使用深度优先搜索找出G图中v顶点的所有相通顶点
    private void bfs(Graph G, int v) {
//        入队列
        while (!waitedSearchQueue.isEmpty()) {
            Integer w = waitedSearchQueue.dequeue();   //出队列节点
            if (!isMarked(w)) {
                marked[w] = true;   //标记为true，表示已搜索过
                System.out.println("已连接" + w);
                //        相通顶点数目+1
                count++;
            }
            Queue<Integer> queue = G.adj(w);    //找到该节点的邻接表
            if (!queue.isEmpty()) {
                for (Integer i : queue) {
//                判断是否已经连通
                    if (!isMarked(i)) {
//                    未连通将每一个子节点入队列
                        waitedSearchQueue.enqueue(i);
                    }
                }
            }
        }
    }

    //    判断w顶点与s顶点是否相通
    public boolean isMarked(int w) {
        return marked[w];
    }

    //    获取与顶点s相同的所有顶点的总数
    public int count() {
        return count;
    }
}
