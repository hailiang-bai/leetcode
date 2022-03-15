package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ziXuLei {
    class Solution{

        public ArrayList<List<Integer>> ziXulie(int[] xulie){
            ArrayList<List<Integer>> lists = new ArrayList<>();
            ArrayList<Integer> list = new ArrayList<>();

            process(xulie,lists,list, 0);
            return lists;
        }

        private void process(int[] xulie, ArrayList<List<Integer>> lists, ArrayList<Integer> list, int index) {
            if(index==xulie.length){
                lists.add(new ArrayList<>(list));
                return;
            }
            //选当前节点
            list.add(xulie[index]);
            process(xulie,lists,list,index+1);
            //不选当前节点
            list.remove(list.size()-1);
            process(xulie,lists,list,index+1);
        }


    }

    public static void main(String[] args) {
        Solution solution = new ziXuLei().new Solution();
        solution.ziXulie(new int[]{1,2,6});

    }
}
