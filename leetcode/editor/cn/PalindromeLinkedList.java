//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 栈 递归 链表 双指针 👍 1252 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.construction.ListNode;

import java.util.LinkedList;
import java.util.List;

public class PalindromeLinkedList{
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }
        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode middleNode = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(middleNode.next);

        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result=true;
        while (p2!=null&&result){
            if(p1.val!= p2.val){
                result=false;
            }
            p1=p1.next;
            p2=p2.next;
        }
        return result;

    }

    private ListNode reverseList(ListNode node) {
        ListNode pre=null;
        ListNode cur=node;
        while (cur!=null){
            ListNode Nexttmp = cur.next;
            cur.next=pre;
            pre=cur;
            cur=Nexttmp;
        }
        return pre;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p1.next!=null&&p1.next.next!=null){
            p1=p1.next.next;
            p2=p2.next;
        }
        return p2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new PalindromeLinkedList().new Solution();
        ListNode l2 = new ListNode(1);
        l2.next=new ListNode(0);
        l2.next.next=new ListNode(1);

        solution.isPalindrome(l2);
    }
}