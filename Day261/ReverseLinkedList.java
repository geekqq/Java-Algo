package Day261;

public class ReverseLinkedList {

    private ListNode head;

    public void add(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) head = newNode;
        else {
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
    }

    public void display(ListNode head) {
        if (head == null) return;
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " --> ");
            cur = cur.next;
        }
        System.out.println("null\n");
    }

    public ListNode reverseI(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseII(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode rest = reverseII(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        for (int i = 0; i < 11; i++) {
            list.add(i);
        }
        list.display(list.head);
        ListNode reversedHead = list.reverseI(list.head);
        list.display(reversedHead);
        ListNode reversedAgainHead = list.reverseII(reversedHead);
        list.display(reversedAgainHead);
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