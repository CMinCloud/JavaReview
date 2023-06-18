package leetcode.day1;

public class TurnintoZero {


    public static void main(String[] args) {
        System.out.println(Solutions.numberOfSteps(14));
    }


}

/**
 * 给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
 */
class Solutions{
    int count = 0;
    public static int numberOfSteps(int num) {
/*        int count = 0;
        while(num != 0){
            if(num % 2 ==0){
                num = num/2;
                count ++;
            }else {
                num --;
                count ++;
            }
        }
        return count;*/
        if(num == 0)
            return 0;
        else if(num % 2 == 0){
            //偶数
            return numberOfSteps(num/2);
        }else {
            return numberOfSteps(num-1);
        }
    }
}
