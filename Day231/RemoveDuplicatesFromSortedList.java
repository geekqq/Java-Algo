package Day231;

import Day174.ListNode;

public class RemoveDuplicatesFromSortedList {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null) {
            while (cur != null && cur.val == cur.next.val) {
                cur = cur.next;
            }

            if (pre.next == cur) {
                pre = cur;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;

        }
        return dummy.next;
    }
}
