//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 6291 👎 0

package leetcode.editor.cn;

import sun.util.resources.hr.CalendarData_hr;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    public int lengthOfLongestSubstring2(String s) {
        char[] chars = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        int num=0;
        int max=0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j <chars.length ; j++) {
                if(set.contains(chars[j])){
                    num=0;
                    set.clear();
                    break;
                }else{
                    num +=1;
                    set.add(chars[j]);
                    if (max < num){
                        max=num;
                    }
                }
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring3(String s) {
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 左指针向右移动一格，移除一个字符
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

}

//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new LongestSubstringWithoutRepeatingCharacters().new Solution();
        String s = "dvdf";
        int num = solution.lengthOfLongestSubstring3(s);
        System.out.println(num);
    }
}
