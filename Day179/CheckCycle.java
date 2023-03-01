package Day179;

import Day174.ListNode;

public class CheckCycle {

    private ListNode head;

    private static boolean checkCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CheckCycle list = new CheckCycle();
        list.head = new ListNode(3);
        list.head.next = new ListNode(2);
        list.head.next.next = new ListNode(0);
        list.head.next.next.next = new ListNode(-4);
        list.head.next.next.next.next = null;
        list.checkCycle(list.head);
    }
}
