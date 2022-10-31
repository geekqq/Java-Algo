package Day60;

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
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static ListNode reverseOne(ListNode head) {
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
        list.head = new ListNode(23);
        list.add(12);
        list.add(1);
        list.add(8);
        list.add(-3);
        list.add(0);
        list.add(90);
        list.printList(head);
        head = reverseOne(head);
        list.printList(head);
        head = reverseRecursion(head);
        list.printList(head);
    }
}
