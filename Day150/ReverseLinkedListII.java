package Day150;

public class ReverseLinkedListII {
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
    public void print() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static ListNode reverseLinkedListII(ListNode head, int left, int right) {
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
        ReverseLinkedListII list = new ReverseLinkedListII();
        for (int i = 0; i < 11; i++) {
            list.add(i);
        }
        list.print();
        list.head = reverseLinkedListII(list.head, 3,6);
        list.print();
    }
}
