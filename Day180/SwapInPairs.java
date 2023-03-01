package Day180;

import Day174.ListNode;

public class SwapInPairs {

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

    private static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode postHead = swapPairs(head.next.next);
        head.next.next = head;
        ListNode newHead = head.next;
        head.next = postHead;
        return newHead;
    }
    public static void main(String[] args) {
        SwapInPairs list = new SwapInPairs();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.print();
        list.head = swapPairs(list.head);
        list.print();
    }
}
