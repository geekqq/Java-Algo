package Day156;

public class SortingList {
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

    public void print(ListNode head) {
        if (head == null) return;
        System.out.print(head.val + " ");
        print(head.next);
    }
    public static void main(String[] args) {
        SortingList list = new SortingList();
        list.add(4);
        list.add(2);
        list.add(3);
        list.add(7);
        list.add(5);
        list.add(1);
        list.add(8);
        list.add(6);
        list.print(list.head);
        System.out.println();
        list.head = insertSortList(list.head);
        list.print(list.head);
    }

    private static ListNode insertSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode cur = head;

        while (cur != null) {
            ListNode prev = dummy;
            while (prev.next != null && cur.val > prev.next.val) {
                prev = prev.next;
            }
            ListNode insertNode = cur;
            cur = cur.next;
            insertNode.next = prev.next;
            prev.next = insertNode;
        }
        return dummy.next;
    }
}

