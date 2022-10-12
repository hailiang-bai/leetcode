//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 1468 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collections;

public class KthLargestElementInAnArray{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        numsSort(nums,0,nums.length-1);
        return nums[nums.length-k];
    }

    private void numsSort(int[] nums, int L, int R) {
        if(L==R){
            return;
        }
        int mid=L+((R-L)/2);
        numsSort(nums,L,mid);
        numsSort(nums,mid+1,R);
        merge(nums,L,mid,R);
    }

    private void merge(int[] nums, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int i=0;
        int p1=L;
        int p2=mid+1;
        while ((p1<=mid) && (p2<=R)){
            help[i++]=nums[p1]>nums[p2]?nums[p2++]:nums[p1++];
        }
        while (p1<=mid){
            help[i++]=nums[p1++];
        }
        while (p2<=R){
            help[i++]=nums[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            nums[L+j]=help[j];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new KthLargestElementInAnArray().new Solution();
        solution.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4);
    }
}