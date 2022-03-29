//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
// Related Topics 递归 链表 👍 223 👎 0

package leetcode.editor.cn;

public class HeBingLiangGePaiXuDeLianBiaoLcof{
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre=new ListNode();
        ListNode p1=pre;
        ListNode temp;
        while (l1!=null&&l2!=null){
            if(l1.val>= l2.val){
                p1.next=l2;
                p1=l2;
                l2=l2.next;
            }else{
                p1.next=l1;
                p1=l1;
                l1=l1.next;
            }
        }
        if(l1!=null){
            p1.next=l1;
        }
        if(l2!=null){
            p1.next=l2;
        }
        return pre.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new HeBingLiangGePaiXuDeLianBiaoLcof().new Solution();
        ListNode l1 = new ListNode(1);
        l1.next=new ListNode(2);
        l1.next.next=new ListNode(4);
                  ListNode l2 = new ListNode(1);
        l2.next=new ListNode(3);
                l2.next.next=new ListNode(4);
                solution.mergeTwoLists(l1,l2);
    }
}