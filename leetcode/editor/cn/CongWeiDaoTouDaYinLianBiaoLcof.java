//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 栈 递归 链表 双指针 👍 256 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;

public class CongWeiDaoTouDaYinLianBiaoLcof{
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public static class ListNode {
    int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
class Solution {
    public int[] reversePrint(ListNode head) {
        //必须判断是不是空
        if(head==null){
            return new int[]{};
        }
        ListNode pre =head;
        ListNode p1=head.next;
        head=head.next;
        pre.next=null;
        int size=1;
        while (head!=null){
            head=head.next;
            size++;
            p1.next=pre;
            pre=p1;
            p1=head;
        }
        int[] ints = new int[size];
        int i=0;
        while (pre!=null){
            ints[i++]=pre.val;
            pre=pre.next;
        }
        return ints;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
        ListNode l2 = new ListNode(1);
        l2.next=new ListNode(3);
        l2.next.next=new ListNode(2);
        solution.reversePrint(l2);
    }
}