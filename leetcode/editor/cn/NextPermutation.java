//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 双指针 👍 1382 👎 0

package leetcode.editor.cn;

import static leetcode.editor.cn.utils.sortUtils.pprint;

public class NextPermutation {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            int length = nums.length;
            if (length <= 1) {
                return;
            }
            boolean flog = false;
            boolean flog2 = true;
            int shortIndex;
            int moreIndex;
            for (int i = length - 1; i >= 1; i--) {
                if (nums[i] > nums[i - 1]) {
                    shortIndex = i - 1;
                    moreIndex = i;
                    for (int j = length - 1; j > shortIndex; j--) {
                        if (nums[j] > nums[shortIndex] && nums[j] <= nums[moreIndex]) {
                            if (flog2 && nums[j] == nums[moreIndex]) {
                                moreIndex = j; //执行一次就不能执行了，只用于判断是否相等跟最后一个
                                flog2 = false;
                            } else if (nums[j] != nums[moreIndex]) {
                                moreIndex = j;
                                flog2 = false;
                            }

                        }
                    }
                    swap(nums, shortIndex, moreIndex);
                    reverse(i, length - 1, nums);
                    flog = true;
                    break;
                }
            }
            if (!flog) {
                int start = 0;
                int end = nums.length - 1;
                reverse(start, end, nums);
            }
        }

        public void swap(int[] arr, int a, int b) {
            int temp;
            temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }

        public void reverse(int start, int end, int[] nums) {
            while (start < end) {
                swap(nums, start, end);
                start++;
                end--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
        int[] ints = {1, 2, 4, 7, 6};
        int[] ints2 = {2, 1, 2, 2, 2, 2, 2, 1};
        int[] ints3 = {3, 4, 1, 4, 3, 3};
        solution.nextPermutation(ints2);
        pprint(ints2);

    }
}
