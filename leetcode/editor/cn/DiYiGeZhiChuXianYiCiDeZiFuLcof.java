//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例 1: 
//
// 
//输入：s = "abaccdeff"
//输出：'b'
// 
//
// 示例 2: 
//
// 
//输入：s = "" 
//输出：' '
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 队列 哈希表 字符串 计数 👍 197 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public class DiYiGeZhiChuXianYiCiDeZiFuLcof{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> map = new HashMap<>();
        char[] sArray = s.toCharArray();
        for (char c : sArray) {
            map.put(c,!map.containsKey(c));
        }
        //hashMap无序，不能用遍历hashmap来找，如果用要用linkedHashMap
        for (char c : sArray) {
            if(map.get(c)) return c;
        }
        return ' ';
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();
        solution.firstUniqChar("loveleetcode");
    }
}