package Day207;

import Day174.ListNode;
import Day185.LinkedList;

public class ReverseLinkedList {
    public static ListNode reverseByOne(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseByOne(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.print();
        list.head = reverseByOne(list.head);
        list.print();
    }
}
