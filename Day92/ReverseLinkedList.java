package Day92;

import java.util.List;

public class ReverseLinkedList {
    private ListNode head;
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }
    public void add(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
        } else {
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
    }
    public void print() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static ListNode reverse1(ListNode head) {
        if (head == null || head.next == null) {
            return  head;
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
        return head;
    }
    public static ListNode reverse2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode rest = reverse2(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.add(3);
        list.add(4);
        list.add(-1);
        list.add(0);
        list.add(9);
        list.add(3);
        list.add(2);
        list.add(4);
        list.add(7);
        list.print();
        list.head = reverse1(list.head);
        list.print();
        list.head = reverse2(list.head);
        list.print();
    }
}
