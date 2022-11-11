package Day71;

public class AddTwoNumbers {
    private static ListNode head;

    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public static ListNode addTwoNums(ListNode l1, ListNode l2) {
        //corner case
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return dummyNode.next;
    }
}
