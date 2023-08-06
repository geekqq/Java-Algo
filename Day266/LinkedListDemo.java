package Day266;

import java.util.Stack;

public class LinkedListDemo {

    private ListNode head;

    public void addLast(int val) {
        ListNode temp = new ListNode(val);
        if (head == null) {
            head = temp;
        } else {
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = temp;
        }
    }

    public void print(ListNode head) {
        if (head == null) return;
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode next = null;
        ListNode cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseI(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode rest = reverseI(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public ListNode reverseByRange(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }
        ListNode subStart = pre.next;
        pre.next = null;
        ListNode subEnd = subStart;
        for (int i = left; i < right; i++) {
            subEnd = subEnd.next;
        }
        ListNode next = subEnd.next;
        subEnd.next = null;
        pre.next = reverseI(subStart);
        subStart.next = next;
        return dummy.next;
    }

    public int countNode(ListNode head) {
        if (head == null) {
            return 0;
        }
        return 1 + countNode(head.next);
    }

    public ListNode reverseByK(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int count = countNode(head);
        if (count < k) {
            return head;
        }
        ListNode prev = null;
        ListNode next = null;
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head.next = reverseByK(cur, k);
        return prev;
    }

    public ListNode swapInPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode postHead = swapInPairs(head.next.next);
        ListNode newHead = head.next;
        head.next.next = head;
        head.next = postHead;
        return newHead;
    }

    public ListNode addFirst(int val) {
        ListNode temp = new ListNode(val);

        temp.next = head;
        head = temp;
        return head;
    }

    public ListNode mergeSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode pre = null;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode leftHead = mergeSortList(head);
        ListNode rightHead = mergeSortList(slow);
        return merge(leftHead, rightHead);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        cur.next = head1 != null ? head1 : head2;
        return dummy.next;
    }

    public ListNode insertNode(int val) {
        ListNode temp = new ListNode(val);
        if (head == null) {
            head = temp;
        } else if (head.data >= val) {
            temp.next = head;
            head = temp;
        } else {
            ListNode cur = head;
            while (cur.next != null && cur.next.data < val) {
                cur = cur.next;
            }
            temp.next = cur.next;
            cur.next = temp;
        }
        return head;
    }

    public ListNode removeDuplicates() {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        while (slow != null) {
            ListNode fast = slow.next;
            while (fast != null && slow.data == fast.data) {
                fast = fast.next;
            }
            slow.next = fast;
            slow = slow.next;
        }
        return head;
    }

    public ListNode reOrderList() {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode firstHead = head;
        ListNode secondHead = reverseI(temp);

        ListNode dummy = new ListNode();
        temp = dummy;
        while (firstHead != null && secondHead != null) {
            temp.next = firstHead;
            firstHead = firstHead.next;
            temp = temp.next;

            temp.next = secondHead;
            secondHead = secondHead.next;
            temp = temp.next;
        }
        temp.next = firstHead != null ? firstHead : secondHead;
        return dummy.next;
    }

    public void oddEvenList() {
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

    public void plusOne() {
        if (head == null) return;
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            if (node.data < 9) {
                node.data++;
                return;
            } else {
                node.data = 0;
            }
        }
        ListNode newNode = new ListNode(1);
        newNode.next = head;
        head = newNode;
    }

    public boolean hasCycle() {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public ListNode getStartingNodeInCycle() {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
            else return null;
        }
        ListNode temp = head;
        while (temp != slow) {
            slow = slow.next;
            temp = temp.next;
        }
        return temp;
    }
    public static void main(String[] args) {

        LinkedListDemo list = new LinkedListDemo();

        for (int i = 0; i < 11; i++) {
            list.addLast(i);
        }
        list.print(list.head);
        System.out.println("---reverse---");
        list.head = list.reverse(list.head);
        list.print(list.head);
        list.head = list.reverseI(list.head);
        list.print(list.head);
        System.out.println("---reverse by range---");
        list.head = list.reverseByRange(list.head, 3, 6);
        list.print(list.head);
        System.out.println("---count node---");
        System.out.println(list.countNode(list.head));
        System.out.println("---reverse by k---");
        list.head = list.reverseByK(list.head, 4);
        list.print(list.head);
        System.out.println("---swap in pairs---");
        list.head = list.swapInPairs(list.head);
        list.print(list.head);
        System.out.println("---add first node---");
        list.addFirst(3);
        list.print(list.head);
        LinkedListDemo list2 = new LinkedListDemo();
        list2.addFirst(1);
        list2.print(list2.head);
        System.out.println("---merge sort linked list---");
        list.head = list.mergeSortList(list.head);
        list.print(list.head);
        System.out.println("---insert node to a sorted linked list---");
        list.head = list.insertNode(0);
        list.head = list.insertNode(11);
        list.head = list.insertNode(9);
        list.print(list.head);
        System.out.println("---remove duplicates---");
        list.head = list.removeDuplicates();
        list.print(list.head);
        System.out.println("---reorder list---");
        list.head = list.reOrderList();
        list.print(list.head);
        System.out.println("---odd even list---");
        list.oddEvenList();
        list.print(list.head);
        System.out.println("---get starting node of a cycle in list---");
        System.out.println(list.getStartingNodeInCycle());
    }
}
