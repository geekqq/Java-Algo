package Day326;

import Day266.ListNode;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        int carry = 0;
        if (h1 == null) return h2;
        if (h2 == null) return h1;
        while (h1 != null || h2 != null || carry != 0) {
            int x = h1 == null ? 0 : h1.data;
            int y = h2 == null ? 0 : h2.data;
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (h1 != null) h1 = h1.next;
            if (h2 != null) h2 = h2.next;
        }
        return dummy.next;
    }
}
