package leetcode.day2;

import java.util.*;

public class deleteDuplicatedEle {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        for (int num : nums) {
            System.out.print(num + " ");
        }
        int i = Solution.removeDuplicates(nums);
        System.out.println("\n相差长度：" + i);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }


}

class Solution {
    public static int removeDuplicates(int[] nums) {

/*       Set<Integer> set = new LinkedHashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int index = 0;
        for (Integer integer : set) {
            nums[index++] = integer;
        }
        return index;*/
        if (nums.length == 0) {
            return 0;
        }
//          数组不为空的情况
        int size = 1;
        for (int index = 0, fast = 0; fast < nums.length - 1; ) {
            if(nums[fast] != nums[fast+1] && nums[fast+1] > nums[index]){
                nums[++index] = nums[fast+1];
                size++;
            }else {
                fast++;
            }
        }
        return size;
    }
}
