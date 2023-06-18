package com.algorithm.graph.path;

import com.algorithm.graph.Graph;
import com.algorithm.stack.Stack;

import java.io.*;

public class DepthFirstPathTest {

    public static void main(String[] args) throws FileNotFoundException {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/com/algorithm/graph/path/road.txt")));
            Integer v = Integer.valueOf(br.readLine());
            Graph G = new Graph(v);  // 构建无向图
            Integer E = Integer.valueOf(br.readLine());

            String line;
            while ((line = br.readLine()) != null) {
                String[] node = line.split(" ");
//                建立连接
                G.addEdge(Integer.parseInt(node[0]), Integer.parseInt(node[1]));
            }

//        构建查找对象，起点为0
            DepthFirstPaths depthFirstPaths = new DepthFirstPaths(G, 0);
            if (depthFirstPaths.hasPathTo(4)) {
                Stack<Integer> stack = depthFirstPaths.pathTo(4);
                for (Integer node : stack) {
                    System.out.print(node+"-");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
