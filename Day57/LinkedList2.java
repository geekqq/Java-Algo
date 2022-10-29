package Day57;

public class LinkedList2 {
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

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode rest = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public static void printList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList2 list = new LinkedList2();
        list.head = new ListNode(1);
        list.head.next = new ListNode(3);
        list.head.next.next = new ListNode(5);
        list.head.next.next.next = new ListNode(7);
        list.printList(head);
        head = reverse(head);
        list.printList(head);
    }
}
