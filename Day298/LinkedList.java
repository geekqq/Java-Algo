package Day298;

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
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
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
        head.next.next= head;
        head.next = null;
        return rest;
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
        prev.next = reverseRecursion(subStart);
        subStart.next = next;
        return dummy.next;
    }

    public int count(ListNode head) {
        if (head == null) return 0;
        return count(head.next) + 1;
    }

    public int countNode(ListNode head) {
        if (head == null) return 0;
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public ListNode reverseByKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int count = count(head);
        if (count <= k) return head;
        ListNode pre = null;
        ListNode next = null;
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = reverseByKGroup(cur, k);
        return pre;
    }

    public ListNode swapByPair(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode postHead = swapByPair(head.next.next);
        ListNode newHead = head.next;
        head.next.next = head;
        head.next = postHead;
        return newHead;
    }

    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow= slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode leftNode = mergeSort(head);
        ListNode rightNode = mergeSort(slow);
        return merge(leftNode, rightNode);
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
            while (cur.next != null && cur.next.data < val) {
                cur = cur.next;
            }
            node.next = cur.next;
            cur.next = node;
        }
        return head;
    }

    public void removeDuplicate() {
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

    public ListNode deleteNode(int val) {
        if (head == null) throw new IllegalArgumentException("Invalid input!");
        if (head.data == val) {
            if (head.next == null) {
                System.out.println("Head can not be deleted!");
            } else {
                ListNode temp = head.next;
                head.next = null;
                head = temp;
            }
        } else {
            ListNode cur = head;
            while (cur.next != null && cur.next.data != val) {
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

    public ListNode oddEvenList() {
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
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 12; i++) {
            list.add(i);
        }
        list.print(list.head);

        System.out.println("====reverse====");
        list.head = list.reverse(list.head);
        list.print(list.head);
        list.head = list.reverseRecursion(list.head);
        list.print(list.head);
        System.out.println("====reverse by range====");
        list.head = list.reverseByRange(list.head, 4,8);
        list.print(list.head);
        System.out.println("====reverse by k====");
        list.head = list.reverseByKGroup(list.head, 5);
        list.print(list.head);
        System.out.println("====merge sort list====");
        list.head = list.mergeSort(list.head);
        list.print(list.head);
        System.out.println("====insert node====");
        list.head = list.insertNode(0);
        list.head = list.insertNode(5);
        list.head = list.insertNode(11);
        list.print(list.head);
        System.out.println("====remove duplicate====");
        list.removeDuplicate();
        list.print(list.head);
        System.out.println("====delete node====");
        list.head = list.deleteNode(0);
        list.head = list.deleteNode(5);
        list.head = list.deleteNode(11);
        list.head = list.deleteNode(11);
        list.print(list.head);
        System.out.println("====plus one====");
        list.head = list.deleteNode(10);
        list.plusOne();
        list.print(list.head);
        list.plusOne();
        list.print(list.head);
        System.out.println("====reorder====");
        list.head = list.reOrderList(list.head);
        list.print(list.head);
        list.head = list.oddEvenList();
        list.print(list.head);
        System.out.println("====count node====");
        System.out.println(list.count(list.head));
        System.out.println(list.countNode(list.head));
    }
}
