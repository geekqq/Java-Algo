package Day160;

public class ReverseLinkedListByRange {
    private  ListNode head;

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

    private static ListNode reverseByRange(ListNode head, int left, int right) {
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
        ReverseLinkedListByRange list = new ReverseLinkedListByRange();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.print();
        list.head = reverseByRange(list.head, 3,7);
        list.print();
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
