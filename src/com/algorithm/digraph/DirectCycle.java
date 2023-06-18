package com.algorithm.digraph;


/**
 * 检测有向图中是否有环，如果有环无法进行拓扑排序：因为起点和终点无法确定
 */
public class DirectCycle {

    //    所有代表顶点，值表示当前顶点是否已经作为起点被搜索
    private boolean[] isMarked;

    //    记录图中是否有环
    private boolean hasCycle;

    //    所有代表顶点，使用栈的思想，记录当前顶点有没有已经处于正在搜索的有向路径上
    private boolean[] onStack;

    public DirectCycle(DiGraph G) {
//        创建一个检测对象，检测图G中是否有环
        this.isMarked = new boolean[G.V()];
        this.hasCycle = false;
        this.onStack = new boolean[G.V()];

//        找到图中的每一个顶点，让每一个顶点作为start，调用一次dfs进行搜索
        for (int v = 0; v < G.V(); v++) {
            if (!isMarked[v]) {
                dfs(G, v);
            }
        }
    }

    //        基于深度优先搜索，检测G中是否有环
    private void dfs(DiGraph G, int v) {
        isMarked[v] = true;     // 表示当前节点已经作为起点开启过一次深度检测
        onStack[v] = true;      //入栈，表示再当前顶点的搜索链路中，该节点已被搜索过
        for (Integer w : G.adj(v)) {
//            使用递归深度遍历
            if (!isMarked[w]) {
                dfs(G, w);
            }
            if (onStack[w]) {
//                同一条链路中检测到相通节点
                hasCycle = true;
                return;
            }
        }
        onStack[v] = false;    //出栈
    }

    //    判断图中是否有环
    public boolean hasCycle() {
        return this.hasCycle;
    }


}
