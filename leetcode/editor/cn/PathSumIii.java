//给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
//
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
//
//
//
// 示例 1：
//
//
//
//
//输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//输出：3
//解释：和等于 8 的路径有 3 条，如图所示。
//
//
// 示例 2：
//
//
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：3
//
//
//
//
// 提示:
//
//
// 二叉树的节点个数的范围是 [0,1000]
// -10⁹ <= Node.val <= 10⁹
// -1000 <= targetSum <= 1000
//
// Related Topics 树 深度优先搜索 二叉树 👍 1250 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.construction.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSumIii{
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
    public int pathSum(TreeNode root, int targetSum) {
       //建立一个map存前缀和
        HashMap<Integer, Integer> qianZhuiHe = new HashMap<>();
        qianZhuiHe.put(0,1);

        int res = digui(qianZhuiHe,root,targetSum,0);
        return res;
    }

    private int digui(HashMap<Integer, Integer> qianZhuiHe, TreeNode root, int target, int qianZuiSum) {
        int res=0;
        if(root==null){
            return 0;
        }
        qianZuiSum += root.val;

        res += qianZhuiHe.getOrDefault(qianZuiSum- target,0);

        qianZhuiHe.put(qianZuiSum,qianZhuiHe.getOrDefault(qianZuiSum,0)+1);

        res += digui(qianZhuiHe, root.left, target,qianZuiSum);
        res += digui(qianZhuiHe, root.right, target,qianZuiSum);

        qianZhuiHe.put(qianZuiSum,qianZhuiHe.get(qianZuiSum)-1);

        return res;

    }


}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new PathSumIii().new Solution();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        TreeNode two = new TreeNode(-3);
        root.right = two;
        two.right =new TreeNode(11);
        root.left.left=new TreeNode(3);
        root.left.left.right=new TreeNode(-2);
        root.left.left.left=new TreeNode(3);
        root.left.right=new TreeNode(2);
        root.left.right.right=new TreeNode(1);
        int i = solution.pathSum(root, 8);
        System.out.println(i);
    }
}