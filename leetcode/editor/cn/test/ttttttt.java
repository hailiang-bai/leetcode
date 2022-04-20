package leetcode.editor.cn.test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            int a = in.nextInt();
//            int b = in.nextInt();
//            System.out.println(a + b);
//        }
//    }
//}
//class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int nextInt = sc.nextInt();
//        ArrayList<Integer> arr = new ArrayList<>();
//
//    }
//}


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res=0;
        int i;
        if(n%2==0){
            i=2;
        }else {
            i=1;
        }
        while (i<=n){
            res += i;
            i=i+2;
        }
        System.out.println(res);
    }
}
//class Main {
//    static int time;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int  x;
//        int[] list = new int[n];
//        int res=0;
//        for (int i = 0; i < n; i++) {
//            x = sc.nextInt();
//            list[i]=x;
//        }
//        int result=1;
//        time=0;
//        for (int i = 0; i < n; i++) {
//            result *= list[i];
//            traceBack(list,result,i+1);
//            result /= list[i];
//        }
//        System.out.println(time);
//    }
//    private static void traceBack(int[] list, int result,int start) {
//        if(result==1){
//            ++time;
//        }
//        if(start<list.length){
//            result *= list[start];
//            traceBack(list,result,start+1);
//            result /=list[start];
//        }
//    }
//}
//class Main {
//
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m= sc.nextInt();
//        int[] list = new int[m + 1];
//        int  res=0;
//        int[][] quList=new int[n][2];
//        for (int i = 0; i < n; i++) {
//            int a =sc.nextInt();
//            int b =sc.nextInt();
//            quList[i][0]=a;
//            quList[i][1]=b;
//        }
//        for (int j= 0; j< n; j++) {
//            for (int i = j; i < n; i++) {
//                if(list[quList[i][0]]==0&&list[quList[i][1]]==0){
//                    ++res;
//                    list[quList[i][0]]=1;
//                    list[quList[i][1]]=1;
//                }
//            }
//            for (int i = 0; i <j ; i++) {
//                if(list[quList[i][0]]==0&&list[quList[i][1]]==0){
//                    ++res;
//                    list[quList[i][0]]=1;
//                    list[quList[i][1]]=1;
//                }
//            }
//        }
//
//        System.out.println(res);
//    }
//
//}
//class Main {
//        public static void main(String[] args) {
//            Scanner sc = new Scanner(System.in);
//            int n = sc.nextInt();
//            for (int i = 0; i < n; i++) {
//                long x= sc.nextInt();
//                long y=sc.nextInt();
//                if(x==y){
//                    System.out.println(0);
//                }
//                int res=0;
//                while (x!=y){
//                    ++res;
//                    if(x%3==0){
//                        x=x/3;
//                    }else {
//                        ++x;
//                    }
//                }
//                System.out.println(res);
//            }
//        }
//}
//public class TreeNode {
//    int val;
//    TreeNode left;
//    leetcode.editor.cn.construction.TreeNode right;
//    TreeNode() {}
//    TreeNode(int val) {
//        this.val = val;
//    }
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//public class Solution {
//    /**
//     *
//     * @param root TreeNode类
//     * @return int整型ArrayList
//     */
//    public ArrayList<Integer> preorderTraversal (TreeNode root) {
//        // write code here
//        LinkedList<TreeNode> queue= new LinkedList<TreeNode>();
//        ArrayList<Integer> list=new ArrayList<Integer>();
//        queue.offer(root);
//
//        while(!queue.isEmpty()){
//            int size=queue.size();
//            for(int i=0;i<size;i++){
//                TreeNode node= queue.poll();
//                list.add(node.val);
//                if(root.left!=null) queue.offer(root.left);
//                if(root.right!=null) queue.offer(root.right);
//            }
//        }
//        return list;
//
//    }
//}

//class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        for (int i = 0; i < n; i++) {
//            int x = sc.nextInt();
//            int y = sc.nextInt();
//            System.out.println(process(x, y));
//        }
//    }
//
//    private static int process(long remain, long y) {
//        if (remain == y) {
//            return 0;
//        }
//        int ans = 0;
//        if (remain % 3 != 0) {
//            ans += process(remain + 1, y) + 1;
//        } else {
//            if(remain<y){
//                ans+=process(remain+1,y)+1;
//            }else
//            ans += process(remain / 3, y) + 1;
//        }
//        return ans;
//    }
//}