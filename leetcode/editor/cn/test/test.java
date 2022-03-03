package leetcode.editor.cn.test;

public class test {
    static void bag(){
        int[] weight={1,3,4};
        int[] value={15,20,30};
        int bagWeight=4;

        int[] dp = new int[bagWeight + 1];
        for (int i : dp) {
            i=0;
        }

        for (int i = 0; i < weight.length ; i++) {
            for (int j = bagWeight; j >=weight[i] ; j--) {
                dp[j]=Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(dp[i]);
        }

    }

    public static void main(String[] args) {
        bag();
    }
}
