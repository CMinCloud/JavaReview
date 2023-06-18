package com.dataMining.bayes;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BayesClassify {

    public static String fileLoc = "src/com/dataMining/bayes/dataset.txt";    //文件地址
//    设置好瓜和坏瓜的前缀
    public static String PREFIX_GOOD = "Good:";
    public static String PREFIX_BAD = "Bad:";
    private static ArrayList<Melon> data;   // 存储测试数据

    private static Map<Boolean, Integer> typeCountMap;   //存储每个属性的个数

    private static Map<String, Integer> attrCountMap; //存储 每个属性对应其好瓜和坏瓜的个数,Boolean作为好坏的判定

//    使用静态代码块初始化静态数据
    static {
        data = new ArrayList<>();
        typeCountMap = new HashMap<>();
        attrCountMap = new HashMap<>();
        //    从dataset中读取文件并封装
        setData();
    }

    //    从dataset中读取文件并封装
    public static void setData() {
        File file = new File(fileLoc);
        BufferedReader br = null;
//        使用缓冲输入流读取文件内容
        try {
            br = new BufferedReader(new FileReader(file));
            String str;
            while ((str = br.readLine()) != null) {
//                将字符串拆分为属性并封装为Melon
                String[] attr = str.split(",");
                Melon melon = new Melon(
                        Integer.valueOf(attr[0]), attr[1], attr[2], attr[3], attr[4], attr[5]
                        , attr[6], ("是").equals(attr[7])
                );
                Boolean isGood = melon.getIsGood();
//              存储每个类别的个数(好瓜/坏瓜)
                if (isGood) {     //好瓜数目+1
                    typeCountMap.put(true, typeCountMap.getOrDefault(true, 0) + 1);
                } else {         // 坏瓜数目+1
                    typeCountMap.put(false, typeCountMap.getOrDefault(true, 0) + 1);
                }
//                存储各个属性对应的好/坏瓜个数
                addAttrCountMap(isGood, melon);
//                将该瓜信息填入list
                data.add(melon);
            }
        } catch (Exception e) {
            System.out.println("文件读取出错");
            e.printStackTrace();
        } finally {
            try {
                br.close();   //关闭流并刷新
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //                存储每个属性的个数
    public static void addAttrCountMap(Boolean isGood, Melon melon) {
        String prefix = isGood ? PREFIX_GOOD : PREFIX_BAD;
        String color = melon.getColor();
        attrCountMap.put(prefix + color, attrCountMap.getOrDefault(prefix + color, 0) + 1);
        String root = melon.getRoot();
        attrCountMap.put(prefix + root, attrCountMap.getOrDefault(prefix + root, 0) + 1);
        String sound = melon.getSound();
        attrCountMap.put(prefix + sound, attrCountMap.getOrDefault(prefix + sound, 0) + 1);
        String texture = melon.getTexture();
        attrCountMap.put(prefix + texture, attrCountMap.getOrDefault(prefix + texture, 0) + 1);
        String belly = melon.getBelly();
        attrCountMap.put(prefix + belly, attrCountMap.getOrDefault(prefix + belly, 0) + 1);
        String touch = melon.getTouch();
        attrCountMap.put(prefix + touch, attrCountMap.getOrDefault(prefix + touch, 0) + 1);
    }

    //    通过比较是好瓜的概率和坏瓜的概率来判断是否是好瓜
    public Boolean isGoodMelon(Melon melon) {
        return PropertyOfGoodorBad(true, melon) > PropertyOfGoodorBad(false, melon);
    }

    //    计算好瓜/坏瓜的概率
    public Double PropertyOfGoodorBad(Boolean isGood, Melon melon) {
        Integer typeCount = typeCountMap.get(isGood);
        //        获取P(Good/Bad)
        Double Ptype = typeCount.doubleValue() / Double.valueOf(data.size());
//       计算每个属性的P(attr| Good/Bad )
        String color = melon.getColor();
        Double Pcolor = PropertyOfAttr(isGood, color);
        String root = melon.getRoot();
        Double Proot = PropertyOfAttr(isGood, root);
        String sound = melon.getSound();
        Double Psound = PropertyOfAttr(isGood, sound);
        String texture = melon.getTexture();
        Double Ptexture = PropertyOfAttr(isGood, texture);
        String belly = melon.getBelly();
        Double Pbelly = PropertyOfAttr(isGood, belly);
        String touch = melon.getTouch();
        Double Ptouch = PropertyOfAttr(isGood, touch);
//      利用贝叶斯公式的原理计算概率p
        double p = Ptype * Pcolor * Proot * Psound * Ptexture * Pbelly * Ptouch;
        System.out.println((isGood ? "好瓜" : "坏瓜") + "的概率为:" + p);
        return p;
    }

    //    计算每个属性的P(attr|Good/Bad)
    public Double PropertyOfAttr(Boolean isGood, String attr) {
        String prefix = isGood ? PREFIX_GOOD : PREFIX_BAD;
//        获取好瓜/坏瓜的个数的转换为double类型
        double typeCount = typeCountMap.get(isGood).doubleValue();
//        获取好瓜/坏瓜中 存在该属性瓜的个数
        double i = attrCountMap.get(prefix + attr).doubleValue();
        return i / typeCount;
    }


    public static void main(String[] args) {
        BayesClassify bayes = new BayesClassify();      // 贝叶斯分类的实现类
//        青绿,稍蜷,浊响,清晰,凹陷,硬滑
        Melon melon = new Melon(null, "青绿", "稍蜷", "浊响",
                "清晰", "凹陷", "硬滑", false); //首先默认为坏瓜（不参与测评）
        Boolean isGood = bayes.isGoodMelon(melon);
        if (isGood) {
            System.out.println("所以该瓜是好瓜");
        } else {
            System.out.println("所以该瓜是坏瓜");
        }
    }
}
