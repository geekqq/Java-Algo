package Day260;


public class MergeSortList {

    private ListNode head;

    public void addLast(int val) {
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
        if (head == null) return;
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " --> ");
            temp = temp.next;
        }
        System.out.print("null\n");
    }

    public static void main(String[] args) {
        MergeSortList list = new MergeSortList();
        list.addLast(4);
        list.addLast(2);
        list.addLast(7);
        list.addLast(1);
        list.addLast(3);
        list.addLast(5);
        list.print();
        list.head = mergeSortList(list.head);
        list.print();
    }

    public static ListNode mergeSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode leftHead = mergeSortList(head);
        ListNode rightHead = mergeSortList(slow);
        return mergeList(leftHead, rightHead);
    }

    private static ListNode mergeList(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        //cur.next = (head1 != null ? head1 : head2);
        if (head1 != null) cur.next = head1;
        if (head2 != null) cur.next = head2;
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
        this(0);
    }

    public ListNode(int val) {
        this.val = val;
        next = null;
    }
}