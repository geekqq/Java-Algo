package Day158;

public class InsertSortingLinkedList {
    public ListNode head;

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

    private static ListNode sortLinkedList(ListNode head) {
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

    public static void main(String[] args) {
        InsertSortingLinkedList list = new InsertSortingLinkedList();
        list.add(3);
        list.add(8);
        list.add(1);
        list.add(5);
        list.add(2);
        list.print(list.head);
        System.out.println();
        list.head = sortLinkedList(list.head);
        list.print(list.head);
    }
}
