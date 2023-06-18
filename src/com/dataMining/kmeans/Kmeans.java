package com.dataMining.kmeans;

import java.io.*;
import java.util.*;

public class Kmeans {

    private List<Consumption> consumptionList = new ArrayList<>();      // 存储消费清单样本

    //    分别存储三个类别的样本清单,Integer作为类别区分
    private Map<Integer, List<Consumption>> consumptionType = new HashMap<>();

    private Map<Integer, double[]> center = new HashMap<>();  //定义中心点

    /**
     * 使用构造方法对样本数据初始化，
     * 并封装为List<Consumption>
     */
    public Kmeans() {

        BufferedReader br = null;
        try {
            File file = new File("src/com/dataMining/kmeans/consumption.csv");
            br = new BufferedReader(new FileReader(file));

            String line;
//            读取文件
            while ((line = br.readLine()) != null) {
                String[] attrs = line.split(",");
                consumptionList.add(new Consumption(Integer.parseInt(attrs[0]), Integer.parseInt(attrs[1])
                        , Integer.parseInt(attrs[2]), Double.parseDouble(attrs[3])));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        初始化聚类中心(默认保留两位小数)
//        将聚类中心值存储为list(是一个三维点集)
        center.put(0, new double[]{10.0, 5.0, 200.00});
        center.put(1, new double[]{15.0, 10.0, 400.00});
        center.put(2, new double[]{20.0, 15.0, 800.00});
        Set<Integer> set = center.keySet();
        System.out.println("初始聚类中心:");
        for (Integer key : set) {
            double[] doubles = center.get(key);
            System.out.println(Arrays.toString(doubles));
        }
    }


    //    分配对象类别（依照聚类中心给消费清单样本做分类）
    public void classify() {
//        遍历consumptionList,比较距离三个聚类中心距离来进行分配
//        计算规则:三维坐标的曼哈顿距离
        Set<Integer> keySet = center.keySet();
        double[] v = new double[3];
//        清空原有记录
        consumptionType.clear();
        for (Consumption consumption : consumptionList) {
            for (Integer key : keySet) {
                double[] point = center.get(key);
                v[key] = Math.abs(consumption.getTime() - point[0])
                        + Math.abs(consumption.getFrequent() - point[1])
                        + Math.abs(consumption.getTotal() - point[2]);
            }
//            进行比较判断应该存入哪个类别
            int min;
            if (Double.compare(v[0], v[1]) < 0) {
                min = 0;
            } else min = 1;
            if (Double.compare(v[min], v[2]) > 0) {
                min = 2;
            }
//            获取该类别的集合
            List<Consumption> consumptions = consumptionType.get(min);
            if (consumptions == null) {
                consumptions = new ArrayList<>();

            }
            consumptions.add(consumption);
//            重新添加该类别集合
            consumptionType.put(min, consumptions);
        }
/*        Set<Integer> set = consumptionType.keySet();
        for (Integer integer : set) {
            List<Consumption> consumptions = consumptionType.get(integer);
            System.out.println(consumptionsm);
        }*/
    }

    //    根据最新的分类后的集合,生成新的聚类中心
    public void generateCenters() {
        Set<Integer> keySet = center.keySet();
        for (Integer key : keySet) {
//            遍历该类别中所有的consumption,重新计算聚类中心
            List<Consumption> consumptions = consumptionType.get(key);
            int R = 0, F = 0;
            double M = 0;
            for (Consumption consumption : consumptions) {
                R += consumption.getTime();
                F += consumption.getFrequent();
                M += consumption.getTotal();
            }
            int newR = R / consumptions.size();
            int newF = F / consumptions.size();
            double newM = M / consumptions.size();
            center.put(key, new double[]{newR, newF, newM});
        }
        System.out.println("聚类中心:");
        Set<Integer> set = center.keySet();
        for (Integer key : set) {
            double[] doubles = center.get(key);
            System.out.println(Arrays.toString(doubles));
        }
    }


    /**
     * 迭代调整
     */
    public void modify() {
//         当三个类别中的消费记录总数都不再变动时停止迭代
        classify();  //首先迭代第一次
        int count = 1;
        while (true) {
//            保留上一次迭代的消费清单数目
            int size0 = consumptionType.get(0).size();
            int size1 = consumptionType.get(1).size();
            int size2 = consumptionType.get(2).size();
            System.out.println("第" + count + "次迭代：类别1样本总数：" +
                    size0 + ";类别2样本总数：" + size1 + ";类别3样本总数:" + size2);
//            进行新一轮的迭代
            count++;
            generateCenters();      //生成新的聚类中心
            classify();
            if (consumptionType.get(0).size() == size0 || consumptionType.get(1).size() == size1
                    || consumptionType.get(2).size() == size2) {
                System.out.println("第" + count + "次迭代：类别1样本总数：" +
                        size0 + ";类别2样本总数：" + size1 + ";类别3样本总数:" + size2);
                System.out.println("迭代" + count + "次后聚合结果基本不变,可以认为聚合完成");
                break;
            }
        }
    }


    public static void main(String[] args) {

        Kmeans kmeans = new Kmeans();
        kmeans.modify();

    }
}
