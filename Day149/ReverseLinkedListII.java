package Day149;

public class ReverseLinkedListII {
    private ListNode head;

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

    private static ListNode reverseByRange(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode subStart = dummy;
        ListNode subEnd = dummy;
        ListNode next = dummy;
        for (int i = 1; i <= left - 1; i++) {
            prev = prev.next;
        }
        subStart = prev.next;
        prev.next = null;
        subEnd = subStart;
        for (int j = left; j < right; j++) {
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
        ListNode newHead = reverseByOne(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        ReverseLinkedListII list = new ReverseLinkedListII();
        ReverseLinkedListII list2 = new ReverseLinkedListII();
        list2.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.print();
        list.head = reverseByRange(list.head, 2,4);
        list.print();
        list2.head = reverseByRange(list2.head, 1, 1);
        list2.print();
    }
}

class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
        next = null;
    }
    public ListNode() {
        this(0);
    }


}
