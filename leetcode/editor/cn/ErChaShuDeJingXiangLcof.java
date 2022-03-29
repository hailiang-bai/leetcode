//请完成一个函数，输入一个二叉树，该函数输出它的镜像。 
//
// 例如输入： 
//
// 4 
// / \ 
// 2 7 
// / \ / \ 
//1 3 6 9 
//镜像输出： 
//
// 4 
// / \ 
// 7 2 
// / \ / \ 
//9 6 3 1 
//
// 
//
// 示例 1： 
//
// 输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 1000 
//
// 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 231 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.construction.TreeNode;

import java.util.List;

public class ErChaShuDeJingXiangLcof{
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
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
        public TreeNode mirrorTree(TreeNode root) {
             dfs(root);
             return root;
        }

        private void dfs(TreeNode root) {
            if(root==null){
                return ;
            }
            TreeNode right = root.right;
            root.right= root.left;
            root.left=right;

            dfs(root.left);
            dfs(root.right);

        }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new ErChaShuDeJingXiangLcof().new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode two = new TreeNode(20);
        root.right = two;
        two.left =new TreeNode(15);
        two.right = new TreeNode(7);
        solution.mirrorTree(root);
    }
}