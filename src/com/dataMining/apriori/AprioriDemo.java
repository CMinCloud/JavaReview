package com.dataMining.apriori;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class AprioriDemo {

    public final static int SUPPORT = 2;         // 支持度阈值
    public final static double CONFIDENCE = 0.7; // 置信度阈值

    private List<List<String>> goodsList; //      顾客购买的商品列表，每一行包含多个商品

    public AprioriDemo() {
        init();      //    对goodsList进行初始化
    }

    public void init() {
//        读取dataset.txt中的购物商品清单
        File file = new File("src/com/dataMining/apriori/dataset.txt");
        goodsList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                // split[1]为需要的商品清单，存入list
                String[] split = line.split("\t", 2);
                goodsList.add(Arrays.asList(split[1].split(", ")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //    获取所有频繁项集
    public Map<List<String>, Integer> getFrequentCollection() {
        Map<List<String>, Integer> frequentCollectionMap = new HashMap<>();//所有的频繁集
        //合并频繁1项集
        frequentCollectionMap.putAll(getGood1FC());
        // 获取频繁1项集作为k的初始值，再递归去获取k+1项
        Map<List<String>, Integer> goodFcMap = getGood1FC();
        Map<List<String>, Integer> candidateCollection;
        while (goodFcMap != null && goodFcMap.size() != 0) {
            //获得k+1项候选集
            candidateCollection = getCandidateCollection(goodFcMap);

            //对候选项集进行累加计数
            for (List<String> candidate : candidateCollection.keySet()) {
                for (List<String> goodList : goodsList) {
                    boolean flag = true; // 用来判断交易中是否出现该候选项，如果出现，计数加1
                    for (String candidateItem : candidate) {
                        if (!goodList.contains(candidateItem)) {
                            flag = false;
                            break;           //跳出当前候选项candidate的遍历
                        }
                    }
                    if (flag) {
                        candidateCollection.put(candidate, candidateCollection.get(candidate) + 1);
                    }
                }
            }
            goodFcMap.clear();         // 清除暂代项，来填充>=支持度的频繁集项
            //从候选集中找到符合支持度的频繁集项
            for (List<String> candidate : candidateCollection.keySet()) {
                Integer fc = candidateCollection.get(candidate);
                if (fc >= SUPPORT) {
                    goodFcMap.put(candidate, fc);
                }
            }
            //合并当前频繁集到结果中
            frequentCollectionMap.putAll(goodFcMap);
        }
        return frequentCollectionMap;
    }

    //    根据频繁k项集,获取其频繁k+1项集
    private Map<List<String>, Integer> getCandidateCollection(Map<List<String>, Integer> goodFcMap) {
        Map<List<String>, Integer> candidateCollection = new HashMap<>();
        Set<List<String>> itemkSet1 = goodFcMap.keySet();
        Set<List<String>> itemkSet2 = goodFcMap.keySet();

        for (List<String> itemk1 : itemkSet1) {
            for (List<String> itemk2 : itemkSet2) {
                if (!itemk1.equals(itemk2)) {
//                    判断当前k集项是否包含另一个商品,如果包含直接进行下一次循环
                    for (String item : itemk2) {
                        if (itemk1.contains(item))
                            continue;
                        List<String> temp = new ArrayList<>(itemk1);
//                        合并为k+1项目
                        temp.add(item);
//                        对重复元素的结果去重
                        temp.sort(Comparator.naturalOrder());
                        candidateCollection.put(temp, 0);
                    }
                }
            }
        }
        return candidateCollection;
    }


    //    遍历获取1频繁集项
    private Map<List<String>, Integer> getGood1FC() {
        Map<List<String>, Integer> good1FCMap = new HashMap<>();
        //经过支持度筛选后，存储到频繁1项集
        Map<List<String>, Integer> ResultGoodFCMap = new HashMap<>();
//        用集合存储1集项， 并统计出现次数
        for (List<String> goods : goodsList) {
            for (String good : goods) {
                List<String> goodList = new ArrayList<>();
                goodList.add(good);
                good1FCMap.put(goodList, good1FCMap.getOrDefault(goodList, 0) + 1);
            }
        }
        //        筛选 支持度>=2  的集合项
        for (List<String> listKey : good1FCMap.keySet()) {
            Integer support = good1FCMap.get(listKey);
            if (support >= SUPPORT) ResultGoodFCMap.put(listKey, support);
        }
        return ResultGoodFCMap;
    }

    //    根据频繁集 构建 关联规则
    public Map<String, Double> getRelationRules(Map<List<String>, Integer> frequentCollectionMap) {
        Map<String, Double> relationRules = new HashMap<>();
        for (List<String> itmes : frequentCollectionMap.keySet()) {
            if (itmes.size() > 1) {
                double countAll = frequentCollectionMap.get(itmes);
                List<List<String>> result = getSubsets(itmes);//获得itmes的所有非空子集

                for (List<String> itemList : result) {
                    if (itemList.size() < itmes.size()) {//只处理真子集
//                        使用StringBuilder来拼接为字符串格式 的规则
                        StringBuilder reasonStr = new StringBuilder();//前置
                        StringBuilder resultStr = new StringBuilder();//结果
                        for (String item : itemList)
                            reasonStr.append(",").append(item);
                        for (String item : itmes)
                            if (!itemList.contains(item))
                                resultStr.append(",").append(item);
                        double countReason = frequentCollectionMap.get(itemList);
                        double itemConfidence = countAll / countReason;//计算置信度
                        if (itemConfidence >= CONFIDENCE) {
                            String rule = reasonStr.append(" -> ").
                                    append(resultStr.substring(1)).substring(1);
                            relationRules.put(rule, itemConfidence);
                        }
                    }
                }
            }
        }
        return relationRules;
    }

    //    获取所有非空子集
    private List<List<String>> getSubsets(List<String> sourceSet) {
        List<List<String>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < sourceSet.size(); i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<String> temp = new ArrayList<>(result.get(j));
                temp.add(sourceSet.get(i));
                result.add(temp);
            }
        }
        return result.subList(1, result.size());//去掉空集
    }

}
