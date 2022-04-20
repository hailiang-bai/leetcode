//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// Related Topics 数学 双指针 枚举 👍 421 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class HeWeiSdeLianXuZhengShuXuLieLcof{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] findContinuousSequence(int target) {
        int mid=target/2;
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        int start=1;
        int end=2;
        while (end<target){
            int sum=0;
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = start; i <=end ; i++) {
                list.add(i);
                sum+=i;
            }
            if(sum==target){
             lists.add(list);
             start++;
            }else if(sum<target){
                end++;
            }else{
                start++;
            }
        }
        //把二维列表转化为二维数组
        int [][] resArrays=new int[lists.size()][];
        for(int i=0;i<lists.size();++i){
            resArrays[i]=new int[lists.get(i).size()];
            for(int j=0;j<lists.get(i).size();++j){
                resArrays[i][j]=lists.get(i).get(j);
            }
        }
        return resArrays;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new HeWeiSdeLianXuZhengShuXuLieLcof().new Solution();
        int[][] continuousSequence = solution.findContinuousSequence(9);
        System.out.println(continuousSequence);

    }
}