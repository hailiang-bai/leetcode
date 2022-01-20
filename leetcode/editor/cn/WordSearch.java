//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
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
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯 矩阵 👍 1151 👎 0

package leetcode.editor.cn;

public class WordSearch{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        int cols=board[0].length;
        int rows=board.length;
        //需要一个标记数组；
        Boolean[][] used = new Boolean[rows][cols];
        for (int i = 0; i < used.length; i++) {
            for (int i1 = 0; i1 < used[i].length; i1++) {
                used[i][i1]=false;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean flag=check(board,used,i,j,word,0);
                if(flag){
                    return true;
                }
            }
        }
        return false;
    }
    //k为word的第几个字符
    boolean check(char[][] board, Boolean[][] used, int i, int j, String word, int k) {
        //结束条件
        if(board[i][j]!=word.charAt(k)){
            return false;
        }else if(k==word.length()-1){
            return true;
        }

        used[i][j]=true;
        int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
        boolean result=false;
        for (int[] direction : directions) {
            int newi=i+direction[0];
            int newj=j+direction[1];
            if(newi>=0&&newi<board.length&&newj>=0&&newj<board[0].length){
                if(!used[newi][newj]){
                    boolean flag=check(board,used,newi,newj,word,k+1);
                    if(flag){
                        result =  true;
                        break;
                    }
                }
            }
        }
        //清除状态
        used[i][j]=false;
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new WordSearch().new Solution();
        char[][] chars = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        boolean result = solution.exist(chars, "SEE");
        System.out.println(result);
    }
}