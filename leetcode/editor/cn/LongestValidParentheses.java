//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 栈 字符串 动态规划 👍 1510 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Stack;

public class LongestValidParentheses{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        if(s.length()==0||s.length()==1){
            return 0;
        }
        int length=0;
        int temp=0;
        boolean flag=true;
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> characterCharacterHashMap = new HashMap<>();
        characterCharacterHashMap.put(')','(');
        stack.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
           if (characterCharacterHashMap.get(s.charAt(i)) == null){
               if(flag==false){
                   length=length >temp ?length:temp;
                   temp=0;
               }
               stack.add(s.charAt(i));
               flag=false;
           }else {
               flag=true;
               if(stack.isEmpty()){
                   return length *2;
               }
               Character pop = stack.pop();
               if(characterCharacterHashMap.get(s.charAt(i)) != pop){
                   stack.push(pop);
                   stack.push(s.charAt(i));
               }else {
                   temp +=1;
               }

           }
            length=length >temp ?length:temp;
        }
        return length *2;
    }

    public int longestValidParentheses1(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int length=0;
        int max_length=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                stack.push(i);
            }else if(s.charAt(i)==')'){
                Integer pop = stack.pop();
                if(stack.isEmpty()){
                    stack.add(i);
                }else {

                    length=i-stack.peek();
                    max_length=Math.max(max_length,length);
                }

            }
        }
        return max_length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new LongestValidParentheses().new Solution();
        int i = solution.longestValidParentheses1(")()())");
        System.out.println(i);
    }
}
