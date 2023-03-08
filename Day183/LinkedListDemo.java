package Day183;

import Day174.ListNode;

import java.util.PriorityQueue;

public class LinkedListDemo {
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

    private static ListNode reverseByOne(ListNode head) {
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

    private static ListNode reverseByRange(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
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
        prev.next = reverseByOne(subStart);
        subStart.next = next;
        return dummy.next;
    }

    private static ListNode insertSortList(ListNode head) {
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

    private static ListNode sortList(ListNode head) {
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
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
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
        }
        if (leftHead != null) {
            cur.next = leftHead;
        }
        if (rightHead != null) {
            cur.next = rightHead;
        }
        return dummy.next;
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
        if (head == null || head.next == null) {
            return head;
        }
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

    public static boolean hasCycle(ListNode head) {
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

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast =fast.next.next;
            if (slow == fast) break;
        }
        if (slow != fast) return null;
        ListNode temp = head;
        while (temp != slow) {
            temp = temp.next;
            slow = slow.next;
        }
        return temp;
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

    public static ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) return null;
        ListNode p1 = head1;
        ListNode p2 = head2;
        while (p1 != p2) {
            p1 = p1 != null ? p1.next : head2;
            p2 = p2 != null ? p2.next : head1;
        }
        return p1;
    }

    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode cur = head;
        ListNode post = null;
        while (cur != null) {
            post = cur.next;
            cur.next = prev;
            prev = cur;
            cur = post;
        }
        return prev;
    }

    public static void delDuplicates(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null) {
            fast = slow.next;
            while (fast != null && slow.val == fast.val) {
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
                prev.next  = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void deleteNode(ListNode node) {
        if (node == null || node.next == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }
        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            if (tail.next != null) {
                queue.offer(tail.next);
            }
        }
        return dummy.next;
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
        //curLarge.next = null; not necessary

        return small.next;
    }

    public static ListNode plusOne(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode reverseHead = reverse(head);
        addOne(reverseHead);
        return reverse(reverseHead);
    }
    public static void addOne(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        int carry = 1;
        while (cur != null) {
            int sum = cur.val + carry;
            carry = sum >= 10 ? 1 : 0;
            if (sum < 10) {
                cur.val = sum;
                break;
            } else {
                cur.val = 0;
                prev = cur;
                cur = cur.next;
            }
        }
    }

    public static void main(String[] args) {
        LinkedListDemo list = new LinkedListDemo();
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(6);
        list.add(4);
        list.add(4);
        list.add(4);
        list.add(5);
        list.print();
        list.head = partitionList(list.head, 5);
        list.print();
        delDuplicates(list.head);
        list.print();
        list.head = reverseByRange(list.head, 1,4);
        list.print();
        list.head = sortList(list.head);
        list.print();
        list.add(0);
        list.head = swapInPairs(list.head);
        list.print();
        list.head = reverseInKGroups(list.head, 3);
        list.print();
        reorderList(list.head);
        list.print();
        System.out.println("++++++++++++++++");
        LinkedListDemo num1 = new LinkedListDemo();
        LinkedListDemo num2 = new LinkedListDemo();
        LinkedListDemo num3 = new LinkedListDemo();
        num1.add(2);
        num1.add(7);
        num1.add(2);
        num2.add(7);
        num2.add(4);
        num2.add(1);
        num2.add(9);
        num3.head = addTwoNumbers(num1.head, num2.head);
        num3.print();
        LinkedListDemo cycle = new LinkedListDemo();
        cycle.head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        cycle.head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;
        //cycle.print();
        System.out.println(hasCycle(num3.head));
        System.out.println(hasCycle(cycle.head));
        System.out.println(detectCycle(cycle.head).val);
        list.print();
        removeElements(list.head, 0);
        list.print();
        deleteNode(list.head);
        list.print();
        LinkedListDemo list1 = new LinkedListDemo();
        LinkedListDemo list2 = new LinkedListDemo();
        LinkedListDemo list3 = new LinkedListDemo();
        LinkedListDemo list4 = new LinkedListDemo();
        list1.head = new ListNode(1);
        list1.add(4);
        list1.add(5);
        list2.head = new ListNode(1);
        list2.add(3);
        list2.add(4);
        list3.head = new ListNode(2);
        list3.add(6);
        list1.print();
        list2.print();
        list3.print();
        ListNode[] lists = {list1.head, list2.head, list3.head};
        list4.head = mergeKLists(lists);
        list4.print();
        System.out.println("-----------");
        System.out.println("***********");
        delDuplicates(list4.head);
        removeElements(list4.head, 6);
        list4.print();
        oddEvenList(list.head);
        list4.print();
        System.out.println("-----------");
        LinkedListDemo listOddEven = new LinkedListDemo();
        for (int i = 1; i < 16; i++) {
            listOddEven.add(i);
        }
        listOddEven.print();
        oddEvenList(listOddEven.head);
        listOddEven.print();
        System.out.println("-----------");
        LinkedListDemo plusOne = new LinkedListDemo();
        plusOne.head = new ListNode(1);
        plusOne.add(2);
        plusOne.add(9);
        plusOne.head = plusOne(plusOne.head);
        plusOne.print();
    }
}
