package Day56;

public class LinkedList2 {
    //fields
    private static ListNode head;

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            ListNode next = null;
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
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void add(int val) {
        ListNode temp = new ListNode(val);
        ListNode cur = head;
        if (head == null) {
            head = temp;
        } else {
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = temp;
        }

    }

    public static void main(String[] args) {
        LinkedList2 list = new LinkedList2();
        list.head = new ListNode(1);
        list.add(7);
        list.add(4);
        list.add(8);
        printList(list.head);
        head = reverse(head);
        printList(head);
    }
}
