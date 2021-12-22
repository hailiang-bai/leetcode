//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 👍 4232 👎 0

package leetcode.editor.cn;

public class LongestPalindromicSubstring{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {

        int len=s.length();
        //开数组,dp[i][j]表示是s[i....j]是否是回文
        boolean[][] dp = new boolean[len][len];
        //设置边界值
        if (len <2){
            return s;
        }
        int maxlen=1;
        int begin=0;
        for (int i = 0; i < len; i++) {
            dp[i][i]=true;
        }

        char[] charArray = s.toCharArray();
        for (int L = 2; L <= len; L++) {
            for (int i = 0; i < len; i++) {

                int j=L+i-1;

                if(j>=len){
                    break;
                }
                if(charArray[i] !=charArray[j]){
                    dp[i][j]=false;
                }else {
                    if(j-i <3){
                        //处理长度为3以下的字符串
                        dp[i][j]=true;
                    }else {

                        //如果dp[i][j]是回文，那么之前的也是回文
                        dp[i][j]=dp[i+1][j-1];
                    }
                }

                if(dp[i][j] &&j-i+1 >maxlen){
                    maxlen=j-i+1;
                    begin=i;
                }
            }
        }
        return s.substring(begin,begin+maxlen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new LongestPalindromicSubstring().new Solution();
        String s = solution.longestPalindrome("bb");
        System.out.println(s);
    }
}
