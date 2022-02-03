//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// Related Topics 链表 双指针 分治 排序 归并排序 👍 1449 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.construction.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortList{
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
    public ListNode sortList(ListNode head) {
        // 这里tail初始值必须填null,不能填最后一个节点,例[2,1]在重载函数的第二个if即返回
        return sortList(head, null);
    }

    private ListNode sortList(ListNode head, ListNode tail) {
        //终止条件 自己写的时候没搞清楚
        if(head==null){
            return head;
        }
        if(head.next==tail){
            head.next=null;
            return head;
        }
        //先找到中间值
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=tail){
            fast=fast.next;
            slow=slow.next;
            if(fast!=tail){
                fast=fast.next;
            }
        }
        ListNode mid=slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        return merge(list1,list2);
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        //需要四个变量来进行 链表的合并
        ListNode returnList=new ListNode();
        ListNode tmp=returnList;
        ListNode tmp1=list1;
        ListNode tmp2=list2;
        while(tmp1!=null && tmp2 !=null){
            if(tmp1.val>tmp2.val){
                tmp.next=tmp2;
                tmp2=tmp2.next;
            }else {
                tmp.next=tmp1;
                tmp1=tmp1.next;
            }
            tmp=tmp.next;
        }
        if(tmp1!=null){
            tmp.next=tmp1;
        }else if(tmp2!=null){
            tmp.next=tmp2;
        }
        return returnList.next;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args){
        Solution solution=new SortList().new Solution();
        ListNode l2 = new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);
        l2.next.next.next=new ListNode(9);
        ListNode listNode = solution.sortList(l2);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}