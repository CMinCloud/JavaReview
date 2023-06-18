package com.algorithm.uf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class trafficProject {

    public static void main(String[] args) throws IOException {

//        构建一个缓冲流读取BufferReader
        BufferedReader br = new BufferedReader(new InputStreamReader(trafficProject.class
                .getClassLoader().getResourceAsStream("traffic_project.txt")));

//        读取第一行数据20
        int count1 = Integer.parseInt(br.readLine());
//        构建一个并查集对象
        ufTreeWeighted roads = new ufTreeWeighted(count1);
//        读取第二行数据7:当前已修建的公路条数
        int count2 = Integer.parseInt(br.readLine());
        String line;
        String[] nums;
        while ((line = br.readLine()) != null) {
//            获取两个数字
            nums = line.split(",");
            roads.union(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]));
        }
//        合并完之后打印当前的分组数目
        System.out.println("还需要新建:" + (roads.count() - 1) + "条公路");
//        调用并查集对象的union让两条道路相通
    }
}
