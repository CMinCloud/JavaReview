package leetcode.day3;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
  /*      int kthLargest = solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println("\n"+kthLargest);*/

/*        int[] prices1 = new int[]{6,1,3,2,4,7};
        int[] prices2 = new int[]{1,2,3,4,5,6};
        int[] prices3 = new int[]{7,6,4,3,1};
        int total = solution.maxProfit(prices3);
        System.out.println(total);*/


        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        solution.rotate(nums,k);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
}
