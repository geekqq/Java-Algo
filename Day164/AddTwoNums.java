package Day164;

public class AddTwoNums {
    private ListNode head;

    private static ListNode addTwo(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        int carry = 0;
        ListNode cur = dummy;
        while (head1 != null || head2 != null || carry != 0) {
            int x = head1 != null ? head1.val : 0;
            int y = head2 != null ? head2.val : 0;
            int sum =  x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head2 = head2.next;
            }
        }
        return dummy.next;
    }
}
