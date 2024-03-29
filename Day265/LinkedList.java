package Day265;

import java.util.Stack;

public class LinkedList {
    private ListNode head;

    private class ListNode {
        private int data;
        private ListNode next;

        public ListNode() {
            this(0);
        }

        public ListNode(int data) {
            this.data = data;
            next = null;
        }
    }

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
        ListNode temp = head;
        if (head == null) return;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode next = null;
        ListNode cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode reverseRecursion(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode rest = reverseRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public ListNode swapInPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode postHead = swapInPairs(head.next.next);
        ListNode newHead = head.next;
        head.next.next = head;
        head.next = postHead;
        return newHead;
    }

    public ListNode reverseByRange(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
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

    public int countNode(ListNode head) {
        if (head == null) return 0;
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }

    public ListNode reverseInKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) return head;
        int count = countNode(head);
        if (count <= k) return head;
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;
        for (int i = 0; i < k; i++) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head.next = reverseInKGroup(cur, k);
        return prev;
    }

    public void removeDuplicates(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head;
        while (slow != null) {
            ListNode fast = slow.next;
            while (fast != null && slow.data == fast.data) {
                fast = fast.next;
            }
            slow.next = fast;
            slow = slow.next;
        }
    }

    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode leftHead = mergeSort(head);
        ListNode rightHead = mergeSort(slow);
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
        cur.next = (head1 != null ? head1 : head2);
        return dummy.next;
    }


    public void insertNode(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        if (head.data >= val) {
            newNode.next = head;
            head = newNode;
        } else {
            ListNode cur = head;
            while (cur.next != null && cur.next.data < val) {
                cur = cur.next;
            }
            newNode.next = cur.next;
            cur.next = newNode;
        }
    }

    public ListNode reOrderList(ListNode head) {
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
        ListNode secondHead = reverse(temp);

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

    public void oddEvenList(ListNode head) {
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

    public void plusOne(ListNode head) {
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
                break;
            } else {
                node.data = 0;
            }
        }
        ListNode newNode = new ListNode(1);
        newNode.next = head;
        head = newNode;
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.addLast(i);
        }
        list.print(list.head);
        list.head = list.reverse(list.head);
        list.print(list.head);
        list.head = list.swapInPairs(list.head);
        list.print(list.head);
        list.head = list.reverseByRange(list.head, 2, 6);
        list.print(list.head);
        list.head = list.reverseInKGroup(list.head, 4);
        list.print(list.head);
        list.addLast(5);
        list.addLast(6);
        list.print(list.head);

        list.head = list.mergeSort(list.head);
        list.print(list.head);

        list.removeDuplicates(list.head);
        list.print(list.head);
        list.insertNode(list.head, 3);
        list.insertNode(list.head, 7);
        list.print(list.head);
        list.head = list.swapInPairs(list.head);
        list.print(list.head);

        list.head = list.reOrderList(list.head);
        list.print(list.head);
        list.oddEvenList(list.head);
        list.print(list.head);
    }
}
