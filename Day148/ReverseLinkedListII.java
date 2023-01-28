package Day148;

public class ReverseLinkedListII {
    public static void main(String[] args) {
        ReverseLinkedListII list = new ReverseLinkedListII();
    }

    private static MergeLinkedList.ListNode reverseBetween(MergeLinkedList.ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        MergeLinkedList.ListNode dummy = new MergeLinkedList.ListNode(0);
        dummy.next = head;
        MergeLinkedList.ListNode prev = dummy;
        MergeLinkedList.ListNode subStart = dummy;
        MergeLinkedList.ListNode subEnd = dummy;
        MergeLinkedList.ListNode next = dummy;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        subStart = prev.next;
        prev.next = null;
        subEnd = subStart;
        for (int j = left; j < right; j++) {
            subEnd = subEnd.next;
        }
        next = subEnd.next;
        subEnd.next = null;
        prev.next = reverseByOne(subStart);
        subStart .next = next;
        return dummy.next;
    }

    private static MergeLinkedList.ListNode reverseByOne(MergeLinkedList.ListNode subStart) {
        if (subStart == null || subStart.next == null) return subStart;
        MergeLinkedList.ListNode newHead = reverseByOne(subStart.next);
        subStart.next.next = subStart;
        subStart.next = null;
        return newHead;
    }
}
