package Day55;

public class ReverseLinkedList {

    private static ListNode head;

    static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public static void printList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public ListNode reverse(ListNode head) {
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

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.head = new ListNode(2);
        list.head.next = new ListNode(4);
        list.head.next.next = new ListNode(6);
        list.head.next.next.next = new ListNode(8);
        list.printList(list.head);
        head = list.reverse(list.head);
        list.printList(list.head);
    }
}
