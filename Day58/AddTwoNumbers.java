package Day58;

import Day25.AddNumbers;

public class AddTwoNumbers {
    static ListNode head;
    static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

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

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null ) return head1;

        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        int carry = 0;

        while (head1 != null || head2 != null || carry != 0) {
            int x = head1 != null ? head1.val : 0;
            int y = head2 != null ? head2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }
        if (head1 != null) {
            head1 = head1.next;
        }
        if(head2 != null) {
            head2 = head2.next;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers list1 = new AddTwoNumbers();
        list1.head = new ListNode(2);
        list1.add(4);
        list1.add(6);
        list1.add(8);
        list1.printList(list1.head);
        AddTwoNumbers list2 = new AddTwoNumbers();
        list2.head = new ListNode(9);
        list2.head.next = new ListNode(8);
        list2.head.next.next = new ListNode(8);
        list2.printList(list2.head);

    }
}
