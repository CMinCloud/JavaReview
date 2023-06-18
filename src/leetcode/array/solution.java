package leetcode.array;

import java.util.*;

public class solution {

    //给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；
// 如果数组中每个元素互不相同，返回 false 。
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i]))
                return true;
            else list.add(nums[i]);
        }
        new HashSet<>(list);
        return false;
    }

    //    直接转成hash数组，去除掉重复元素（但是因为没有声明引用变量，set会将整个list作为一个元素，size恒为1，所以不可以判断）


    //        1 1 2 2 4 5 5 6 6 连续三个不相等的时候，中间元素为目标元素
//        1 1 2 2 4
    public static int singleNumber(int[] nums) {
        // 除了目标元素，其余都成对出现，所以总数一定为奇数
        // 从0开始遍历， 比较 nums[i] 和 nums[i+1]
        // 1、当nums[i] != nums[i+1] != nums[i+2] 找到目标元素
        // 2、或者目标元素在最末尾

        Arrays.sort(nums);
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums[0] != nums[1]) {
            return nums[0];         // 返回第一个元素
        }
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] != nums[i + 1] && nums[i + 1] != nums[i + 2]) {
                return nums[i + 1];         //返回连续三个不相同元素的中间元素  ：中间位置
            }
        }
        return nums[nums.length - 1];    //返回最后一个元素
    }


    public static int[] intersect(int[] nums1, int[] nums2) {
//        遍历nums1，将nums1中的元素存入map 中的key，value存放其出现的次数
//        遍历nums2 ，查看nums2中的元素在map中的出现次数 ，如果map中存放有nums2的元素，则value--  并存入list
//        （最终 value >0 说明 nums1 的该元素多余nums2，交集取2； value <0 说明nums1的该元素少于nums2，交集取1）
        if (nums1.length == 0 || nums2.length == 0)
            return new int[0];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            if (!map.containsKey(i)) {
//                map1.put(i, map1.getOrDefault(i,0)+1);   //不存在就存入默认值0，否则+1
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) - 1);   //value --
                if (map.get(i) >= 0) {        //value >0 时才读入
                    list.add(i);
                }
            }
        }
//        将list转为int[]
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    //    错误原因 ： 当最后一位为0时，会出现格式错误  “12340” 无法转换为整型
//    public static int[] plusOne(int[] digits){
//        String s = "";
////        1、将数组元素拼接为字符串
//        for (int digit : digits) {
//            s += digit+"";
//        }
//
////        2、将字符串转换为Integer类型并+1
//        int num= Integer.parseInt(s) + 1;   //
//
////        3.重新转为字符串
//        String integer = Integer.toString(num);   //
//
//
////        4.将字符串转换成字符数组
//        char[] chars = integer.toCharArray();
//
//        int[] arr = new int[chars.length];   // 和字符数组长度一致
////        5.将字符数组录入整型数组
//        for(int i = 0;i<arr.length;i++){
//            arr[i] = Integer.parseInt(new String(String.valueOf(chars[i])));
//        }
//        return arr;
//    }
//    第二次尝试，考虑进位
    public static int[] plusOne(int[] digits) {

        // 1. [0] => [1]
//         2.  [1,2,3,9] => [1,2,4,0]
//        3.[1,9,9,9,9] = > [2,0,0,0,0]
//        4. [9,9,9,9] => [1,0,0,0,0]
//        5.[1,2,3] => [1,2,4]
//

//        1.普通情况，如果最后一位元素不为9，直接+1
//        2.逆序查找知道该元素不为9
        int flag = 0;  //判断是否找到不为9的元素
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
//                将之后的元素全部赋为0
                for (int j = i + 1; j < digits.length; j++) {
                    digits[j] = 0;
                }
                flag = 1;
                break;  //跳出循环
            }
        }
        if (flag == 0) {
            int[] arr = new int[digits.length + 1];
            arr[0] = 1;
            return arr;
        }
        return digits;
    }

    /*   移动零*/
    public static void moveZeroes(int[] nums) {
//        方法1：定义两个指针，一个在头部遍历，一个在最后
//        遍历到0的元素，则把该元素与末尾的元素交换位置，交换后末尾指针前移
//        不可行原因：会改变其他元素的相对位置

//        方法2：暴力移动数组，每读到一个0就把当前位置后一个元素和除末尾最后一个元素前移，将0添加到末尾元素
//        相当于每次发现0就删除该位置的元素，所有数组前移，然后把0 加到末尾
//        不可行原因：如果前移后该位置仍为0，则无效

//        方法3：把所有非零元素前移就行

//        方法4：如果读取到一个0，就把后面的元素往前覆盖就好

//        方法5：考虑双指针，一个count记录0的个数，用i来遍历， 当发现非0 元素，就 交换 i 和 i-count 位置处的元素，同时将i的元素归0
/*        1 0 2 0 0 3 5
        1 2 3 5 0 0 0
        1 2 3 5 0 0 0*/
        if (nums == null || nums.length == 0)
            return;
        int index = 0;         // 记录读取到的非零元素的位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {       // 判断当前位置是否是非零元素
                nums[index++] = nums[i];
            }
        }
//            后面的都是0
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    //    两数之和
    public static int[] twoSum(int[] nums, int target) {
        int[] twoNum = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    twoNum[0] = i;
                    twoNum[1] = j;
                }
            }
        }
        return twoNum;
    }


    public static boolean isValidSudoku(String[][] board) {

//        判断每一行
            for(int i = 0; i< 9; i++){
                HashSet setRow = new HashSet();
                HashSet setColume= new HashSet();
                HashSet setCeil= new HashSet();
                int countRow = 0;   // 记录有效数字个数
                int countColume = 0;
                int countCeil = 0;
                for(int j = 0; j<9 ;j++){
                    if( board[i][j] != "." ){   //对有效数字操作
                        setRow.add(board[i][j]);
                        countRow ++;
                    }
                    if( board[j][i] != "."  ){   //对有效数字操作
                        setColume.add(board[j][i]);
                        countColume ++;
                    }
                    int ceilRow = (i/3) *3 + (j/3);
                    int ceilColume = (i%3)*3 + j%3;
                    if(board[ceilRow][ceilColume] != "."){
                        setCeil.add(board[ceilRow][ceilColume]);
                        countCeil ++;
                    }
                }
                if(setRow.size() != countRow || setColume.size() != countColume || setCeil.size() != countCeil){  //判断行和列的有效数字是否重复
//                    说明有重复值
                    return false;
                }
            }
//        判断3x3的方格


        return true;
    }

}
