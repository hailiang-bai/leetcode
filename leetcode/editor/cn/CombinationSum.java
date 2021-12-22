//给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的
//唯一组合。 
//
// candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。 
//
// 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。 
//
// 
//
// 示例 1： 
//
// 
//输入: candidates = [2,3,6,7], target = 7
//输出: [[7],[2,2,3]]
// 
//
// 示例 2： 
//
// 
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]] 
//
// 示例 3： 
//
// 
//输入: candidates = [2], target = 1
//输出: []
// 
//
// 示例 4： 
//
// 
//输入: candidates = [1], target = 1
//输出: [[1]]
// 
//
// 示例 5： 
//
// 
//输入: candidates = [1], target = 2
//输出: [[1,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯 👍 1607 👎 0

package leetcode.editor.cn;

import java.util.*;

public class CombinationSum {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            ArrayList<List<Integer>> combinations = new ArrayList<List<Integer>>();
            ArrayList<List<Integer>> combinations2 = new ArrayList<List<Integer>>();

            int res = 0;
//            backtrack(combinations, candidates, new ArrayList<Integer>(), target, res);
            dfs(candidates,target,combinations,new ArrayList<Integer>(),0);


//            int[][] nums=new int[100][100];
//            int flog=1;
//            for (List<Integer> combination : combinations) {
//                Object[] objects = combination.toArray();
//                Arrays.sort(objects);
//
//
//            }
            return combinations;
        }

        void backtrack(ArrayList<List<Integer>> combinations, int[] candidates, ArrayList<Integer> combination, int target, int res) {
            if (res == target) {
                System.out.println(combination);
                combinations.add(new ArrayList<Integer>(combination)); //List要在放入ArrayList转化

                return;
            } else if (res > target) {
                return;
            }
            for (int i = 0; i < candidates.length; i++) {
                combination.add(candidates[i]);
                res += candidates[i];
                backtrack(combinations, candidates, combination, target, res);
                res -= candidates[i];
//            combination.remove(index);
                //可以用size记录ArrayList大小
                combination.remove(combination.size() - 1);
            }
        }

        public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
             if (idx == candidates.length) {
                return;
            }
            if (target == 0) {
                ans.add(new ArrayList<Integer>(combine));
                return;
            }
            dfs(candidates, target, ans, combine, idx + 1);
            if (target - candidates[idx] >= 0) {
                combine.add(candidates[idx]);
                dfs(candidates, target - candidates[idx], ans, combine, idx);
                combine.remove(combine.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();
        List<List<Integer>> lists = solution.combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(lists);

    }
}
