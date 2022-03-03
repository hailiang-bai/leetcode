package leetcode.editor.cn.test;

public class lingqianduihuan322 {
    static void bag(){
        int[] coins={1,2,5};
        int amount=5;
        int[] dp = new int[amount + 1];
        dp[0]=0;
        for (int i = 1; i < dp.length; i++) {
            dp[i]=Integer.MAX_VALUE;
        }
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <=amount; j++) {
                if(dp[j-coins[i]]!=Integer.MAX_VALUE){
                    dp[j]=Math.min(dp[j-coins[i]]+1,dp[j]);
                }
            }
        }

    }

    public static void main(String[] args) {
        bag();
    }
}
