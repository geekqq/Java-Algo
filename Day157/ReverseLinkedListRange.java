package Day157;


public class ReverseLinkedListRange {
    private ListNode head;

    public void add(int val) {
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

    private void print(ListNode head) {
        if (head == null) return;
        System.out.print(head.val + " ");
        print(head.next);
    }

    private static ListNode reverseLinkedListRange(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode subStart = dummy;
        ListNode subEnd = dummy;
        ListNode next = dummy;

        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        subStart = prev.next;
        prev.next = null;
        subEnd = subStart;

        for (int i = left; i < right; i++) {
            subEnd = subEnd.next;
        }
        next = subEnd.next;
        subEnd.next = null;
        prev.next = reverseByOne(subStart);
        subStart.next = next;
        return dummy.next;
    }

    private static ListNode reverseByOne(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode rest = reverseByOne(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public static void main(String[] args) {
        ReverseLinkedListRange list = new ReverseLinkedListRange();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.print(list.head);
        System.out.println();
        list.head = reverseLinkedListRange(list.head, 3,5);
        list.print(list.head);
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        next = null;
    }
}
