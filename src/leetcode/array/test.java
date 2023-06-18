package leetcode.array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class test {

    public static void main(String[] args) {

        String[][] board =
                new String[][]{{"5", "3", ".", ".", "7", ".", ".", ".", "."}
                        , {"6", ".", ".", "1", "9", "5", ".", ".", "."}
                        , {".", "9", "8", ".", ".", ".", ".", "6", "."}
                        , {"8", ".", ".", ".", "6", ".", ".", ".", "3"}
                        , {"4", ".", ".", "8", ".", "3", ".", ".", "1"}
                        , {"7", ".", ".", ".", "2", ".", ".", ".", "6"}
                        , {".", "6", ".", ".", ".", ".", "2", "8", "."}
                        , {".", ".", ".", "4", "1", "9", ".", ".", "5"}
                        , {".", ".", ".", ".", "8", ".", ".", "7", "9"}};

        boolean validSudoku = solution.isValidSudoku(board);
        System.out.println(validSudoku);
    }
/*        int{} nums = new int{}{1,1,1,3,3,4,3,2,4,2};
        boolean b = solution.containsDuplicate(nums);
        System.out.println(b);*/

//      只出现一次的数字
/*        int{} nums = new int{}{1 ,1 ,2 ,2 ,4 ,5 ,5 ,6 ,6};
        int i = solution.singleNumber(nums);
        System.out.println(i);*/

//        两个数组的交集 II
/*        int{} nums1 = new int{}{1,2,2,1,3};
        int{} nums2 = new int{}{2,2,3,3,1};
        int{} ints = solution.intersect(nums1, nums2);
        System.out.println(Arrays.toString(ints));*/

//          加一
/*        int{} nums = new int{}{9,9,9};
        int{} ints = solution.plusOne(nums);
        System.out.println(Arrays.toString(ints));*/


/*        给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
        请注意 ，必须在不复制数组的情况下原地对数组进行操作。*/
/*        int{} nums = new int{}{0,1,0,3,12};

        solution.moveZeroes(nums);

        System.out.println(Arrays.toString(nums));*/

/*       两数之和： 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
        你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
        你可以按任意顺序返回答案。*/
/*        int{} nums = new int{}{3,2,4};
        int{} sum = solution.twoSum(nums, 6);
        System.out.println(Arrays.toString(sum));*/


//        有效的数独
//        请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
//        数字 1-9 在每一行只能出现一次。
//        数字 1-9 在每一列只能出现一次。
//        数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。




}
