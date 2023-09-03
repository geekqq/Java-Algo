package Day286;

import java.util.Stack;

public class LinkedList {

    private ListNode head;
    public void add(int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            head = node;
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public void print(ListNode head) {
        if (head == null) return;
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur!= null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseRecursion(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode rest = reverseRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public ListNode swapInPair(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode postHead = swapInPair(head.next.next);
        ListNode newHead = head.next;
        head.next.next = head;
        head.next = postHead;
        return newHead;
    }

    public ListNode reverseByRange(ListNode head, int left, int right) {
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
        return 1 + countNode(head.next);
    }

    public ListNode reverseInKGroups(ListNode head, int k) {
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
        head.next = reverseInKGroups(cur, k);
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
            fast = fast.next;
        }
        prev.next = null;
        ListNode leftHead = mergeSort(head);
        ListNode rightHead = mergeSort(slow);
        return merge(leftHead, rightHead);
    }

    public ListNode merge(ListNode leftHead, ListNode rightHead) {
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

    public ListNode insertNode(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        if (head == null || head.val >= val) {
            newNode.next = head;
            head = newNode;
        } else {

            ListNode cur = head;
            while (cur.next != null && cur.next.val < val) {
                cur = cur.next;
            }
            newNode.next = cur.next;
            cur.next = newNode;
        }
        return head;
    }

    public void removeDuplicates() {
        if (head == null || head.next == null) return;
        ListNode slow = head;
        while (slow != null) {
            ListNode fast = slow.next;
            while (fast != null && slow.val == fast.val) {
                fast = fast.next;
            }
            slow.next = fast;
            slow = slow.next;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) throw new IllegalArgumentException("Invalid input!");
        if (head.val == val) {
            if (head.next == null) {
                System.out.println("Head is the only node, can not be deleted!");
            } else {
                head = head.next;
                return head;
            }
        } else {
            ListNode cur = head;
            while (cur.next != null && cur.next.val != val) {
                cur = cur.next;
            }
            if (cur.next == null) {
                System.out.println("The node is not present!");
            } else {
                cur.next = cur.next.next;
            }
        }
        return head;
    }


    public void plusOne() {
        if (head == null) return;
        ListNode cur = head;
        Stack<ListNode> stack = new Stack<>();
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

    public void reOrderList(ListNode head) {
        if (head == null || head.next == null) return;
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

    public boolean hasCycle() {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 11; i++) {
            list.add(i);
        }
        list.print(list.head);
        System.out.println("====reverse====");
        list.head = list.reverse(list.head);
        list.print(list.head);
        list.head = list.reverseRecursion(list.head);
        list.print(list.head);
        System.out.println("====swap int pairs====");
        list.head = list.swapInPair(list.head);
        list.print(list.head);
        System.out.println("====reverse by range====");
        list.head = list.reverseByRange(list.head, 3, 7);
        list.print(list.head);
        System.out.println("====reverse in k====");
        list.head = list.reverseInKGroups(list.head, 4);
        list.print(list.head);
        System.out.println("====merge sort list====");
        list.head = list.mergeSort(list.head);
        list.print(list.head);
        System.out.println("====insert node====");
        list.head = list.insertNode(list.head, 0);
        list.head = list.insertNode(list.head, 1);
        list.head = list.insertNode(list.head, 2);
        list.head = list.insertNode(list.head, 11);
        list.head = list.insertNode(list.head, 6);
        list.print(list.head);
        System.out.println("====remove duplicates====");
        list.removeDuplicates();
        list.print(list.head);
        System.out.println("====remove node====");
        list.head = list.deleteNode(list.head, 0);
        list.head = list.deleteNode(list.head, 4);
        list.head = list.deleteNode(list.head, 11);
        list.head = list.deleteNode(list.head, 10);
        list.print(list.head);
        System.out.println("====plus one====");
        list.plusOne();
        list.print(list.head);
        System.out.println("====reorder list====");
        list.reOrderList(list.head);
        list.print(list.head);
        System.out.println("====odd even list====");
        list.oddEvenList();
        list.print(list.head);
        System.out.println("====has cycle====");
        System.out.println(list.hasCycle());
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        next = null;
    }

    public ListNode(){
        this(0);
    }
}
