//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 2³¹ 
// 
// Related Topics 字符串 动态规划 👍 403 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class BaShuZiFanYiChengZiFuChuanLcof{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        if(s.length()==1){
            return 1;
        }
        int[] dp = new int[s.length()];
        dp[0]=1;
        int subNum = Integer.valueOf(s.substring(0, 2)) ;
        if(subNum<=25){
            dp[1]=2;
        }else
            dp[1]=1;

        for (int i = 2; i < s.length(); i++) {
            int integer = Integer.valueOf(s.substring(i - 1, i + 1));
            if(integer<=25 && integer>=10){
                dp[i]=dp[i-1]+dp[i-2];
            }else {
                dp[i]=dp[i-1];
            }
        }
        return dp[s.length()-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new BaShuZiFanYiChengZiFuChuanLcof().new Solution();
        solution.translateNum(12258);
        System.out.println(Integer.valueOf("06"));
    }
}