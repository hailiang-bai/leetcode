//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 有效括号组合需满足：左括号必须以正确的顺序闭合。 
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
// Related Topics 字符串 动态规划 回溯 👍 2113 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static sun.misc.Version.print;

public class GenerateParentheses {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis1(int n) {
            char[] chr=new char[2*n];
            ArrayList<String> strings = new ArrayList<>();

            diGui(chr,n,0,strings);

            return strings;
        }

        void diGui(char[] chr, int n, int index, ArrayList<String> strings) {
            if(chr.length==index){
                if(isVid(chr)){
//                    strings.add(chr.toString());
                    strings.add(new String(chr));
                }
            }else {
                chr[index]='(';
                diGui(chr,n,index+1,strings);
                chr[index]=')';
                diGui(chr,n,index+1,strings);
            }
        }

         boolean isVid(char[] chr) {
            int balance=0;
             for (int i = 0; i < chr.length; i++) {
                 if(chr[i]=='('){
                     balance++;
                 }else {
                     balance--;
                 }
                 if(balance <0){
                     return false;
                 }
             }
             if (balance==0){
                 return true;
             }
             return false;
        }
        public List<String> generateParenthesis(int n) {
            ArrayList<String> strings = new ArrayList<>();
            generateAll(strings,new StringBuffer(),n,0,0);
            return strings;
        }

        void generateAll(ArrayList<String> strings, StringBuffer stringBuffer, int max,int start,int end) {
            if(stringBuffer.length()==max *2){
                strings.add(stringBuffer.toString());
                return;
            }
            if(start<max){
                stringBuffer.append('(');
                generateAll(strings,stringBuffer,max,start+1,end);
                stringBuffer.deleteCharAt(stringBuffer.length()-1);
            }
            if(end< start){
                stringBuffer.append(')');
                generateAll(strings,stringBuffer,max,start,end+1);
                stringBuffer.deleteCharAt(stringBuffer.length()-1);

            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        List<String> strings = solution.generateParenthesis1(3);
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
