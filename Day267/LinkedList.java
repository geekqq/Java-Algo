package Day267;

import Day266.ListNode;

import java.util.Stack;

public class LinkedList {

    private ListNode head;

    public void addLast(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) head = newNode;
        else {
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
    }

    public void print(ListNode head) {
        ListNode cur = head;
        if (head == null) return;
        System.out.print(head.data + " ");
        print(head.next);
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode rest = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public ListNode reverseI(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public int countNode(ListNode head) {
        if (head == null) return 0;
        return 1 + countNode(head.next);
    }

    public int countNodeIt(ListNode head) {
        if (head == null) return 0;
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
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
        pre.next = reverse(subStart);
        subStart.next = next;

        return dummy.next;
    }

    public ListNode reverseByK(ListNode head, int k) {
        if (head == null) return head;
        int count = countNode(head);
        if (count < k) return head;
        ListNode prev = null;
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head.next = reverseByK(cur, k);
        return prev;
    }

    public ListNode reOrder(ListNode head) {
        //if (head == null || head.next == null) return head;
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
        temp.next = (firstHead != null ? firstHead : secondHead);
        return dummy.next;
    }

    public ListNode mergeSortList(ListNode head) {
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
        cur.next = (head1 != null ? head1 : head2);
        return dummy.next;
    }

    public ListNode insertNode(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null || head.data >= val) {
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
            slow = slow.next;
        }
    }

    public ListNode removeNode(int val) {
        if (head == null) {
            throw new RuntimeException("The list is null");
        }
        if (head.next == null && head.data == val) {
            System.out.println("head is the only node and can not be deleted!");
        } else if (head.data == val) {
            ListNode temp = head;
            head = head.next;
            temp.next = null;
        }
        else
        {
            ListNode cur = head;
            while (cur.next != null && cur.next.data != val) {
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

    public boolean hasCycle(ListNode head) {
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

    public ListNode hasCycleStarting(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow= slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (slow != fast) return null;
        ListNode temp = head;
        while (slow != temp) {
            slow = slow.next;
            temp = temp.next;
        }
        return temp;
    }

    public void plusOne(ListNode head) {
        if (head == null) return;
        ListNode cur = head;
        Stack<ListNode> stack = new Stack<>();
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
        for (int i = 0; i < 10; i++) {
            list.addLast(i);
        }
        list.print(list.head);
        System.out.println("---reverse list---");
        list.head = list.reverse(list.head);
        list.print(list.head);
        System.out.println();
        list.head = list.reverseI(list.head);
        list.print(list.head);
        System.out.println("---count node---");
        System.out.println(list.countNode(list.head));
        System.out.println(list.countNodeIt(list.head));
        System.out.println("---swap in pairs---");
        list.head = list.swapInPairs(list.head);
        list.print(list.head);
        System.out.println();
        System.out.println("---reverse by range---");
        list.head = list.reverseByRange(list.head, 3, 10);
        list.print(list.head);
        System.out.println();
        System.out.println("---reverse by k---");
        list.head = list.reverseByK(list.head, 4);
        list.print(list.head);
        System.out.println();
        System.out.println("---reorder list---");
        list.head = list.reOrder(list.head);
        list.print(list.head);
        System.out.println();
        System.out.println("---merge sort list---");
        list.head = list.mergeSortList(list.head);
        list.print(list.head);
        System.out.println();
        System.out.println("---insert node---");
        list.head = list.insertNode(0);
        list.head = list.insertNode(3);
        list.head = list.insertNode(10);
        list.print(list.head);
        System.out.println();
        System.out.println("---remove duplicates---");
        list.removeDuplicates();
        list.print(list.head);
        System.out.println();
        System.out.println("---delete node---");
        list.removeNode(0);
        list.removeNode(3);
        list.removeNode(10);
        list.print(list.head);
        System.out.println();
        System.out.println("---odd even list---");
        list.oddEvenList(list.head);
        list.print(list.head);
        System.out.println();
        System.out.println("---has cycle---");
        System.out.println(list.hasCycle(list.head));
        System.out.println("---plus one---");
        list.plusOne(list.head);
        list.print(list.head);
        System.out.println();
    }
}
