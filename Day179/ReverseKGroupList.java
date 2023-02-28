package Day179;

import Day174.ListNode;

public class ReverseKGroupList {
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

    private static ListNode reverseKList(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode prev = head;
        int count = 0;
        while (prev != null && count < k) {
            prev = prev.next;
            count++;
        }
        if (count == k) {
            prev = reverseKList(prev, k);
            ListNode cur = head, post = head.next;
            while (count-- > 0) {
                post = cur.next;
                cur.next = prev;
                prev = cur;
                cur = post;
            }
        }
        return prev;
    }

    public static void main(String[] args) {
        ReverseKGroupList list = new ReverseKGroupList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.print();
        list.head = reverseKList(list.head, 2);
        list.print();
    }
}
