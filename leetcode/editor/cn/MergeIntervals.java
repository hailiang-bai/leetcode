//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
// Related Topics 数组 排序 👍 1193 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0){
            return new int[0][2];
        }

        //排序，重写Comparator
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        ArrayList<int[]> mergeList = new ArrayList<int[]>();

        for (int i = 0; i < intervals.length; i++) {
            int L=intervals[i][0];
            int R=intervals[i][1];
            if(i==0||mergeList.get(mergeList.size()-1)[1] < L){
                mergeList.add(new int[] {L,R});
            }else {
                mergeList.get(mergeList.size()-1)[1]=Math.max(mergeList.get(mergeList.size()-1)[1],R);
            }

        }


        return mergeList.toArray(new int[mergeList.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new MergeIntervals().new Solution();
        int[][] ints={{1,4},{1,4}};
        int[][] merge = solution.merge(ints);
        for (int i = 0; i < merge.length; i++) {
            System.out.println(merge[i][0]+" "+merge[i][1]);
        }

    }
}
