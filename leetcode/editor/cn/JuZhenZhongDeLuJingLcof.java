//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 数组 回溯 矩阵 👍 544 👎 0

package leetcode.editor.cn;

public class JuZhenZhongDeLuJingLcof{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < used.length; i++) {
            for (int i1 = 0; i1 < used[i].length; i1++) {
                used[i][i1]=false;
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int i1 = 0; i1 < board[i].length; i1++) {
                if(taceBack(board,word,used,i,i1,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean taceBack(char[][] board, String word, boolean[][] used, int i1, int i2,int index) {
        if(board[i1][i2]!=word.charAt(index)){
            return false;
        }else if(index==word.length()-1){
            return true;
        }
        int[][] traces= {{0,1},{0,-1},{1,0},{-1,0}};

        used[i1][i2]=true;
        boolean result=false;
        for (int[] trace: traces) {
            int newi1=i1+trace[0];
            int newi2=i2+trace[1];
            if(newi1>=0&&newi1<board.length&&newi2>=0&&newi2<board[0].length){
                if(!used[newi1][newi2]){
                   boolean flag= taceBack(board,word,used,newi1,newi2,index+1);
                   if(flag==true){
                       result=true;
                       break;
                   }
                }
            }
        }
        used[i1][i2]=false;
        return result;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new JuZhenZhongDeLuJingLcof().new Solution();
        char[][] chars = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        boolean abcced = solution.exist(chars,"ABCCED");
        System.out.println(abcced);

    }
}