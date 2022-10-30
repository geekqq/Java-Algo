package Day58;

public class LinkedList2 {

    private static ListNode head;

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }
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
        ListNode rest = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public static void main(String[] args) {
        LinkedList2 list = new LinkedList2();
        list.head = new ListNode(23);
        list.head.next = new ListNode(2);
        list.head.next.next = new ListNode(-232);
        list.head.next.next.next = new ListNode(42);
        list.printList(list.head);
        head = reverse(list.head);
        list.printList(list.head);
    }
}
