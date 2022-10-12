//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯 👍 1448 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Subsets{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public List<List<Integer>> subsets(int[] nums) {
//        ArrayList<List<Integer>> lists = new ArrayList<>();
//        if(nums.length==0){
//            return lists;
//        }
////        lists.add(new ArrayList<>());
//        for (int k = 0; k <= nums.length; k++) {
//            backtrack(0,lists,k,new ArrayList<Integer>(),nums);
//        }
//
//        return lists;
//    }
//
//    void backtrack(int start ,ArrayList<List<Integer>> lists, int k, ArrayList<Integer> integers, int[] nums) {
//        if(k==0){
//            // 如果回溯到边界，记录当前结果
//            lists.add(new ArrayList<>(integers));
//            return;
//        }else {
//            for (int i = start; i < nums.length; i++) {
//                integers.add(nums[i]);
//                backtrack(i+1,lists,k-1,integers,nums);
//                integers.remove(integers.size()-1);
//            }
//
//
//        }
//
//    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list= new ArrayList<Integer>();
        int len = nums.length;

        tracesBack(lists, list,nums,0 ,len);

        return lists;
    }

    void tracesBack(List<List<Integer>> lists,List<Integer> list,int[] nums,int  start,int len){

        lists.add(new ArrayList<>(list));

        for(int i=start;i<len;i++){
            list.add(nums[i]);
            tracesBack(lists,list,nums,i+1,len);
            list.remove(list.size()-1);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new Subsets().new Solution();
        List<List<Integer>> subsets = solution.subsets(new int[]{1, 2, 3});
        for (int i = 0; i < subsets.size(); i++) {
            for (int i1 = 0; i1 < subsets.get(i).size(); i1++) {
                System.out.print(subsets.get(i).get(i1));
            }
            System.out.println();
        }

    }
}