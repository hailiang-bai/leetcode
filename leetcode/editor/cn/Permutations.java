//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 👍 1653 👎 0

package leetcode.editor.cn;

import java.util.*;

import static leetcode.editor.cn.utils.sortUtils.pprint;

public class Permutations {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {

            List<List<Integer>> res = new ArrayList<>();
            int[] visited = new int[nums.length];
            pprint(visited);
            backtrack(res, nums, new ArrayList<Integer>(), visited);
            return res;

        }

        private void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, int[] visited) {
            if (tmp.size() == nums.length) {
                res.add(new ArrayList<>(tmp));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i] == 1)
                    continue;
                visited[i] = 1;
                tmp.add(nums[i]);
                backtrack(res, nums, tmp, visited);
                visited[i] = 0;
                tmp.remove(tmp.size() - 1);
            }
        }
    }



//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        int[] nums = {1, 2, 3};
        ArrayList<List<Integer>> permute = (ArrayList<List<Integer>>) solution.permute(nums);
        System.out.println(permute);

    }
}
