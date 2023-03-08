package Day186;

import Day174.ListNode;

import java.util.List;

public class LinkedList {
    private ListNode head;

    public void add(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
        } else {
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
    }
    public void print() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    public static ListNode reverseByRange(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        ListNode subStart = prev.next;
        prev.next = null;
        ListNode subEnd = subStart;
        for (int i = left; i < right; i++) {
            subEnd = subEnd.next;
        }
        ListNode next = subEnd.next;
        subEnd.next = null;
        prev.next = reverse(subStart);
        subStart.next = next;
        return dummy.next;
    }

    public static ListNode mergeSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode left = mergeSortList(head);
        ListNode right = mergeSortList(slow);
        return mergeList(left, right);
    }

    private static ListNode mergeList(ListNode leftHead, ListNode rightHead) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (leftHead != null && rightHead != null) {
            if (leftHead.val <= rightHead.val) {
                cur.next = leftHead;
                leftHead = leftHead.next;
            } else {
                cur.next = rightHead;
                rightHead = rightHead.next;
            }
            cur = cur.next;
            if (leftHead != null) {
                cur.next = leftHead;
            } else {
                cur.next = rightHead;
            }
        }
        return dummy.next;
    }

    public static ListNode insertSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        while (cur != null) {
            ListNode prev = dummy;
            while (prev.next != null && cur.val > prev.next.val) {
                prev = prev.next;
            }
            ListNode insertNode = cur;
            cur = cur.next;
            insertNode.next = prev.next;
            prev.next = insertNode;
        }
        return dummy.next;
    }

    public static ListNode insertNode(ListNode head, int val) {
        ListNode insertNode = new ListNode(val);
        if (head == null || head.val >= val) {
            insertNode.next = head;
            head = insertNode;
        } else {
            ListNode cur = head;
            while (cur.next != null && cur.next.val < val) {
                cur = cur.next;
            }
            insertNode.next = cur.next;
            cur.next = insertNode;
        }
        return head;
    }

    public static void deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head;
        while (slow != null) {
            ListNode fast = slow.next;
            while (fast != null && fast.val == slow.val) {
                fast = fast.next;
            }
            slow.next = fast;
            slow = slow.next;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void deleteNode(ListNode node) {
        node.val = (node.next).val;
        node.next = (node.next).next;
    }

    public static void deleteNodeII(ListNode head, ListNode node) {
        if (head == null) return;
        ListNode temp = head;
        if (head == node) {
            if (head.next == null) {
                System.out.println("There is only one node, it can't be deleted!");
                return;
            }
            head.val = head.next.val;
            head.next = head.next.next;
        }
        while (temp.next != null && temp.next != node) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("The given node is not presented in the list!");
            return;
        }
        temp.next = temp.next.next;
        System.gc();
    }

    public static void oddEvenList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
    }

    public static ListNode partitionList(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode curSmall = small;
        ListNode curLarge = large;
        while (head != null) {
            if (head.val < x) {
                curSmall.next = head;
                curSmall = curSmall.next;
            } else {
                curLarge.next = head;
                curLarge = curLarge.next;
            }
            head = head.next;
        }
        curSmall.next = large.next;
        return small.next;
    }
    public static ListNode swapInPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode postHead = swapInPairs(head.next.next);
        head.next.next = head;
        ListNode newHead = head.next;
        head.next = postHead;
        return newHead;
    }

    public static ListNode reverseInKGroups(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = dummy;
        ListNode next = dummy;
        int count = 0;
        while (cur.next != null) {
            count++;
            cur = cur.next;
        }
        while (count >= k) {
            cur = prev.next;
            next = cur.next;
            for (int i = 1; i < k; i++) {
                cur.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = cur.next;
            }
            prev = cur;
            count -= k;
        }
        return dummy.next;
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode secondHead = reverse(temp);

        ListNode firstHead = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        temp = dummy;
        while (firstHead != null && secondHead != null) {
            temp.next = firstHead;
            firstHead = firstHead.next;
            temp = temp.next;

            temp.next = secondHead;
            secondHead = secondHead.next;
            temp = temp.next;
        }

        if (firstHead != null) {
            temp.next = firstHead;
        }
        if (secondHead != null) {
            temp.next = secondHead;
        }
    }

    public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while (head1 != null || head2 != null || carry != 0) {
            int x = head1 != null ? head1.val : 0;
            int y = head2 != null ? head2.val : 0;
            int sum = x + y + carry;
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

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(2);
        list.add(0);
        list.add(4);
        list.add(1);
        list.add(6);
        list.add(3);
        list.add(5);
        list.print();
        System.out.println("----reverse by range----");
        list.head = reverseByRange(list.head, 3,6);
        list.print();
        System.out.println("----merge sort linked list----");
        list.head = mergeSortList(list.head);
        list.print();
        System.out.println("----insert node----");
        for (int i = 0; i < 10; i++) {
            list.head = insertNode(list.head, i);
        }
        list.print();
        System.out.println("----remove duplicates----");
        deleteDuplicates(list.head);
        list.print();
        System.out.println("----remove elements----");
        list.head = removeElements(list.head, 3);
        list.print();
        System.out.println("----swap in pairs----");
        list.head = swapInPairs(list.head);
        list.print();
        System.out.println("----insert sort list----");
        list.head = insertSortList(list.head);
        list.print();
        System.out.println("----reverse in k groups----");
        list.head = reverseInKGroups(list.head, 4);
        list.print();
        System.out.println("----reorder list----");
        reorderList(list.head);
        list.print();
        System.out.println("----odd even list----");
        oddEvenList(list.head);
        list.print();
        System.out.println("----partition list----");
        list.head = partitionList(list.head, 6);
        list.print();
        System.out.println("----add two numbers----");
        LinkedList num1 = new LinkedList();
        LinkedList num2 = new LinkedList();
        LinkedList num3 = new LinkedList();
        num1.add(9);
        num1.add(2);
        num1.add(9);
        num2.add(3);
        num2.add(5);
        num1.print();
        num2.print();
        num3.head = addTwoNumbers(num1.head, num2.head);
        num3.print();
        System.out.println("----delete node----");
        LinkedList list2 = new LinkedList();
        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        list2.head = node0;
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        list2.print();
        deleteNodeII(list2.head, node3);
        list2.print();
    }
}
