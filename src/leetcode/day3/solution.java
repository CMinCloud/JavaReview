package leetcode.day3;

import java.util.*;

public class solution {

    /**
     * 先使用选择排序
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        int temp;
        int maxIndex;
        for (int i = 0; i < nums.length - 1; i++) {
            int maxValue = nums[i];
            maxIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] >= maxValue) {
                    maxValue = nums[j];
                    maxIndex = j;
                }
            }
            temp = nums[i];
            nums[i] = nums[maxIndex];
            nums[maxIndex] = temp;
        }
        for (int num : nums) {
            System.out.print(num + " ");
        }
        return nums[k - 1];
    }

    /**
     * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
     * <p>
     * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
     * <p>
     * 返回 你能获得的 最大 利润 。
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {

//        暴力解法：
/*              设置总理论total
            1、for i 遍历 prices
                   for j 遍历i 之后的元素

                        找到第一个 prices[j] > price[j+1]的元素

                        或者遍历到最后一个元素（递增数组）
                   买入i，在j卖出  （之后遍历从j开始，记住j的位置）
                   total = prices[j] - prices[i]

           2、 for i 遍历 prices，从j开始
                    同理
*/

/*
        假设每个交易日都进行买卖（而且知道相邻两天是否会涨跌）
        那么涨的两个交易日就买卖，不涨的就不买卖*/

//        其实就是将每两个交易日单独拎出来，涨就买卖，不涨就不买卖
        int total = 0;
        for(int i=0;i< prices.length - 1;i++){
            if(prices[i+1] > prices[i]){
//                股票升值，进行买卖
                total += prices[i+1] - prices[i];
            }
        }
        return total;
    }

    /**
     * 旋转数组，给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。   以下index代表下标，bottom = nums.length - 1
     *      当元素index轮转位置不超过 bottom时:index+k <= bottom元素轮转后位置为  index + k
     *      当元素index轮转后超过bottom时:index + k > bottom 元素位置 index + k - bottom -1
     *          bug   : 当轮转超过一轮后第二次超过bottom会出先溢出异常，所以这个方法不能用
     *
     *
     *       正解1：
     *              方法类似，使用临时数组记录nums轮转后的值，再将元素重新赋值给nuns
     *              这里计算新值使用 % 取余
     * @param nums
     * @param k
     */
//    新增一个数组来接受，时间复杂度为n，空间复杂度为n（新建了一个数组）
 /*   public static void rotate(int[] nums, int k) {
            if( nums.length == 1)    //无法轮转
                return;

        int bottom = nums.length;  //记录数组的最后一个位置（不是下标）
        int[] Nums = new int[nums.length];   //定义一个新数组来接收nums轮转后的元素

        for(int i = 0; i< nums.length ; i++){
            Nums[(i+k)%bottom] = nums[i];
        }
//        再对nums中的元素进行赋值
        for(int i = 0; i< nums.length; i++){
            nums[i] = Nums[i];
        }
    }*/

//    空间为O(1)的方法
//    将数组轮转k个位置,可以发现就是将数组末尾的  k%nums.length 个元素提到数组首部来,然后 其余元素向右移动 k%nums.length个位置
//    所以可以将数组先整体旋转,再反转 前 k%nums.length 个元素,之后反转剩余元素
    public static void rotate(int[] nums, int k ){
        int n = k% nums.length;    //n表示第几个元素,不是下标
        reverse(nums,0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
//        将前 k%nums.length 个元素反转
        reverse(nums,0,n-1);
        System.out.println(Arrays.toString(nums));
//        将其余元素(n+1,nums.length个元素反转)
        reverse(nums,n,nums.length - 1);
        System.out.println(Arrays.toString(nums));

    }

//    反转数组
    public static void reverse(int[] nums, int left, int right){   //left和right 表示需要反转的数组位置
        int temp;
        for(int i = left,  j = right; i<j; i++,j-- ){  //注意判定条件  i < j, 如果时 i!= j则在数组长度为偶数时报错
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }


}
