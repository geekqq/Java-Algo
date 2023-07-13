package Day258;

public class SinglyLinkedList {

    private ListNode head;

    private static class ListNode {
        private int data;
        private ListNode next;
        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static void printList(ListNode head) {

        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static int countNode(ListNode head) {
        if (head == null) return 0;
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public static ListNode insertNode(ListNode head, int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
        }
        newNode.next = head;
        head = newNode;
        return head;
    }

    public static ListNode insertLast(ListNode head, int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) head = newNode;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
        return head;
    }

    public static ListNode insertPos(ListNode head, int pos, int data) {
        ListNode newNode = new ListNode(data);
        int countNode = countNode(head);
        if (pos > countNode + 1) {
            throw new IllegalArgumentException("The position to insert is not valid!");
        }

        if (pos == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            ListNode prev = head;
            int count = 1;
            while (count < pos - 1) {
                prev = prev.next;
                count++;
            }
            ListNode cur = prev.next;
            prev.next = newNode;
            newNode.next = cur;
        }
        return head;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);
        sll.head.next = second;
        second.next =third;
        third.next = fourth;
        System.out.println(sll);
        printList(sll.head);
        System.out.println(countNode(sll.head));
        sll.head = insertNode(sll.head, 5);
        printList(sll.head);
        insertLast(sll.head, 6);
        printList(sll.head);
        System.out.println("------------------------");
        sll.head = insertPos(sll.head, 5, 7);
        printList(sll.head);
    }
}
