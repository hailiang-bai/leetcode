//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 👍 289 👎 0

package leetcode.editor.cn;

public class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        // 搜索右边界 right
       int i=0;
       int j=nums.length-1;
       while (i<=j){
           int mid=(i+j)/2;
           if(nums[mid] >= target) i=mid+1;
           else j=mid-1;
       }
       int right=i;
        // 若数组中无 target ，则提前返回
        if(j>0&&nums[j]!=target) return 0;
        i=0;
        j= nums.length-1;
        while (i<=j){
            int mid=(i+j)/2;
            if(nums[mid] > target) i=mid+1;
            else j=mid-1;
        }
        int left=j;
        return right-left-1;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
        solution.search(new int[]{5,7,7,8,8,10},8);
    }
}