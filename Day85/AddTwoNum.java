package Day85;

public class AddTwoNum {
    private ListNode head;
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }
    public static ListNode addTwo(ListNode h1, ListNode h2) {
        if (h1 == null) {
            return h2;
        }
        if (h2 == null) {
            return h1;
        }
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        int carry = 0;
        while (h1 != null || h2 != null || carry != 0) {
            int x = h1 != null ? h1.val : 0;
            int y = h2 != null ? h2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (h1 != null) {
                h1 = h1.next;
            }
            if (h2 != null) {
                h2 = h2.next;
            }
        }
        return dummyNode.next;
    }
}
