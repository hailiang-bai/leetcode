//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。 
//
// 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 递归 链表 👍 406 👎 0

package leetcode.editor.cn;

public class FanZhuanLianBiaoLcof{
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */public static class ListNode {
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
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode p1=head.next;
        ListNode pre=head;
        head=head.next;
        pre.next=null;
        while (head!=null){
            head=head.next;
            p1.next=pre;
            pre=p1;
            p1=head;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new FanZhuanLianBiaoLcof().new Solution();
                  ListNode l2 = new ListNode(1);
        l2.next=new ListNode(2);
                l2.next.next=new ListNode(3);
                l2.next.next.next=new ListNode(4);
                solution.reverseList(l2);

    }
}