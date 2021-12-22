//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 👍 1981 👎 0

package leetcode.editor.cn;


import java.util.List;

public class MergeTwoSortedLists{
//leetcode submit region begin(Prohibit modification and deletion)
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode temp=pre;
        while (l1!=null && l2!=null){
            if(l1.val > l2.val){
                temp.next=l2;
                l2=l2.next;
            }else {
                temp.next=l1;
                l1=l1.next;
            }
            temp=temp.next;
        }
        if(l1 !=null){
            while (l1!=null){
                temp.next=l1;
                l1=l1.next;
                temp=temp.next;
            }

        }
        if(l2 !=null){
            while (l2!=null){
                temp.next=l2;
                l2=l2.next;
                temp=temp.next;
            }

        }
        return pre.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new MergeTwoSortedLists().new Solution();

        ListNode l1 = new ListNode(1);
        l1.next= new ListNode(3);
        l1.next.next=new  ListNode(5);
        l1.next.next.next=new ListNode(7);

        ListNode l2 = new ListNode(2);
        l2.next=new ListNode(4);
        l2.next.next=new ListNode(6);
        l2.next.next.next=new ListNode(7);

        ListNode listNode = solution.mergeTwoLists(l1, l2);
        while (listNode !=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}
