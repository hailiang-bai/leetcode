//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母都恰好只用一次。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 排序 👍 912 👎 0

package leetcode.editor.cn;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.*;

public class GroupAnagrams{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> stringListHashMap = new HashMap<>();

        for (String str:strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);

//            if (stringListHashMap.containsKey(key)){
//                List<String> strings = stringListHashMap.get(key);
//                strings.add(str);
//                stringListHashMap.put(key, strings);
//            }else{
//                stringListHashMap.put(key, Collections.singletonList(str));
//            }
            List<String> list = stringListHashMap.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            stringListHashMap.put(key,list);
            //不能使用charArray.toString()

        }
//        Iterator<Map.Entry<String, List<String>>> iterator = stringListHashMap.entrySet().iterator();
//        while (iterator.hasNext()){
//            Map.Entry next = iterator.next();
//            System.out.println(next.getKey()+" "+next.getValue());
//        }
//        ArrayList<List<String>> values = (ArrayList<List<String>>) stringListHashMap.values();
        return new ArrayList<List<String>>(stringListHashMap.values());
    }


}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new GroupAnagrams().new Solution();
        String[] strs={"tan","nat"};
        solution.groupAnagrams(strs);
    }
}
