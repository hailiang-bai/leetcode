//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树 深度优先搜索 二叉树 👍 935 👎 0

package leetcode.editor.cn;

public class DiameterOfBinaryTree{
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
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans=0;
        depth(root);
        return ans-1;
    }

    private int depth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int Ldep=depth(root.left);
        int Rdep=depth(root.right);
        ans=Math.max(ans,Ldep+Rdep+1);
        return Math.max(Ldep,Rdep)+1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new DiameterOfBinaryTree().new Solution();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        TreeNode two = new TreeNode(6);
        root.right = two;
        two.left =new TreeNode(5);
        two.right = new TreeNode(7);
        solution.diameterOfBinaryTree(root);
    }
}