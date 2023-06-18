package leetcode.day1;

import java.util.Arrays;

public class runningSum {

    public static void main(String[] args) {
        int[] nums  = new int[]{1,2,3,4};
        int[] sums = runningSum3(nums);
        Arrays.stream(sums).forEach(System.out::println);
    }


    public static int[] runningSum(int[] nums) {
        int length = nums.length;
        int[] sums = new int[length];
        for(int i = 0;i<length;i++){
            for(int j = 0; j<=i;j++){
                sums[i] += nums[j];
            }
        }
        return sums;
    }

    public static int[] runningSum2(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    public static int[] runningSum3(int[] nums) {
        int item=0;
        int arr[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){

            for(int j=0;j<=i;j++){
                item=item+nums[j];     //重点在这里，每次修改一个整型变量而不依次 修改数组中的每一个值，高效率
            }
            arr[i]=item;
            item=0;
        }
        return arr;
    }
}

