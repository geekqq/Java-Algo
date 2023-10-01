package Day311;

import Day266.ListNode;

import java.util.Stack;

public class LinkedList {

    private ListNode head;


    public void add(int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            head = node;
        } else {
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    public void print(ListNode head) {
        if (head == null) return;
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.data + "-->");
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
        return 1 + countNode(head.next);
    }

    public int count() {
        if (head == null) return 0;
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public ListNode reverseByK(ListNode head, int k) {
        if (head == null || head.next == null) return head;
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
            if (leftHead.data < rightHead.data) {
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

    public ListNode insertNode(int val) {
        ListNode node = new ListNode(val);
        if (head == null || head.data >= val) {
            node.next = head;
            head = node;
        } else {
            ListNode cur = head;
            while (cur.next != null && cur.next.data != val) {
                cur = cur.next;
            }
            node.next = cur.next;
            cur.next = node;
        }
        return head;
    }

    public void removeDuplicates() {
        if (head == null || head.next == null) return;
        ListNode slow = head;
        while (slow != null) {
            ListNode fast = slow.next;
            while (fast != null && slow.data == fast.data) {
                fast = fast.next;
            }
            slow.next = fast;
            slow= slow.next;
        }
    }

    public ListNode partitionList(ListNode head) {

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

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
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
        if (head == null) throw new IllegalArgumentException();
        if (head.data == val) {
            if (head.next == null) {
                System.out.println("Head is the only node, can not be deleted!");
            } else {
                ListNode newHead = head.next;
                head.next = null;
                head = newHead;
            }
        } else {
            ListNode cur = head;
            while (cur.next != null && cur.next.data != val) {
                cur = cur.next;
            }
            if (cur.next == null) System.out.println("The node is not present");
            else {
                cur.next = cur.next.next;
            }
        }
        return head;
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
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 15; i++) {
            list.add(i);
        }
        list.print(list.head);
        System.out.println("==== reverse ====");
        list.head = list.reverse(list.head);
        list.print(list.head);
        list.head = list.reverseRecursion(list.head);
        list.print(list.head);
        System.out.println("==== reverse by range====");
        list.head = list.reverseByRange(list.head, 5, 10);
        list.print(list.head);
        System.out.println("==== reverse by k====");
        list.head = list.reverseByK(list.head, 4);
        list.print(list.head);
        System.out.println("==== merge sort list ====");
        list.head = list.mergeSort(list.head);
        list.print(list.head);
        System.out.println("==== insert node ====");
        list.insertNode(0);
        list.insertNode(5);
        list.insertNode(14);
        list.insertNode(15);
        list.print(list.head);
        System.out.println("==== remove duplicates ====");
        list.removeDuplicates();
        list.print(list.head);
        System.out.println("==== partition list ====");
        list.head = list.partitionList(list.head);
        list.print(list.head);
        System.out.println("==== odd even list ====");
        list.head = list.oddEvenList(list.head);
        list.print(list.head);
        System.out.println("==== remove node ====");
        list.head = list.removeNode(0);
        list.head = list.removeNode(5);
        list.head = list.removeNode(14);
        list.head = list.removeNode(15);
        list.head = list.removeNode(13);
        list.head = list.removeNode(12);
        list.head = list.removeNode(11);
        list.head = list.removeNode(10);
        list.head = list.removeNode(8);
        list.print(list.head);
        System.out.println("==== plus one ====");
        list.plusOne();
        list.print(list.head);
        list.plusOne();
        list.print(list.head);
        list.plusOne();
        list.print(list.head);
    }
}
