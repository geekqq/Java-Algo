package Day45;

public class DeleteDuplicates {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int value) {
            val = value;
            next = null;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        while (pre.next != null) {
            if (pre.next.next != null && pre.next.val == pre.next.next.val) {
                int val = pre.next.val;
                while (pre.next != null && pre.next.val == val) {
                    pre.next = pre.next.next;
                }
            } else {
                pre = pre.next;
            }
        }
        return dummy.next;
    }

}
