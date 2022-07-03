//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。 
//
// 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。 
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = "11", num2 = "123"
//输出："134"
// 
//
// 示例 2： 
//
// 
//输入：num1 = "456", num2 = "77"
//输出："533"
// 
//
// 示例 3： 
//
// 
//输入：num1 = "0", num2 = "0"
//输出："0"
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 10⁴ 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 
// Related Topics 数学 字符串 模拟 👍 578 👎 0

package leetcode.editor.cn;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class AddStrings{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {
        int num1Len = num1.length()-1;
        int num2Len = num2.length()-1;

        StringBuffer stringBuffer = new StringBuffer();
        int arr=0;
        while (num1Len>=0 || num2Len >=0){
            int a=num1Len>=0 ? num1.charAt(num1Len)-'0':0;
            int b=num2Len>=0 ? num2.charAt(num2Len)-'0':0;
            stringBuffer.append((a+b+arr)%10);
            arr=(a+b+arr)/10;
            num1Len--;
            num2Len--;
        }
        if(arr==1){
            stringBuffer.append(1);
        }
        return stringBuffer.reverse().toString();

    }



}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new AddStrings().new Solution();
        HashSet<Integer> set = new HashSet<>();

    }
}