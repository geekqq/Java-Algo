package Day51;

public class LinkedList2 {
    static ListNode head;

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    ListNode reverseUtil(ListNode cur, ListNode prev) {
        if (head == null) {
            return head;
        }
        if (cur.next == null) {
            head = cur;
            cur.next = prev;
            return head;
        }
        ListNode next1 = cur.next;
        cur.next = prev;
        reverseUtil(next1, cur);
        return head;
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
        list.head.next = new ListNode(2);
        list.head.next.next = new ListNode(3);
        list.head.next.next.next = new ListNode(4);
        list.head.next.next.next.next = new ListNode(5);
        list.head.next.next.next.next.next = new ListNode(6);
        list.head.next.next.next.next.next.next = new ListNode(7);
        list.head.next.next.next.next.next.next.next = new ListNode(8);

        System.out.println("the given linked list:");
        list.printList(head);
        ListNode res = list.reverseUtil(head, null);
        System.out.println("reversed linked list:");
        list.printList(res);
    }
}
