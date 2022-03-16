//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// Related Topics 深度优先搜索 广度优先搜索 动态规划 👍 462 👎 0

package leetcode.editor.cn;

public class JiQiRenDeYunDongFanWeiLcof{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return movingCount(0, 0, m, n, k,visited);
    }


    public int movingCount(int row, int col, int m, int n, int k,boolean[][] visited) {
        if (calculate(row, col) > k || row >= m || col >= n||visited[row][col]) {
            return 0;
        }
        visited[row][col] = true;
        int right = movingCount(row, col + 1, m, n, k,visited);
        int down = movingCount(row + 1, col, m, n, k,visited);
        return right + down + 1;
    }



    int calculate(int i,int j){
        int temp=0;
        int n_temp=i;
        int m_temp=j;
        while (n_temp!=0){
            temp += n_temp%10;
            n_temp /=10;
        }
        while (m_temp!=0){
            temp += m_temp%10;
            m_temp /=10;
        }
        return temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new JiQiRenDeYunDongFanWeiLcof().new Solution();
        System.out.println(solution.movingCount(2, 3, 17));
    }
}