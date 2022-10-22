package Day51;

public class ReverseLinkedList {
    static ListNode head;
    static class ListNode {
        int data;
        ListNode next;

        public ListNode(int val) {
            data = val;
            next = null;
        }
    }

    //function to reverse a single linked list

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    public static void printLinkedList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.head = new ListNode(85);
        list.head.next = new ListNode(15);
        list.head.next.next = new ListNode(4);
        list.head.next.next.next = new ListNode(20);
        System.out.println("Given the linked list is: ");
        printLinkedList(head);
        head = list.reverse(head);
        System.out.println("Reversed linked list is: ");
        printLinkedList(head);
    }
}
