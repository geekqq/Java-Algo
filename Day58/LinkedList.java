package Day58;

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

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head =prev;
        return head;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new ListNode(12);
        list.head.next = new ListNode(3);
        list.head.next.next = new ListNode(34);
        list.head.next.next.next = new ListNode(85);
        list.head.next.next.next.next = new ListNode(54);
        list.printList(list.head);
        head = reverse(list.head);
        list.printList(list.head);
    }
}
