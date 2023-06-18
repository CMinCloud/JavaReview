package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author：CM
 * @Package：leetcode.array
 * @Project：JavaReview
 * @name：threeSum
 * @Date：2023/6/4 21:14
 * @Filename：threeSum
 */
public class threeSum {


    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList();
        // 采用双指针，固定i，同时设立一个left和一个right来遍历i后的元素
        Arrays.sort(nums);   //排序之后便于判断
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {   //如果当前i>0，那么后面的不可能小于0了，直接返回
                return res;
            } else {
                // 设立左右指针
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int val = nums[i] + nums[left] + nums[right];
                    if (val < 0) {     //说明笑了，left++
                        left++;
                    } else if (val > 0) {  //说明大了，right--
                        right--;
                    } else {  //  nums[i] + nums[left] + nums[right] = 0
                        List<Integer> list = Arrays.asList(nums[i], nums[left], nums[right]);
                        res.add(list);
                        left++;
                        right--;
                        while (nums[left] == nums[left - 1] && left < right) left++;      //防止重复
                        while (nums[right] == nums[right + 1] && left < right) right--;    //防止重复
                    }
                }
                while (i < nums.length - 2 && nums[i + 1] == nums[i]) i++;  //防止重复值
            }
        }
        return res;
    }
}
