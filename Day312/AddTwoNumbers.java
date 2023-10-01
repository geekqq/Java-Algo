package Day312;

import Day266.ListNode;
import Day311.LinkedList;

public class AddTwoNumbers {

    public static ListNode addTwo(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        int carry = 0;
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (head1 != null || head2 != null || carry != 0) {
            int x = head1 == null ? 0 : head1.data;
            int y = head2 == null ? 0 : head2.data;
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (head1 != null) head1 = head1.next;
            if (head2 != null) head2 = head2.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        LinkedList num1 = new LinkedList();
        LinkedList num2 = new LinkedList();
        LinkedList sum = new LinkedList();
        num1.add(3);
        num1.add(6);
        num1.add(8);
        num2.add(4);
        num2.add(3);
        num2.add(5);
        num2.add(6);
        sum.head = addTwo(num1.head, num2.head);
        sum.print(sum.head);
    }
}
