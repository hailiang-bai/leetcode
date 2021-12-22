//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
// Related Topics 数组 二分查找 分治 👍 4581 👎 0

package leetcode.editor.cn;


import static leetcode.editor.cn.utils.sortUtils.pprint;

public class MedianOfTwoSortedArrays{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        int index1=0;
        int index2=0;
        int index=0;
        double result=0;
        int[] nums=new int[nums1Length +nums2Length];
        while (index1 < nums1Length && index2 < nums2Length){
            nums[index++]=nums1[index1] < nums2[index2] ? nums1[index1++] :nums2[index2++];
        }
        if(index1>=nums1Length){
            for (int i = index; i < nums1Length+nums2Length ; i++) {
                nums[i]=nums2[index2++];
            }

            if((nums1Length+nums2Length)%2==0){
                result=(nums[(nums1Length+nums2Length)/2] +nums[(nums1Length+nums2Length)/2 -1])/2.0;
            }else{
                result=(nums[(nums1Length+nums2Length)/2]);
            }
            return result;
        }
        if(index2>=nums2Length){
            for (int i = index; i < nums1Length+nums2Length ; i++) {
                nums[i]=nums1[index1++];
            }
            if((nums1Length+nums2Length)%2==0){
                result=(nums[(nums1Length+nums2Length)/2] +nums[(nums1Length+nums2Length)/2 -1])/2.0;
            }else{
                result=(nums[(nums1Length+nums2Length)/2]);
            }
            return result;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new MedianOfTwoSortedArrays().new Solution();
        int[] nums1={1,3};
        int[] nums2={2,4};
        double medin = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(medin);
    }
}
