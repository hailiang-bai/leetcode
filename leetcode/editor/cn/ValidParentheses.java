//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 👍 2722 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put(')','(');
        stringStringHashMap.put(']','[');
        stringStringHashMap.put('}','{');
        Stack<Character> stack = new Stack<>();
        if(s.length()%2==1){
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if(stringStringHashMap.get(s.charAt(i))!=null){
                if(stack.isEmpty()){
                    return false;
                }
                Character pop = stack.pop();
                if(stringStringHashMap.get(s.charAt(i))!=pop){
                    return false;
                }
            }
            else if(stringStringHashMap.get(s.charAt(i))==null){
                stack.add(s.charAt(i));
            }
        }
       return stack.isEmpty() ;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new ValidParentheses().new Solution();
        boolean valid = solution.isValid("){");
        System.out.println(valid);
    }
}
