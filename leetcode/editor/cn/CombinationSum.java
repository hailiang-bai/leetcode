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
        public List<List<Integer>> combinationSum(int[] candidates, int target){
            ArrayList<Integer> alongList = new ArrayList<>();
            List<List<Integer>> resultList = new ArrayList<>();

            traceBack(candidates,alongList,resultList,target,0,0);
            return resultList;
        }

        private void traceBack(int[] candidates, ArrayList<Integer> alongList, List<List<Integer>> resultList, int target, int sum,int start) {
            if(sum==target){
                resultList.add(new ArrayList(alongList));
                            }
            if(sum<=target){
                for (int i = start; i < candidates.length; i++) {
                    alongList.add(candidates[i]);
                    sum +=candidates[i];
                    traceBack(candidates,alongList,resultList,target,sum,i);
                    alongList.remove(alongList.size()-1);
                    sum -=candidates[i];
                }

            }

        }



//        public List<List<Integer>> combinationSum(int[] candidates, int target) {
//            ArrayList<Integer> alongList = new ArrayList<>();
//            ArrayList<List<Integer>> resultList = new ArrayList<>();
//            dfs(candidates, 0,resultList, alongList, 0, target);
//            return resultList;
//        }
//        public  void dfs(int[] candidates, int start, ArrayList<List<Integer>> resultList, List<Integer> nums, int cur, int target) {
//            if (cur == target) {
//                resultList.add(new ArrayList<>(nums));
//
//            }
//            if(cur<=target)
//            for (int i = start; i < candidates.length; i++) {
//
//                cur += candidates[i];
//                nums.add(candidates[i]);
//                dfs(candidates, i, resultList, nums, cur, target);
//                nums.remove(nums.size() - 1);
//                cur -= candidates[i];
//            }
//        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();
        solution.combinationSum(new int[]{2, 3, 6, 7}, 7);


    }
}
