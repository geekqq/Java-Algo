package Day59;

public class AddTwoNumbers {
    //
    private ListNode head;

   static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

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
        if (head2 != null) {
            head2 = head2.next;
        }
        return dummyNode.next;
    }
}
