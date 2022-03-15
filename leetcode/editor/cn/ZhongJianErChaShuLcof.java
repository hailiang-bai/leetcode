//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。 
//
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 714 👎 0

package leetcode.editor.cn;

public class ZhongJianErChaShuLcof{
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
public class TreeNode {
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return createTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    private TreeNode createTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {

        if(preStart>preEnd){
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[preStart]);
        int inIndex=0;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i]==preorder[preStart]){
                inIndex=i;
            }
        }
        treeNode.left=createTree(preorder,preStart+1,preStart+inIndex-inStart,inorder,inStart,inIndex-1);
        treeNode.right=createTree(preorder,preStart+inIndex-inStart+1,preEnd,inorder,inIndex+1,inEnd);

        return treeNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new ZhongJianErChaShuLcof().new Solution();
        solution.buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
    }
}