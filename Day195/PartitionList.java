package Day195;

import Day174.ListNode;

import static Day195.LinkedList.reverseInKGroups;

public class PartitionList {
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
        PartitionList list = new PartitionList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.print(list.head);
        list.head = reverseInKGroups(list.head, 4);
        System.out.println();
        list.print(list.head);
        System.out.println();
        list.head = partitionList(list.head,6);
        list.print(list.head);
    }

    public static ListNode partitionList(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode curSmall = small;
        ListNode curLarge = large;
        while (head != null) {
            if (head.val < x) {
                curSmall.next = head;
                curSmall = curSmall.next;
            } else {
                curLarge.next = head;
                curLarge = curLarge.next;
            }
            head = head.next;
        }
        curSmall.next = large.next;
        return small.next;
    }
}
