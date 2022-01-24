//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1094 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.construction.TreeNode;
import sun.security.krb5.internal.KdcErrException;

public class MaximumDepthOfBinaryTree{
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
    TreeNode() {}
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
    int depth=0;
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftHeight=maxDepth(root.left);
        int rightHight=maxDepth(root.right);
        return Math.max(leftHeight,rightHight)+1;
    }

    int dfs(TreeNode root, int depth,int level) {
        if(root==null){
            return depth>level?depth:level;
        }

        return dfs(root.left,depth,level+1) > dfs(root.right,depth,level+1) ?dfs(root.left,depth,level+1): dfs(root.right,depth,level+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new MaximumDepthOfBinaryTree().new Solution();
        TreeNode root = new TreeNode(3);
        root.left=new TreeNode(9);
        TreeNode two = new TreeNode(20);
        root.right=two;
        two.left=new TreeNode(15);
        two.right=new TreeNode(7);

        solution.maxDepth(root);

    }
}