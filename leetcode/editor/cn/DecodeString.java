//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 
//输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 
//输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 
//输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 30 
// s 由小写英文字母、数字和方括号 '[]' 组成 
// s 保证是一个 有效 的输入。 
// s 中所有整数的取值范围为 [1, 300] 
// 
// Related Topics 栈 递归 字符串 👍 1055 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class DecodeString{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int ptr;

    public String decodeString(String s) {
        LinkedList<String> stack = new LinkedList<>();
        ptr=0;
        while (ptr<s.length()){
            char cur=s.charAt(ptr);
            //判断是否是数字
            if(Character.isDigit(cur)){
                String digits = getDigits(s);
                stack.add(digits);
            }else if(Character.isLetter(s.charAt(ptr))||'['==s.charAt(ptr)){
                stack.add(String.valueOf(s.charAt(ptr++)));
            }else {
                ptr++;
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stack.peekLast()) ){
                    sub.add(stack.removeLast());
                }
                stack.removeLast();
                Collections.reverse(sub);
                String subString = getStrings(sub);

                int repTime=Integer.parseInt(stack.removeLast());
                StringBuffer sb = new StringBuffer();
                while (repTime>0){
                    sb.append(subString);
                    repTime--;
                }
                stack.add(sb.toString());
            }
        }
        return getStrings(stack);
    }

    String getStrings(LinkedList<String> sub) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String s : sub) {
            stringBuffer.append(s);
        }
        return stringBuffer.toString();
    }


    String getDigits(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr))){
            stringBuffer.append(s.charAt(ptr++));
        }
        return stringBuffer.toString();
    }
}

//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new DecodeString().new Solution();
        String s = solution.decodeString("3[a2[c]]");
        System.out.println(s);
    }
}