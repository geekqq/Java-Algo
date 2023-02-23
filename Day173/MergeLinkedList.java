package Day173;

public class MergeLinkedList {

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

    private static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        return mergeList(left, right);
    }

    private static ListNode mergeList(ListNode leftHead, ListNode righthead) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (leftHead != null && righthead != null) {
            if (leftHead.val <= righthead.val) {
                cur.next = leftHead;
                leftHead = leftHead.next;
            } else {
                cur.next = righthead;
                righthead = righthead.next;
            }
            cur = cur.next;
        }
        if (leftHead != null) {
            cur.next = leftHead;
        }
        if (righthead != null) {
            cur.next = righthead;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        MergeLinkedList list = new MergeLinkedList();
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(6);
        list.head = sortList(list.head);
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
