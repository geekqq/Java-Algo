package Day188;

import Day174.ListNode;
import Day180.ReverseInKGroupList;

import static Day187.LinkedList.reverse;

public class ReverseInKGroup {
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

    private static ListNode reverseInKGroups(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode next = null;
        ListNode cur = head;
        int count = 0;
        while (count < k && cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            count++;
        }

        if (next != null) {
            head.next = reverseInKGroups(next, k);
        }
        return prev;
    }

    public static void main(String[] args) {
        ReverseInKGroup list = new ReverseInKGroup();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.print();
        list.head = reverseInKGroups(list.head, 4);
        list.print();
    }
}
