//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 👍 1624 👎 0

package leetcode.editor.cn;

public class RemoveNthNodeFromEndOfList {
//leetcode submit region begin(Prohibit modification and deletion)

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {

            //需要在前面添加一个pre，使用pre等于快慢指针
            ListNode pre = new ListNode(0);
            ListNode fast = new ListNode();
            ListNode slow = new ListNode();

            fast=pre;
            slow=pre;
            pre.next=head;

            for (int i = 0; i < n; i++) {
                fast=fast.next;
            }
            while (fast.next !=null){
                fast=fast.next;
                slow=slow.next;

            }

            slow.next=slow.next.next;

            return pre.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();

        ListNode l1 = new ListNode(1);
//        l1.next=new ListNode(2);
//        l1.next.next=new ListNode(3);
//        l1.next.next.next=new ListNode(4);
//        l1.next.next.next.next=new ListNode(5);

        ListNode listNode = solution.removeNthFromEnd(l1, 1);
        while (listNode !=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}
