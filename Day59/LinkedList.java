package Day59;

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
        ListNode temp = new ListNode(val);
        if (head == null) {
            head = temp;
        }
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = temp;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
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

        while ( cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
        return head;
    }

    public static ListNode reverseUsingRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode rest = reverseUsingRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new ListNode(12);
        list.head.next = new ListNode(5);
        list.head.next.next = new ListNode(8);
        list.head.next.next.next = new ListNode(0);
        list.printList(head);
        head = reverse(head);
        list.printList(head);
        head = reverseUsingRecursion(head);
        list.printList(head);
    }
}
