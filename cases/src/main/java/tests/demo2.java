package tests;

/**
 * @Author：CM
 * @Package：tests
 * @Project：JavaReview
 * @name：demo2
 * @Date：2023/5/22 22:57
 * @Filename：demo2
 */
public class demo2 {
    public static void main(String[] args) {
        climbStairs(4);
    }

    public static int climbStairs(int n) {

        // 使用递归超出时间限制,递归深度过大
        // if(n == 1) return 1;
        // else if (n == 2) return 2;
        // else return climbStairs(n-1) + climbStairs(n-2);
        int num = 0;
        if(n < 3){
            return n == 1 ? 1 : 2;
        }
        int l1 = 1;  //记录f(n-2)当前的值
        int l2 = 2;  //记录f(n-1)当前的值
        int temp;  //记录f(n)当前的值
        for(int i = 3; i<= n; i++){
            num = l1 + l2;
            temp = num;
            l1 = l2;
            l2 = temp;
        }
        return num;
    }
}
