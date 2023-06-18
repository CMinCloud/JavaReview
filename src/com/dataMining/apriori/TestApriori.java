package com.dataMining.apriori;


import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static com.dataMining.apriori.AprioriDemo.CONFIDENCE;


public class TestApriori {
    public static void main(String[] args) {
//        创建apriori算法方法类
        AprioriDemo aprioriDemo = new AprioriDemo();
        Map<List<String>, Integer> frequentCollection = aprioriDemo.getFrequentCollection();
        System.out.println("-------------频繁集----------------");
        // 按候选项数目从低到高输出
        frequentCollection.keySet().stream().sorted(Comparator.comparingInt(List::size))
                .forEach(listKey -> System.out.println(listKey + ":" + frequentCollection.get(listKey)));

        Map<String, Double> relationRules = aprioriDemo.getRelationRules(frequentCollection);
        System.out.println("----置信度为" + CONFIDENCE + "关联规则" + "----------------");
        AtomicInteger i = new AtomicInteger();
//        按置信度从高到低排序打印
        relationRules.keySet().stream().
                sorted((o1, o2) -> relationRules.get(o2) - relationRules.get(o1) > 0 ? 1 : -1)
                .forEach(goods -> System.out.println((i.incrementAndGet())+": "+goods + "\t" + relationRules.get(goods)));
    }

}

