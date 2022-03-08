//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 动态规划 👍 1173 👎 0

package leetcode.editor.cn;

public class PartitionEqualSubsetSum{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        int half=sum/2;
        int[] dp = new int[half+1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = half; j >=nums[i]; j--) {
                dp[j]=Math.max(dp[j-nums[i]]+nums[i] ,dp[j]);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(dp[i]);
        }
        if(dp[half] == half){
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new PartitionEqualSubsetSum().new Solution();
        solution.canPartition(new int[]{1,5,11,5});
    }
}