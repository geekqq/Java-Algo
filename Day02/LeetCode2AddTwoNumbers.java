package Day02;

public class LeetCode2AddTwoNumbers {
    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        //constructor
        ListNode() {
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

//    public class Solution {
//        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//            //创建一个dummyHead
//            //ListNode dummyHead = new ListNode(0);
////            ListNode curr = dummyHead;
////            int carry = 0;
////            while (l1 != null || l2 != null || carry != 0) {
////                int x = l1 != null ? l1.val : 0;
////                int y = l2 != null ? l2.val : 0;
////                int sum = x + y + carry;
////                carry = sum / 10;
////                //curr.next = new ListNode(sum % 10);
////                curr = curr.next;
////                if (l1 != null) l1 =l1.next;
////                if (l2 != null) l2 =l2.next;
////            }
////            return dummyHead.next;
//        //}
//            //
//            //
//            // }
//
//
////}
