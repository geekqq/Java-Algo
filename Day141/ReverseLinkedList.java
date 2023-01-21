package Day141;

import java.util.List;

public class ReverseLinkedList {
    private static ListNode head;

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    private void add(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
        } else {
            ListNode cur = head;
            while (cur.next != null) {
                cur =  cur.next;
            }
            cur.next = newNode;
        }
    }

    private static void print() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur =next;
        }
        head = prev;
        return head;
    }

    private static ListNode reverse2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode rest = reverse2(head.next);
        head.next.next = head;
        head.next = null;

        return rest;
    }

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(6);
        list.add(7);
        list.add(4);
        list.add(3);
        list.add(0);
        list.add(9);
        list.print();
        list.head = reverse2(list.head);
        list.print();
        list.head = reverseLinkedList(list.head);
        list.print();
    }
}
