package group;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * @Author：CM
 * @Package：group
 * @Project：JavaReview
 * @name：GroupData
 * @Date：2023/5/7 14:53
 * @Filename：GroupData
 */
public class GroupData {

    private static List<Grade> gradeList;

    static {
        Grade grade1 = new Grade("001", "Alice", "Class A", 89.50, 92.30, 85.80);
        Grade grade2 = new Grade("002", "Bob", "Class B", 76.20, 87.40, 93.00);
        Grade grade3 = new Grade("003", "Charlie", "Class C", 91.80, 88.70, 95.50);
        Grade grade4 = new Grade("004", "David", "Class A", 77.60, 84.90, 87.20);
        Grade grade5 = new Grade("005", "Elizabeth", "Class B", 91.90, 94.00, 89.50);
        Grade grade6 = new Grade("006", "Frank", "Class C", 82.40, 86.50, 91.80);
        Grade grade7 = new Grade("007", "Grace", "Class A", 88.00, 92.50, 93.50);
        gradeList = Arrays.asList(grade1, grade2, grade3, grade4, grade5, grade6, grade7);
    }


    /*根据list中元素的属性，对list集合进行分组*/
    public static void main(String[] args) {


        /*使用hashmap分组*/
//        groupByMap(gradeList);

        /*使用stream流分组*/
        groupByStream(gradeList);

        /*使用reduce分组*/
//        groupByReduce(gradeList);
    }


    /**
     * 根据班级进行分组，使用HashMap分组
     *
     * @param gradeList
     */
    public static void groupByMap(List<Grade> gradeList) {
        Map<String, List<Grade>> classMap = new HashMap<>();
        for (Grade grade : gradeList) {
            String className = grade.getStuClass();
            if (classMap.containsKey(grade.getStuClass())) {
                classMap.get(className).add(grade);
            } else {
                List<Grade> list = new ArrayList<>();
                list.add(grade);
                classMap.put(className, list);
            }
        }
        /*打印*/
        classMap.entrySet().stream().forEach(System.out::println);
    }



    /**
     * Java8以上，使用stream的groupingBy分组
     *
     * @param gradeList 要分组的数据列表
     * @return
     */
    public static void groupByStream(List<Grade> gradeList){
        Map<String, List<Grade>> map = gradeList.stream().filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Grade::getStuClass));

        map.entrySet().forEach(System.out::println);
    }


    /**
     * Java8以上，使用stream的reduce分组
     * <p>
     * reduce方法：从一个流中生成一个值
     * 参数一 identity：代表一个元素，它是归约reduce运算的初始值，如果流为空，则为此默认结果。
     * 参数二 Accumulator：归约reduce运算后的部分结果和流的下一个元素
     * 参数三 Combiner：当归约是并行化或累加器参数的类型与累加器实现的类型不匹配时，用于合并combine归约操作的部分结果的函数
     *
     * @param gradeList 要分组的数据列表
     * @return
     */
    public static void groupByReduce(List<Grade> gradeList) {
        HashMap<String, List<Grade>> res = gradeList.stream().filter(Objects::nonNull).reduce(
                new HashMap<String, List<Grade>>(),
                (map, grade) -> {
                    if (map.containsKey(grade.getStuClass())) {
                        map.get(grade.getStuClass()).add(grade);
                    } else {
                        List<Grade> list = new ArrayList<>();
                        list.add(grade);
                        map.put(grade.getStuClass(), list);
                    }
                    return map;
                },
                (stringListHashMap, stringListHashMap2) -> stringListHashMap
        );
        res.entrySet().forEach(System.out::println);

    }


}
