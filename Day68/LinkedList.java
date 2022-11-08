package Day68;

public class LinkedList {

    private static ListNode head;

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public static void addLast(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;

    }

    public static void print() {
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

        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head =prev;
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
        list.head = new ListNode(0);
        list.addLast(1);
        list.addLast(3);
        list.addLast(5);
        list.addLast(7);
        list.addLast(9);
        list.addLast(11);
        list.print();
        head = reverse(head);
        list.print();
        head = reverseRecursion(head);
        list.print();
    }


}
