package com.algorithm.digraph;


import com.algorithm.stack.Stack;

import java.util.Objects;

/**
 * 拓扑排序实现
 */
public class TopoLogical {

    //    顶点的拓扑排序
    private Stack<Integer> order;

    //    构造拓扑排序对象
    public TopoLogical(DiGraph G) {
//        order = new Stack<>();
        DirectCycle directCycle = new DirectCycle(G);
        if (!directCycle.hasCycle()) {
            DepthFirstOrder depthFirstOrder = new DepthFirstOrder(G);
            order = depthFirstOrder.getReversePost();
        }
    }

    //    判断段图G是否有环
    public boolean hasCycle() {
        return Objects.isNull(order);
    }

    //    获取拓扑排序的所有顶点
    public Stack<Integer> order() {
        return order;
    }


}
