//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构) 
//
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。 
//
// 例如: 
//给定的树 A: 
//
// 3 
// / \ 
// 4 5 
// / \ 
// 1 2 
//给定的树 B： 
//
// 4 
// / 
// 1 
//返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。 
//
// 示例 1： 
//
// 输入：A = [1,2,3], B = [3,1]
//输出：false
// 
//
// 示例 2： 
//
// 输入：A = [3,4,5,1,2], B = [4,1]
//输出：true 
//
// 限制： 
//
// 0 <= 节点个数 <= 10000 
// Related Topics 树 深度优先搜索 二叉树 👍 509 👎 0

package leetcode.editor.cn;

public class ShuDeZiJieGouLcof{
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

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null || B==null){
            return false;
        }
       if(A.val==B.val && dfs(A,B)){
           return true;
       }else {
           return isSubStructure(A.left,B) || isSubStructure(A.right,B);
       }
    }

    private boolean dfs(TreeNode a, TreeNode b) {
        if(a==null && b==null){
            return true;
        }
        if(a.val==b.val){
            return false;
        }
        return dfs(a.left,b.right) && dfs(a.left,b.left);
    }


}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new ShuDeZiJieGouLcof().new Solution();
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(5);
        TreeNode two = new TreeNode(4);
        root.left = two;
        two.left =new TreeNode(1);
        two.right = new TreeNode(2);

        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(1);

        solution.isSubStructure(root,root2);
    }
}