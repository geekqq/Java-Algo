package Day180;

import Day174.ListNode;
import Day179.ReverseKGroupList;

public class ReverseInKGroupList {
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

    private static ListNode reverseInK(ListNode head, int k) {
        ListNode prev = head;
        int count = 0;
        while (prev != null && count < k) {
            prev = prev.next;
            count++;
        }
        if (count == k) {
            prev = reverseInK(prev, k);
            ListNode cur = head;
            ListNode post = head.next;
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
        ReverseInKGroupList list = new ReverseInKGroupList();
        for (int i = 0; i < 15; i++) {
            list.add(i);
        }
        list.print();
        list.head = reverseInK(list.head, 5);
        list.print();
    }
}
