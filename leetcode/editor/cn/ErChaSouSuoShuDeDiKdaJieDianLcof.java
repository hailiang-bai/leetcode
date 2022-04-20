//给定一棵二叉搜索树，请找出其中第 k 大的节点的值。 
//
// 
//
// 示例 1: 
//
// 
//输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 
//输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 
// 1 ≤ k ≤ 二叉搜索树元素个数 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 274 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ErChaSouSuoShuDeDiKdaJieDianLcof{
//leetcode submit region begin(Prohibit modification and deletion)

//  Definition for a binary tree node.
  public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    ArrayList<Integer> list;
    public int kthLargest(TreeNode root, int k) {
        list = new ArrayList<>();
        dfs(root);
        return list.get(k-1);
    }

    private void dfs(TreeNode root) {
        if(root==null){
            return;
        }
        dfs(root.right);
        list.add(root.val);
        dfs(root.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution = new ErChaSouSuoShuDeDiKdaJieDianLcof().new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode two = new TreeNode(20);
        root.right = two;
        two.left =new TreeNode(15);
        two.right = new TreeNode(7);
        System.out.println(solution.kthLargest(root, 1));

    }
}