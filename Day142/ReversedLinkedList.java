package Day142;


public class ReversedLinkedList {

    private ListNode head;
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    private void add(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
        } else {
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next =newNode;
        }
    }

    private void print() {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur =cur.next;
        }
        System.out.println();
    }

    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode rest = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return rest;
    }

    private static ListNode reverse2(ListNode head) {
        if (head == null || head.next == null) return head;
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
        ReversedLinkedList list = new ReversedLinkedList();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.print();
        list.head = reverse(list.head);
        list.print();
        list.head = reverse(list.head);
        list.print();
    }


}
