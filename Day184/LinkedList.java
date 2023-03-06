package Day184;

import Day174.ListNode;

import java.util.Stack;

public class LinkedList {
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

    public static ListNode reverse(ListNode head) {
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

    public static ListNode reverseByRange(ListNode head, int left, int right) {
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
        prev.next = reverse(subStart);
        subStart.next = next;

        return dummy.next;
    }

    public static ListNode mergeSortList(ListNode head) {
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
        ListNode left = mergeSortList(head);
        ListNode right = mergeSortList(slow);
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
            if (leftHead != null) {
                cur.next = leftHead;
            }
            if (rightHead != null) {
                cur.next = rightHead;
            }
        }
        return dummy.next;
    }

    public static ListNode insertSortList(ListNode head) {
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
    public static void deleteDuplicates(ListNode head) {
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

    public static ListNode removeElement(ListNode head, int val) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
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

    public static ListNode hasCycleII(ListNode head) {
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
        while (temp != slow) {
            temp = temp.next;
            slow = slow.next;
        }
        return temp;
    }
    public static ListNode swapInPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode postHead = swapInPairs(head.next.next);
        head.next.next = head;
        ListNode newHead = head.next;
        head.next = postHead;
        return newHead;
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
        if (head == null || head.next == null) return head;
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
        curLarge.next = null;
        return small.next;
    }

    public static ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode lastNotNine = dummy;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val != 9) {
                lastNotNine = cur;
            }
            cur = cur.next;
        }
        lastNotNine.val++;
        cur = lastNotNine.next;
        while (cur != null) {
            cur.val = 0;
            cur = cur.next;
        }
        return dummy.val == 1 ? dummy : dummy.next;
    }

    public static ListNode plusOneII(ListNode head) {
        if (head == null) return null;
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (!stack.isEmpty()) {
            ListNode n = stack.pop();
            if (n.val < 9) {
                n.val = n.val + 1;
                return head;
            } else {
                n.val = 0;
            }
        }
        ListNode newHead = new ListNode(1);
        newHead.next = head;
        return newHead;
    }

    public static ListNode reverseInKGroups(ListNode head, int k) {
        if (head == null || head.next == null) return head;
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

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        while (cur1 != cur2) {
            cur1 = cur1 != null ? cur1.next : headB;
            cur2 = cur2 != null ? cur2.next : headA;
        }
        return cur1;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(3);
        list.add(0);
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(2);
        list.add(4);
        list.add(4);
        list.add(4);
        list.add(4);
        list.print();
        list.head = mergeSortList(list.head);
        list.print();
        list.head = reverseByRange(list.head, 1, 4);
        list.print();
        list.head = swapInPairs(list.head);
        list.print();
        System.out.println("----reverse in k----");
        list.head = reverseInKGroups(list.head, 4);
        list.print();
        deleteDuplicates(list.head);
        list.print();
        list.head = insertSortList(list.head);
        list.print();
        System.out.println("---------------");
        list.head = removeElement(list.head, 1);
        list.print();
        oddEvenList(list.head);
        list.print();
        System.out.println("----partition list----");
        list.head = mergeSortList(list.head);
        deleteDuplicates(list.head);
        list.print();
        list.head = partitionList(list.head, 3);
        list.print();
        System.out.println("_______________");
        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        LinkedList list1 = new LinkedList();
        list1.head = node0;
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        //node5.next = node3;
        list1.print();
        System.out.println(hasCycle(list1.head));
        list1.deleteNode(node3);
        list1.print();
        System.out.println("----check cycle of list----");
        LinkedList list2 = new LinkedList();
        ListNode node20 = new ListNode(20);
        ListNode node21 = new ListNode(21);
        ListNode node22 = new ListNode(22);
        ListNode node23 = new ListNode(23);
        ListNode node24 = new ListNode(24);
        ListNode node25 = new ListNode(25);
        ListNode node26 = new ListNode(26);
        list2.head = node20;
        node20.next = node21;
        node21.next = node22;
        node22.next = node23;
        node23.next = node24;
        node24.next = node25;
        node25.next = node26;
        node26.next = node24;
        System.out.println(hasCycle(list2.head));
        System.out.println(hasCycleII(list2.head).val);
        System.out.println("----plus one----");
        LinkedList num = new LinkedList();
        num.add(9);
        System.out.println(num.head.val);
        num.print();
        num.head = plusOne(num.head);
        num.print();
        System.out.println("----intersection node----");
        LinkedList list3 = new LinkedList();
        LinkedList list4 = new LinkedList();
        LinkedList list5 = new LinkedList();
        ListNode node30 = new ListNode(30);
        ListNode node31 = new ListNode(31);
        ListNode node41 = new ListNode(41);
        ListNode node42 = new ListNode(42);
        ListNode node43 = new ListNode(43);
        ListNode node51 = new ListNode(51);
        ListNode node52 = new ListNode(52);
        ListNode node53 = new ListNode(53);
        node30.next = node31;
        node31.next = node51;
        node41.next = node42;
        node42.next = node43;
        node43.next = node51;
        node51.next = node52;
        node52.next = node53;
        list3.head = node30;
        list4.head = node41;
        System.out.println(getIntersectionNode(list3.head, list4.head).val);
    }
}
