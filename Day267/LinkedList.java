package Day267;

import Day266.ListNode;

public class LinkedList {

    private ListNode head;

    public void addLast(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) head = newNode;
        else {
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
    }

    public void print(ListNode head) {
        ListNode cur = head;
        if (head == null) return;
        System.out.print(head.data + " ");
        print(head.next);
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode rest = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public ListNode reverseI(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode next = null;
        ListNode cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.addLast(i);
        }
        list.print(list.head);
        System.out.println("---reverse list---");
        list.head = list.reverse(list.head);
        list.print(list.head);
        System.out.println();
        list.head = list.reverseI(list.head);
        list.print(list.head);
    }
}
