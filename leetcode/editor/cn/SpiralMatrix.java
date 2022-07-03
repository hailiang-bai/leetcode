//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 矩阵 模拟 👍 1130 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list= new ArrayList<Integer>();
        if(matrix.length==0){
            return list;
        }
        int L=0;
        int R=matrix[0].length-1;
        int top=0;
        int low=matrix.length-1;
        int len=matrix.length*matrix[0].length;
        while(true){
            for(int i=L;i<=R;i++){
                list.add(matrix[top][i]);
                len--;
            }
            if(len==0) break;
            top++;
            for(int i=top;i<=low;i++){
                list.add(matrix[i][R]);
                len--;
            }
            if(len==0) break;
            R--;
            for(int i=R;i>=L;i--){
                list.add(matrix[low][i]);
                len--;
            }
            if(len==0) break;
            low--;
            for(int i=low;i>=top;i--){
                list.add(matrix[i][L]);
                len--;
            }
            if(len==0) break;
            L++;
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new SpiralMatrix().new Solution();
        int[][] ints = {{1, 2, 3,4}, { 5, 6,7,8}, { 9,10,11,12}};
        solution.spiralOrder(ints);
    }
}