//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
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
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 198 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CongShangDaoXiaDaYinErChaShuIiiLcof{
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();
        int level=1;
        queue.offer(root);
        while (!queue.isEmpty()){
            int queueSize = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if(poll.left!=null) queue.offer(poll.left);
                if(poll.right!=null) queue.offer(poll.right);
            }
            if(level%2==0){
                Collections.reverse(list);
            }
            level++;
            lists.add(new ArrayList(list));
        }
        return lists;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new CongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();
    }
}