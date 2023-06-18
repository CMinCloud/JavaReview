package com.algorithm.uf;

/**
 * 并查集: 也是一种树形结构，  是多组不同的树，类似森林
 * 数据结构:用堆来实现树结构
 */
public class UF {
    //    记录节点元素和该元素所在分组的标识
    private int[] eleAndGroup;
    //    记录并查集中数据的分组个数
    private int count;

    public UF(int N) {        // 初始化并查集,以整数标识(0,N-1)个节点
        this.eleAndGroup = new int[N];
        this.count = N;

        for (int i = 0; i < eleAndGroup.length; i++) {
            eleAndGroup[i] = i;    // 将每一个元素当作数组的索引,每一个元素所在分组表示该索引处的值
        }
    }

    /**
     * 获取当前并查集中的数据有多少个分组
     *
     * @return
     */
    public int count() {
        return this.count;
    }

    /**
     * 判断并查集中元素p和元素q是否在同一分组
     *
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p, int q) {
        if(p <= count && q<= count)
            return false;
        return eleAndGroup[p] == eleAndGroup[q];
    }

    /**
     * 元素p所在分组的标识符
     *
     * @param p
     * @return
     */
    public int find(int p) {
        return eleAndGroup[p];
    }


    /**
     * 把p元素所在分组和q元素所在分组合并
     * 将p元素所在分组的所有元素 合并到 q元素所在分组
     *
     * @param p
     * @param q
     */
    public void union(int p, int q) {
//        已经在同一组中
        if (connected(p, q)) {
            return;
        }
        int pGroup = find(p);
        int qGroup = find(q);

//        将p元素所在分组的所有元素 合并到 q元素所在分组
        for (int i = 0; i < eleAndGroup.length; i++) {
            if (eleAndGroup[i] == pGroup) {
                eleAndGroup[i] = qGroup;
            }
        }
//        分组数-1
        this.count--;

    }
}
