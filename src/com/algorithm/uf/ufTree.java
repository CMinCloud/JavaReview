package com.algorithm.uf;

/**
 * 并查集: 也是一种树形结构，  是多组不同的树，类似森林
 * 数据结构:用堆来实现树结构
 */
public class ufTree {
    //    记录节点元素和该元素所在分组的标识
    private int[] eleAndGroup;
    //    记录并查集中数据的分组个数
    private int count;

    public ufTree(int N) {        // 初始化并查集,以整数标识(0,N-1)个节点
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
     * 判断并查集中元素p和元素q是否在同一分组,通过网上查找根节点
     *
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p, int q) {
//        当元素所在分组=元素时,代表已经找到根节点了
        int pRoot = find(p);
        int qRoot = find(q);
        return pRoot == qRoot;
    }

    /**
     * 元素p所在分组的标识符
     *
     * @param p
     * @return
     */
    public int find(int p) {
        while (p != eleAndGroup[p]) {
            p = eleAndGroup[p];
        }
        return p;
    }


    /**
     * 把p元素所在分组和q元素所在分组合并
     * 将p元素所在分组的所有元素 合并到 q元素所在分组
     *
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        //        找到p和q所在树的根节点
        int pRoot = find(p);
        int qRoot = find(q);
//        已经在同一组中
        if (pRoot == qRoot) {
            return;
        }

//        将p元素所在分组的根节点的父节点  等于q元素所在分组的根节点
        eleAndGroup[pRoot] = qRoot;
//        分组数-1
        this.count--;

    }
}
