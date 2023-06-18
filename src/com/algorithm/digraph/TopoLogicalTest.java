package com.algorithm.digraph;

import com.algorithm.stack.Stack;

public class TopoLogicalTest {

    public static void main(String[] args) {
//        准备有向图
        DiGraph diGraph = new DiGraph(6);
        diGraph.addEdge(0,2);
        diGraph.addEdge(0,3);
        diGraph.addEdge(2,4);
        diGraph.addEdge(3,4);
        diGraph.addEdge(4,5);
        diGraph.addEdge(1,3);
//        DiGraph reverse = diGraph.reverse();      //反向图

//        通过TopoLogical对象对有向图中的顶点进行排序
        TopoLogical topoLogical = new TopoLogical(diGraph);
        Stack<Integer> order = topoLogical.order();
//        过去顶点的线性序列进行打印
        StringBuilder sb = new StringBuilder();
        for (Integer w : order) {
            sb.append(w).append("->");
        }
        int index = sb.lastIndexOf("->");
        String res = sb.substring(0, index).toString();
        System.out.println(res);


    }
}
