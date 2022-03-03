package leetcode.editor.cn.test;

public class mubiaohe494 {
    static void bag1(){
        int[] nums={1,1,1,1,1};
        int sum=0;
        int S=3;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        if(S>sum)return;
        if((S+sum)%2==1)return;
        int bagSize=(S+sum)/2;
        int[] dp = new int[bagSize + 1];
        dp[0]=1;
        for (int i = 0; i < nums.length ; i++) {
            for (int j = bagSize; j >=nums[i] ; j--) {
                dp[j] +=dp[j-nums[i]];
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(dp[i]);
        }
    }

    public static void main(String[] args) {
        bag1();
    }
}
