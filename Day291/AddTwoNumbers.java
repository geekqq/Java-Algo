package Day291;

import Day266.ListNode;

public class AddTwoNumbers {

    public static ListNode addTwoNumber(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        int carry = 0;
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (head1 != null || head2 != null || carry != 0) {

            int x = head1 != null ? head1.data : 0;
            int y = head2 != null ? head2.data : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head1 = head2.next;
            }
        }
        return dummy.next;
    }

}
