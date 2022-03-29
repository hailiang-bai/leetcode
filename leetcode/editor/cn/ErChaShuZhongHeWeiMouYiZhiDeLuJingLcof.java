//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
// Related Topics 树 深度优先搜索 回溯 二叉树 👍 310 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof{
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    ArrayList<List<Integer>> lists;
    ArrayList<Integer> list;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        lists = new ArrayList<>();
        list = new ArrayList<>();
        dfs(root,target,0);
        return lists;
    }

    private void dfs(TreeNode root, int target,int sum) {
        if(root == null) return;
        list.add(root.val);
        sum +=root.val;
        if(sum==target&&root.left==null&&root.right==null){
            lists.add(new ArrayList<>(list));
        }
        dfs(root.left,target,sum);
        dfs(root.right,target,sum);

        list.remove(list.size()-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof().new Solution();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode two = new TreeNode(6);
        root.right = two;
        two.left =new TreeNode(15);
        two.right = new TreeNode(3);

        solution.pathSum(root,12);
}
}