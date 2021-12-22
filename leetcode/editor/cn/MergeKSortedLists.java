//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 1575 👎 0

package leetcode.editor.cn;


public class MergeKSortedLists {
    //leetcode submit region begin(Prohibit modification and deletion)
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
//    public ListNode mergeKLists(ListNode[] lists) {
//        int listLength = lists.length;
//
//        ListNode pre = new ListNode(0);
//        ListNode l1,l2;
//        if(listLength ==0){
//            return null;
//        }else if (listLength==1){
//            return lists[0];
//        }
//        pre.next=lists[0];
//
//
//        for (int i = 1; i < listLength; i++) {
//            ListNode temp=pre;
//            l1=pre.next;
//            l2=lists[i];
//
//            while (l1 !=null && l2 != null){
//                if(l1.val > l2.val){
//                    temp.next=l2;
//                    l2=l2.next;
//                }else {
//                    temp.next=l1;
//                    l1=l1.next;
//                }
//                temp=temp.next;
//            }
////            if(l1 !=null){
////                while (l1!=null){
////                    temp.next=l1;
////                    l1=l1.next;
////                    temp=temp.next;
////                }
//////               continue;
////            }
////            if(l2 !=null){
////                while (l2!=null){
////                    temp.next=l2;
////                    l2=l2.next;
////                    temp=temp.next;
////                }
//////                continue;
////            }
//            temp.next=(l1 !=null) ? l1:l2;
//
//        }
//
//        return pre.next;
//    }

        public ListNode mergeKLists(ListNode[] lists) {
            return merge(lists, 0, lists.length - 1);
        }

        public ListNode merge(ListNode[] lists, int l, int r) {
            if (l == r) {
                return lists[l];
            }
            if (l > r) {
                return null;
            }
            int mid = (l + r) >> 1;
            ListNode merge1 = merge(lists, l, mid);
            ListNode merge2 = merge(lists, mid + 1, r);
            return mergeTwoLists(merge1,merge2);
        }

        public ListNode mergeTwoLists(ListNode a, ListNode b) {
            if (a == null || b == null) {
                return a != null ? a : b;
            }
            ListNode head = new ListNode(0);
            ListNode tail = head, aPtr = a, bPtr = b;
            while (aPtr != null && bPtr != null) {
                if (aPtr.val < bPtr.val) {
                    tail.next = aPtr;
                    aPtr = aPtr.next;
                } else {
                    tail.next = bPtr;
                    bPtr = bPtr.next;
                }
                tail = tail.next;
            }
            tail.next = (aPtr != null ? aPtr : bPtr);
            return head.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = l1;
        listNodes[1] = l2;
        listNodes[2] = l3;

        ListNode listNode = solution.mergeKLists(listNodes);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
