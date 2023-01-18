package Day138;


public class LinkedListReverse {
    private ListNode head;

    static class ListNode {
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
            cur.next = newNode;
        }
    }
    private void print() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return null;
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
    private static ListNode reverse2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode rest = reverse2(head.next);
        head.next.next = head;
        head.next = null;

        return rest;
    }

    public static void main(String[] args) {
        LinkedListReverse list = new LinkedListReverse();
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(3);
        list.add(0);
        list.print();
        list.head = reverse(list.head);
        list.print();
        list.head = reverse2(list.head);
        list.print();
    }
}
