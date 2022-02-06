//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1526 👎 0

package leetcode.editor.cn;

public class NumberOfIslands{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int len = grid[0].length;
        int numArea=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]=='1'){
                    numArea++;
                    dfs(grid,i,j);  //如果不等于1就不是岛屿，就直接不用dfs
                }

            }
        }
        return numArea;
    }

    private void dfs(char[][] grid, int r, int l) {
        if(!isArea(grid,r,l)){
            return;
        }
        if(grid[r][l]!='1'){
            return;
        }
        grid[r][l]='2';

        dfs(grid,r+1,l);
        dfs(grid,r-1,l);
        dfs(grid,r,l+1);
        dfs(grid,r,l-1);
    }

    private boolean isArea(char[][] grid, int r, int l) {
        return r>=0 && r<grid.length
                && l>=0 && l<grid[0].length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new NumberOfIslands().new Solution();
    }
}