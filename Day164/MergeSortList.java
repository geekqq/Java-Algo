package Day164;

public class MergeSortList {
    private ListNode head;

    public void add (int val) {
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
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode leftHead = sortList(head);
        ListNode rightHead = sortList(slow);

        return mergeList(leftHead, rightHead);
    }

    private static ListNode mergeList(ListNode leftHead, ListNode rightHead) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (leftHead != null && rightHead != null) {
            if (leftHead.val < rightHead.val) {
                cur.next = leftHead;
                leftHead = leftHead.next;
            } else {
                cur.next = rightHead;
                rightHead = rightHead.next;
            }
            cur = cur.next;
        }
        if (leftHead != null) {
            cur.next = leftHead;
        }
        if (rightHead != null) {
            cur.next = rightHead;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        MergeSortList list = new MergeSortList();
        list.add(4);
        list.add(1);
        list.add(2);
        list.add(7);
        list.add(5);
        list.add(3);
        list.add(6);
        list.print();
        list.head = sortList(list.head);
        list.print();
    }
}