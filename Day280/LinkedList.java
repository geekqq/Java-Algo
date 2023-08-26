package Day280;

import java.util.NoSuchElementException;
import java.util.Stack;

public class LinkedList {

    private ListNode head;

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }

        public ListNode() {
            this(0);
        }
    }

    public void addLast(int val) {
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

    public void print(ListNode head) {
        if (head == null) return;
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.println("null");
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
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

    public ListNode reverseI(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode rest = reverseI(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public ListNode swapByPair(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode postHead = swapByPair(head.next.next);
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
        prev.next = reverseI(subStart);
        subStart.next = next;
        return dummy.next;
    }

    public int countNode(ListNode head) {
        if (head == null) return 0;
        return 1 + countNode(head.next);
    }

    public ListNode reverseByK(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) return head;
        int count = countNode(head);
        if (count < k) return head;
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        for (int i = 0; i < k; i++) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head.next = reverseByK(cur, k);
        return prev;
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

    private ListNode merge(ListNode leftHead, ListNode rightHead) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (leftHead != null && rightHead != null) {
            if (leftHead.val < rightHead.val) {
                cur.next = leftHead;
                leftHead = leftHead.next;
            } else {
                cur.next = rightHead;
                rightHead = rightHead.next;
            }
            cur = cur.next;
        }
        cur.next = leftHead != null ? leftHead : rightHead;
        return dummy.next;
    }

    public ListNode insertNode(int val)
    {
        ListNode node = new ListNode(val);
        if (head == null || head.val >= val) {
            node.next = head;
            head = node;
        } else {
            ListNode cur = head;
            ListNode prev = null;
            while (cur.next != null && cur.next.val < val) {
                cur = cur.next;
            }
            node.next = cur.next;
            cur.next = node;
        }
        return head;
    }

    public ListNode removeDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        while (slow != null) {
            ListNode fast = slow.next;
            while (fast != null && slow.val == fast.val) {
                fast = fast.next;
            }
            slow.next = fast;
            slow = slow.next;
        }
        return head;
    }

    public ListNode reorderList(ListNode head) {
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

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
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
        return head;
    }

    public ListNode removeNode(int val) {
        if (head == null) throw new NoSuchElementException("The list is empty!");
        if (head.val == val) {
            if (head.next == null) {
                System.out.println("Head is the onl node, can not be deleted!");
            } else {
                ListNode newHead = head.next;
                head.next = null;
                head = newHead;
            }
        } else {
            ListNode cur = head;
            while (cur.next != null && cur.next.val != val) {
                cur = cur.next;
            }
            if (cur.next == null) {
                System.out.println("the node is not present!");
            } else {
                cur.next = cur.next.next;
            }
        }
        return head;
    }

    public void plusOne() {
        if (head == null) throw new IllegalArgumentException();
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            if (node.val < 9) {
                node.val++;
                return;
            } else {
                node.val = 0;
            }
        }
        ListNode newNode = new ListNode(1);
        newNode.next = head;
        head = newNode;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 11; i++) {
            list.addLast(i);
        }
        list.print(list.head);
        System.out.println("====reverse list====");
        list.head = list.reverse(list.head);
        list.print(list.head);
        list.head = list.reverseI(list.head);
        list.print(list.head);
        System.out.println("====swap in pair====");
        list.head = list.swapByPair(list.head);
        list.print(list.head);
        System.out.println("====reverse by range====");
        list.head = list.reverseByRange(list.head, 4, 7);
        list.print(list.head);
        System.out.println("====reverse by k====");
        list.head = list.reverseByK(list.head, 4);
        list.print(list.head);
        System.out.println("====merge sort list====");
        list.head = list.mergeSort(list.head);
        list.print(list.head);
        System.out.println("====insert node====");
        list.head = list.insertNode(0);
        list.head = list.insertNode(5);
        list.head = list.insertNode(11);
        list.head = list.insertNode(10);
        list.print(list.head);
        System.out.println("====remove duplicates====");
        list.head = list.removeDuplicates(list.head);
        list.print(list.head);
        System.out.println("====reorder list====");
        list.head = list.reorderList(list.head);
        list.print(list.head);
        System.out.println("====odd even list====");
        list.head = list.oddEvenList(list.head);
        list.print(list.head);
        System.out.println("===remove node====");
        list.head = list.removeNode(0);
        list.head = list.removeNode(4);
        list.head = list.removeNode(11);
        list.head = list.removeNode(6);
        list.head = list.removeNode(10);
        list.addLast(9);
        list.print(list.head);
        System.out.println("====plus one====");
        list.plusOne();
        list.print(list.head);

    }
}
