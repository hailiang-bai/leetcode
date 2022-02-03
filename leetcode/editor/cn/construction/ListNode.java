package leetcode.editor.cn.construction;

import leetcode.editor.cn.SortList;

//Definition for singly-linked list.
public class ListNode {
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
//SortList.ListNode l2 = new SortList.ListNode(5);
//        l2.next=new ListNode(6);
//                l2.next.next=new ListNode(4);
//                l2.next.next.next=new ListNode(9);
//                ListNode listNode = solution.sortList(l2);