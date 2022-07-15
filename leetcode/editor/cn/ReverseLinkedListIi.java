//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
// Related Topics 链表 👍 1331 👎 0

package leetcode.editor.cn;

public class ReverseLinkedListIi{
//leetcode submit region begin(Prohibit modification and deletion)

  //Definition for singly-linked list.
  public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode leftNode=new ListNode();
        ListNode rightNode=new ListNode();
        ListNode reverseNode=new ListNode();
        ListNode reverseNodeR=new ListNode();
        ListNode p1=head;
        int index=1;
        while(head!=null){
            if(index>=left&&index<=right){
                if(reverseNode.next==null){
                    reverseNode.next=head;
                    reverseNodeR=head;
                    head=head.next;
                    index++;
                }else{
                    ListNode tmp=head;
                    head=head.next;
                    tmp.next=reverseNode.next;
                    reverseNode.next=tmp;
                    index++;
                }
            }else if(index<left-1){
                head=head.next;
                index++;
            }else if(index==left-1){
                leftNode=head;
                head=head.next;
                index++;
            }else if(index>right){
                rightNode.next=head;
                leftNode.next=reverseNode.next;
                reverseNodeR.next=rightNode.next;
                break;
            }
        }

        if(left==1){
            return reverseNode.next;
        }
        return p1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new ReverseLinkedListIi().new Solution();
        ListNode l2 = new ListNode(1);
        l2.next=new ListNode(2);
//        l2.next.next=new ListNode(3);
//        l2.next.next.next=new ListNode(4);
//        l2.next.next.next.next=new ListNode(5);

        ListNode listNode = solution.reverseBetween(l2,1,2);
    }
}