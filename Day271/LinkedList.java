package Day271;

import java.util.Stack;

public class LinkedList {

    private ListNode head;

    class ListNode {
        int data;
        ListNode next;

        public ListNode() {
            this(0);
        }

        public ListNode(int data) {
            this.data = data;
            next = null;
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
            System.out.print(cur.data + " --> ");
            cur = cur.next;
        }
        System.out.println("null");
    }

    public void addFirst(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
        }
        newNode.next = head;
        head = newNode;
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
        pre.next = reverseRecursion(subStart);
        subStart.next = next;

        return dummy.next;
    }

    public int countNode(ListNode head) {
        if (head == null) return 0;
        return 1 + countNode(head.next);
    }

    public int countNodeI(ListNode head) {
        if (head == null) return 0;
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public ListNode reverseByK(ListNode head, int k) {
        if (head == null) return head;
        int count = countNode(head);
        if (count< k) return head;
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

    public void removeNode(int val) {
        if (head == null) throw new RuntimeException("the list is empty!");
        if (head.data == val) {
            if (head.next == null) {
                System.out.println("Head is the only node, can not be deleted!");
            } else {
                ListNode temp = head;
                head = head.next;
                temp.next = null;
            }
        } else {
            ListNode cur = head;
            while (cur.next != null && cur.next.data != val) {
                cur = cur.next;
            }
            if (cur.next == null) {
                System.out.println("Node is not present!");
            } else {
                cur.next = cur.next.next;
            }
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
        temp.next = (firstHead != null ? firstHead : secondHead);
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

    public ListNode getStartingNodeInCycleList(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
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

    public void removeLast() {
        if (head == null || head.next == null) return;
        ListNode cur = head;
        ListNode prev = null;
        while (cur.next != null) {
            prev = cur;
            cur = cur.next;
        }
        prev.next = null;
    }
    public ListNode plusOne(ListNode head) {
        if (head == null) return null;
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
        return head;
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.addLast(i);
        }
        System.out.println(list);
        list.print(list.head);
        System.out.println("---add first---");
        list.addFirst(6);
        list.print(list.head);
        System.out.println("---reverse list---");
        list.head = list.reverse(list.head);
        list.print(list.head);
        list.head = list.reverseRecursion(list.head);
        list.print(list.head);
        System.out.println("---swap in pairs---");
        list.head = list.swapInPair(list.head);
        list.print(list.head);

        System.out.println("---count node---");
        int n = list.countNode(list.head);
        System.out.println(n);
        System.out.println(list.countNodeI(list.head));

        System.out.println("---reverse by range---");
        list.print(list.reverseByRange(list.head, 4, 8));
        System.out.println("---reverse by k---");
        list.head = list.reverseByK(list.head, 4);
        list.print(list.head);
        System.out.println("---count node---");
        System.out.println(list.countNodeI(list.head));
        System.out.println(list.countNode(list.head));
        System.out.println("---merge sort list---");
        list.head = list.mergeSort(list.head);
        list.print(list.head);
        System.out.println("---remove duplicates---");
        list.removeDuplicates(list.head);
        list.print(list.head);
        System.out.println("---insert node---");
        list.head = list.insertNode(0);
        list.head = list.insertNode(4);
        list.head = list.insertNode(5);
        list.head = list.insertNode(9);
        list.head = list.insertNode(10);
        list.print(list.head);
        System.out.println("---remove node---");
        list.removeDuplicates(list.head);
        list.print(list.head);
        list.removeNode(0);
        list.print(list.head);
        System.out.println("---reorder list---");
        list.head = list.reOrderList(list.head);
        list.print(list.head);

        System.out.println("---odd even list---");
        list.oddEvenList(list.head);
        list.print(list.head);

        System.out.println("---plus one---");
        list.plusOne(list.head);
        list.print(list.head);
        System.out.println("---remove last---");
        list.removeLast();
        list.removeLast();
        list.removeLast();
        list.removeNode(10);
        list.print(list.head);
        System.out.println("---plus one---");
        list.plusOne(list.head);
        list.print(list.head);
    }
}
