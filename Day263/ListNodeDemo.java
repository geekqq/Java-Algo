package Day263;

import Day262.StackDemo;

import java.time.Duration;
import java.time.Instant;
import java.util.Stack;

public class ListNodeDemo {

    private ListNode head;

    public void addFirst(int val) {
        ListNode temp = new ListNode(val);

        temp.next = head;
        head = temp;
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

    public void print() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " --> ");
            temp = temp.next;
        }
        System.out.print("null\n");
    }

    public void insertToSort(int val) {
        ListNode temp = new ListNode(val);
        if (head.val >= val) {
            temp.next = head;
            head = temp;
        } else {
            ListNode cur = head;
            ListNode pre = null;
            while (cur.val < val) {
                pre = cur;
                cur = cur.next;
            }
            pre.next = temp;
            temp.next = cur;
        }
    }

    public ListNode insertNode(ListNode head, int val) {
        ListNode temp = new ListNode(val);
        if (head == null || head.val >= val) {
            temp.next = head;
            head = temp;
        } else {
            ListNode cur = head;
            while (cur.next != null && cur.next.val < val) {
                cur = cur.next;
            }
            temp.next = cur.next;
            cur.next = temp;
        }
        return head;
    }

    public ListNode reverse() {
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

    public ListNode reverseI(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode rest = reverseI(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public void removeDuplicate() {
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

    public ListNode reverseByRange(int left, int right) {
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

    public ListNode reverseInKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) return head;
        ListNode cur = head;
        int count = 0;
        while (cur != null && count < k) {
            cur = cur.next;
            count++;
        }
        ListNode prev = null;
        ListNode next = null;
        cur = head;
        if (count < k) {
            return head;
        }
        for (int i = 0; i < k; i++) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head.next = reverseInKGroup(cur, k);
        return prev;
    }

    public int countNode() {
        if (head == null) return 0;
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
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

    public ListNode swapInPairsI(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode newHead = head.next;
        while (pre.next.next != null) {
            ListNode first = pre.next;
            ListNode second = pre.next.next;
            ListNode tail = second.next;

            pre.next = second;
            second.next = first;
            first.next = tail;
            pre = pre.next.next;

            if (pre == null || pre.next == null) break;
        }
        return newHead;
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
        return mergeList(leftHead, rightHead);
    }
    public ListNode mergeList(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        if (head1 != null) {
            cur.next = head1;
        }
        if (head2 != null) {
            cur.next = head2;
        }
            return dummy.next;
    }

    public ListNode reorderList() {
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
        temp.next = (firstHead != null ? firstHead : secondHead);
        return dummy.next;
    }

    public ListNode partitionList(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode small = new ListNode();
        ListNode large = new ListNode();
        ListNode curSmall = small;
        ListNode curLarge = large;
        while (cur != null) {
            if (cur.val < x) {
                curSmall.next = cur;
                curSmall = curSmall.next;
            } else {
                curLarge.next = cur;
                curLarge = curLarge.next;
            }
            cur = cur.next;
        }
        curSmall.next = large.next;
        return small.next;
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = head.next;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
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
        ListNodeDemo list = new ListNodeDemo();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.print();
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.print();
        System.out.println("----insert to sort----");
        ListNodeDemo list2 = new ListNodeDemo();
        for (int i = 0; i < 6; i++) {
            list2.addLast(i);
        }
        list2.print();
        list2.insertToSort(0);
        list2.print();
        System.out.println("----remove duplicates----");
        list2.removeDuplicate();
        list2.print();
        System.out.println("----reverse list----");
        list2.head = list2.reverse();
        list2.print();
        list2.head = list2.reverseI(list2.head);
        list2.print();
        System.out.println("----insert node----");
        list2.head = list2.insertNode(list2.head, 0);
        list2.insertNode(list2.head, 3);
        list2.insertNode(list2.head, 6);
        list2.print();
        System.out.println("---reverse by range----");
        list2.head = list2.reverseByRange(1, 5);
        list2.print();
        System.out.println("----reverse by K group----");
        System.out.println(list2.countNode());
        list2.head = list2.reverseInKGroup(list2.head, 4);
        list2.print();
        System.out.println("----merge sort list----");
        list2.head = list2.mergeSortList(list2.head);
        list2.print();
        System.out.println("----swap in pairs----");
        Instant startRe = Instant.now();
        list2.head = list2.swapInPairs(list2.head);
        list2.print();
        Instant endRe = Instant.now();
        System.out.println(Duration.between(startRe, endRe).getNano());

        Instant startIt = Instant.now();
        list2.head = list2.swapInPairsI(list2.head);
        list2.print();
        Instant endIt = Instant.now();
        System.out.println(Duration.between(startIt, endIt).getNano());
        System.out.println("----reorder list----");
        list2.head = list2.reorderList();
        list2.print();
        System.out.println("----partition list----");
        list2.head = list2.partitionList(list2.head, 3);
        list2.print();
        System.out.println("----odd even list----");
        list2.head = list2.oddEvenList(list2.head);
        list2.print();

        System.out.println("----plus one----");
        list2.print();
        list2.plusOne(list2.head);
        list2.print();

    }

}

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
