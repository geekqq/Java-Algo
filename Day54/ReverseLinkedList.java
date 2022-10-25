package Day54;

public class ReverseLinkedList {

    static ListNode head;

    public static ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
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

    public static void printList(ListNode head) {
        ListNode cur = head;
        if (cur == null) {
            return;
        }
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.head = new ListNode(2);
        list.head.next = new ListNode(4);
        list.head.next.next = new ListNode(6);
        list.head.next.next.next = new ListNode(8);
        printList(list.head);
        head = list.reverse(list.head);
        printList(list.head);
    }
}

class ListNode {

    int val;
    ListNode next;
    ListNode prev;

    public ListNode(int val) {
        this.val = val;
        next = null;
        prev = null;
    }
}
