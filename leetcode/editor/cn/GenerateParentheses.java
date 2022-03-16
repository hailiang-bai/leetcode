//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2454 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> lists = new ArrayList<>();
        trackBack(n,n,lists,new StringBuffer());
        return lists;
    }

    private void trackBack( int left, int right, ArrayList<String> lists, StringBuffer stringBuffer) {
        if(left==0){
            for (int i = 0; i < right; i++) {
                stringBuffer.append(")");
            }
            lists.add(stringBuffer.toString());
            return;
        }
        stringBuffer.append("(");
        int length = stringBuffer.length();
        trackBack( left-1, right,lists,stringBuffer);
        stringBuffer.delete(length-1,stringBuffer.length());

        if(right>left){
            stringBuffer.append(")");
            trackBack(left,right-1,lists,stringBuffer);
            stringBuffer.delete(length-1,stringBuffer.length());
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new GenerateParentheses().new Solution();
        solution.generateParenthesis(3);
    }
}