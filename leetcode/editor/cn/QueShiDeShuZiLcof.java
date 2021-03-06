//一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出
//这个数字。 
//
// 
//
// 示例 1: 
//
// 输入: [0,1,3]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [0,1,2,3,4,5,6,7,9]
//输出: 8 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 10000 
// Related Topics 位运算 数组 哈希表 数学 二分查找 👍 250 👎 0

package leetcode.editor.cn;

public class QueShiDeShuZiLcof{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int missingNumber(int[] nums) {
        int i=0;
        int j=nums.length-1;
        int res=0;
        while (i<=j){
            int mid=(i+j)/2;
             if(nums[mid]==mid){
                i=mid+1;
            }else {
                j=mid-1;
            }

        }
        return i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new QueShiDeShuZiLcof().new Solution();
        solution.missingNumber(new int[]{1});
    }
}