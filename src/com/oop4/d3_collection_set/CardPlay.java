package com.oop4.d3_collection_set;

import java.util.*;

public class CardPlay {

    public static List<Card> cards = new ArrayList<>();

    /**
     * 做牌，使用静态代码块来初始化数据
     */
    static {
        String[] colors = {"♠", "♥", "♣", "♦"};
        String[] numbers = {"2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3"};
        for (String color : colors
        ) {
            for (int index = 0; index < numbers.length; index++) {
                cards.add(new Card(numbers[index], color, index));
            }
        }


        Card c1 = new Card("大王", "", -2);   //从0开始计算
        Card c2 = new Card("小王", "", -1);
        Collections.addAll(cards, c1, c2);  //将大小王加入牌组
    }

    public static void main(String[] args) {
//        洗牌
        washCards(cards);
//        发牌
        Set<List<Card>> listSet = divideCards(cards);
        char[] chars = new char[]{'A', 'B', 'C'};
        int i = 0;
        for (List<Card> list : listSet
        ) {
            //先进行个人手牌的排序
            sort(list);
//            展示手牌
            System.out.println("牌手" + chars[i++] + list + ",\t" + list.size() + "张牌");
        }
    }

    //    洗牌方法
    public static void washCards(List<Card> cards) {
        Collections.shuffle(cards);
    }

    //    分牌(发51张牌)
    public static Set<List<Card>> divideCards(List<Card> cards) {
        Set<List<Card>> sets = new HashSet();         //set是无序的，又进行了一次随机
//        以三个ArrayList存储三个玩家的牌
        List<Card> c1 = new ArrayList<>();
        List<Card> c2 = new ArrayList<>();
        List<Card> c3 = new ArrayList<>();
        for (int i = 0; i < cards.size() - 3; i++) {
//            通过取余分牌
            if (i % 3 == 0)
                c1.add(cards.get(i));
            else if (i % 3 == 1)
                c2.add(cards.get(i));
            else c3.add(cards.get(i));
        }
//        将三个玩家的牌存入set
        Collections.addAll(sets, c1, c2, c3);
//        返回洗牌后的集合
        return sets;
    }

    //    对个人手牌进行排序
    public static void sort(List<Card> MyCardList) {
        //            比较字符数字的ascii码值
        MyCardList.sort((o1, o2) -> o2.getTop() - o1.getTop());
    }

}
