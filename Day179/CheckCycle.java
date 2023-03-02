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
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        list.head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        System.out.println(list.checkCycle(list.head));
    }
}
