package Day170;

public class RemoveListElements {
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

    private static ListNode removeListElement(ListNode head, int val) {
        if (head == null) return head;
        head.next = removeListElement(head.next, val);
        return head.val == val ? head.next : head;
    }

    private static ListNode removeListElementII(ListNode head, int val) {
        if (head == null) return head;
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                if (cur == head) {
                    head = cur.next;
                } else {
                    prev.next = cur.next;
                }
                cur = cur.next;
                continue;
            }
            prev = cur;
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveListElements list = new RemoveListElements();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.print(list.head);
        System.out.println();
        list.head = removeListElement(list.head, 1);
        list.print(list.head);
        System.out.println();
        list.head = removeListElementII(list.head, 3);
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
