package Day55;

public class ReverseLinkedListRecursion {
    //fields
    private static ListNode head;

    static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public static void print(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void add(int val) {
        ListNode temp = new ListNode(val);
        temp.next = head;
        head = temp;
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
        add(10);
        add(4);
        add(15);
        add(9);
        print(head);
        head = reverse(head);
        print(head);
    }
}
