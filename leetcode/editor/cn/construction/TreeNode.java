package leetcode.editor.cn.construction;


import leetcode.editor.cn.MaximumDepthOfBinaryTree;

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


    void getTree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode two = new TreeNode(20);
        root.right = two;
        two.left =new TreeNode(15);
        two.right = new TreeNode(7);

//        TreeNode root = new TreeNode(3);
//        TreeNode one= new TreeNode(9)
//        root.left = one ;
//        one.left=new TreeNode(1);
//        one.right=new TreeNode(2);
//        TreeNode two = new TreeNode(20);
//        root.right = two;
//        two.left =new TreeNode(15);
//        two.right = new TreeNode(7);
    }
}






