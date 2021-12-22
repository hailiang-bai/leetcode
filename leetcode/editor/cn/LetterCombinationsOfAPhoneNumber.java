//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 1570 👎 0

package leetcode.editor.cn;

import java.util.*;

import static leetcode.editor.cn.utils.sortUtils.pprint;
import static sun.misc.Version.print;

public class LetterCombinationsOfAPhoneNumber {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String string) {
            ArrayList<String> lists = new ArrayList<>();
            HashMap<Character, String> integerStringHashMap = new HashMap<>();
            integerStringHashMap.put('2',"abc");
            integerStringHashMap.put('3',"def");
            integerStringHashMap.put('4',"ghi");
            integerStringHashMap.put('5',"jkl");
            integerStringHashMap.put('6',"mno");
            integerStringHashMap.put('7',"pqrs");
            integerStringHashMap.put('8',"tuv");
            integerStringHashMap.put('9',"wxyz");

            getNumList(integerStringHashMap,lists,string,0,new StringBuffer());
            return lists;
        }

        void getNumList(HashMap<Character, String> integerStringHashMap, ArrayList<String> lists, String string, int index, StringBuffer stringBuffer) {

            if(string.length()==0){

            }
            else if(index==string.length()){ //终止条件是深度等于“23”的长度
                lists.add(stringBuffer.toString());
            }else{
                String numString = integerStringHashMap.get(string.charAt(index));
                for (int j = 0; j < numString.length(); j++) {
                    stringBuffer.append(numString.charAt(j));
                    getNumList(integerStringHashMap,lists,string,index+1,stringBuffer); //递归调用
                    stringBuffer.deleteCharAt(index);
                }
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        List<String> strings = solution.letterCombinations("");
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
