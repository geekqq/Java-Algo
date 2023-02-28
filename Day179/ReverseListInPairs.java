package Day179;

import Day174.ListNode;

public class ReverseListInPairs {

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

    public static void main(String[] args) {
        ReverseListInPairs list = new ReverseListInPairs();
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(5);
        list.add(0);
        list.print();
        list.head = reverseInPairs(list.head);
        list.print();
    }

    private static ListNode reverseInPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode postHead = reverseInPairs(head.next.next);
        head.next.next = head;
        ListNode newHead = head.next;
        head.next = postHead;

        return newHead;
    }

}
