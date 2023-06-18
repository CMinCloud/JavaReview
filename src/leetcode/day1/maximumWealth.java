package leetcode.day1;

public class maximumWealth {

    public static void main(String[] args) {
        int[][] accounts = {{1,2,3},{3,2,1}};
        System.out.println(Solutionss.maximumWealth(accounts));
    }


}

class Solutionss {
    public static int maximumWealth(int[][] accounts) {
        int amount = 0;
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            for (int j = 0; j < accounts[i].length; j++) {
                amount += accounts[i][j];
            }
            max = Math.max(amount,max);
            amount = 0;
        }
        return max;
    }
}
