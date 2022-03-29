//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。 
//
// 
//
// 示例： 
//
// 
//输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 50000 
// 0 <= nums[i] <= 10000 
// 
// Related Topics 数组 双指针 排序 👍 209 👎 0

package leetcode.editor.cn;

public class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] exchange(int[] nums) {
        int L=0;
        int R= nums.length-1;
        while (L<R){
            if(nums[L]%2==1){
                L++;
            }
            if(nums[R]%2==0){
                R--;
            }
            if(nums[L]%2==0&&nums[R]%2==1&&L<R){
                int temp=nums[L];
                nums[L]=nums[R];
                nums[R]=temp;
                R--;
                L++;
            }
        }
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
        solution.exchange(new int[]{11,9,3,7,16,4,2,0});
    }
}