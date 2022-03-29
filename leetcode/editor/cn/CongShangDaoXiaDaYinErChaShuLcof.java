//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回： 
//
// [3,9,20,15,7]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 180 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;

public class CongShangDaoXiaDaYinErChaShuLcof{
//leetcode submit region begin(Prohibit modification and deletion)

 // Definition for a binary tree node.
  public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

class Solution {
    public int[] levelOrder(TreeNode root) {
        if(root==null){
            return new int[]{};
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if(poll.left!=null){
                    queue.offer(poll.left);
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i]= list.get(i);
        }
        return res;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new CongShangDaoXiaDaYinErChaShuLcof().new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode two = new TreeNode(20);
        root.right = two;
        two.left =new TreeNode(15);
        two.right = new TreeNode(7);
        solution.levelOrder(root);
    }
}