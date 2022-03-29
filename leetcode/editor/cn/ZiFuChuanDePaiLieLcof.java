//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 字符串 回溯 👍 519 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;

public class ZiFuChuanDePaiLieLcof{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    ArrayList<String> list;
    public String[] permutation(String s) {
        StringBuffer sb = new StringBuffer();
        list = new ArrayList<>();
        boolean[] visited = new boolean[s.length()];
        traceBack(s,sb,visited);
        return list.toArray(new String[list.size()]);
    }

    private void traceBack(String s,  StringBuffer sb, boolean[] visisted) {
        if(sb.length()==s.length()){
            list.add(sb.toString());
            return;
        }else {

            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                if(!visisted[i]){

                    //剪枝条件
                    if( set.contains(s.charAt(i))){
                        continue;
                    }
                    set.add(s.charAt(i));
                    sb.append(s.charAt(i));
                    visisted[i]=true;
                    traceBack(s,sb,visisted);
                    sb.deleteCharAt(sb.length()-1);
                    visisted[i]=false;
                }

            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new ZiFuChuanDePaiLieLcof().new Solution();
        solution.permutation("aab");
    }
}