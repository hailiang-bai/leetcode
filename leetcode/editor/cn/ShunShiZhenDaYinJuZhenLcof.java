//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 矩阵 模拟 👍 377 👎 0

package leetcode.editor.cn;

public class ShunShiZhenDaYinJuZhenLcof{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        int left=0;
        int right=matrix[0].length-1;
        int top=0;
        int bottem=matrix.length-1;
        int[] res = new int[(right + 1) * (bottem + 1)];
        int x=0;
        while (true){
            for (int i = left; i <= right; i++) res[x++]=matrix[top][i];
            if(++top>bottem) break;
            for (int i = top; i <= bottem; i++) res[x++]=matrix[i][right];
            if(--right<left) break;
            for (int i = right; i >=left; i--) res[x++]=matrix[bottem][i];
            if(top>--bottem) break;
            for (int i = bottem; i >=top; i--) res[x++]=matrix[i][left];
            if(right<++left) break;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new ShunShiZhenDaYinJuZhenLcof().new Solution();
        solution.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
}