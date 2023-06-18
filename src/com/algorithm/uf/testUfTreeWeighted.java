package com.algorithm.uf;

import java.util.Scanner;

public class testUfTreeWeighted {

    public static void main(String[] args) {


        ufTreeWeighted uf = new ufTreeWeighted(5);

        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("请输入第一个要合并的元素");
            int p = in.nextInt();
            System.out.println("请输入第二个要合并的元素");
            int q = in.nextInt();

//            判断两个元素是否已经在同一组中
            if (uf.connected(p, q)) {
                System.out.println(p + "," + q + "两元素已经在同一组中");
            }

//            合并
            uf.union(p, q);
            System.out.println("-----合并后分组个数:" + uf.count());
        }

    }
}
