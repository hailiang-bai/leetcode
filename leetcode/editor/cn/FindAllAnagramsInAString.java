//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 797 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindAllAnagramsInAString{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int pLen=p.length();
        int sLen=s.length();
        String ubiqueKey = creatUniqueKey(p);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <= sLen - pLen; i++) {
            String substring = s.substring(i, i + pLen);
            String curUniqueKey = creatUniqueKey(substring);
            if(curUniqueKey.equals(ubiqueKey)){
                list.add(i);
            }
        }
        return list;
    }

    private String creatUniqueKey(String str) {
        int[] s=new int[26];
        for (int i = 0; i < str.length(); i++) {
            ++s[str.charAt(i)-'a'];
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < s.length; i++) {
            if(s[i]!=0){
                stringBuffer.append((char)(i+'a'));
                stringBuffer.append(s[i]);
            }
        }
        return stringBuffer.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new FindAllAnagramsInAString().new Solution();
        solution.findAnagrams("cbaebabacd","abc");
    }
}