package tests;

/**
 * @Author：CM
 * @Package：tests
 * @Project：JavaReview
 * @name：isPalindrome
 * @Date：2023/5/27 0:34
 * @Filename：isPalindrome
 */
public class isPalindrome {
    public static void main(String[] args) {
        demo(121);
    }

    public static boolean demo(int x) {
        // 负数，或者个位为0的正整数
        if(x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        int y = 0;
        while(x != 0 ){
            y = y*10 + x%10;
            x /= 10;
        }
        return x == y;
    }
}
