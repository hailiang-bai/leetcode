//给定一棵树的前序遍历 preorder 与中序遍历 inorder。请构造二叉树并返回其根节点。 
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
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均无重复元素 
// inorder 均出现在 preorder 
// preorder 保证为二叉树的前序遍历序列 
// inorder 保证为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1387 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal{
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
public class TreeNode {
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLeft=0;
        int preRight=preorder.length-1;
        int inLeft=0;
        int inRight=inorder.length-1;
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i],i);
        }
        return build(preorder,inorder,preLeft,preRight,inLeft,inRight,inMap);
    }

     TreeNode build(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight, HashMap<Integer, Integer> inMap) {
         if(preLeft>preRight || inLeft>inRight){
             return null;
         }

         TreeNode root = new TreeNode(preorder[preLeft]);
         root.left=build(preorder,inorder,preLeft+1,inMap.get(preorder[preLeft])-inLeft+preLeft,inLeft,inMap.get(preorder[preLeft])-1,inMap);
         root.right=build(preorder,inorder,inMap.get(preorder[preLeft])-inLeft+preLeft+1,preRight,inMap.get(preorder[preLeft])+1,inRight,inMap);
         return root;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
    }
}