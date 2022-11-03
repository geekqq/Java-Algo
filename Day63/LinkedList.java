package Day63;

public class LinkedList {
    //fields
    private static ListNode head;

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public static void add(int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            head = node;
        }
        ListNode cur = head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    public static void print(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
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

    public static ListNode reverseRecursion(ListNode head) {
        ListNode cur = head;
        if (head == null || head.next == null) {
            return head;
        }

        ListNode rest = reverseRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new ListNode(-1);
        list.head.next = new ListNode(-7);
        list.head.next.next = new ListNode(12);
        list.head.next.next.next = new ListNode(90);
        list.head.next.next.next.next = new ListNode(4);
        list.head.next.next.next.next.next = new ListNode(7);
        list.print(head);
        head = list.reverse(head);
        list.print(head);
        head =reverseRecursion(head);
        list.print(head);
    }
}
