package Day317;

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
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode rest = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public static ListNode reverseI(ListNode head) {
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

    public static ListNode swapInPais(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode postHead = swapInPais(head.next.next);
        ListNode newHead = head.next;
        head.next.next = head;
        head.next = postHead;
        return newHead;
    }

    public static int countNode(ListNode head) {
        if (head == null) return 0;
        return 1 + countNode(head.next);
    }

    public static int countNodeI(ListNode head) {
        if (head == null) return 0;
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }
    public static ListNode reverseInK(ListNode head, int k) {
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
        head.next = reverseInK(cur, k);
        return prev;
    }

    public static ListNode reverseByRange(ListNode head, int left, int right) {
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

    public static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast =fast.next.next;
        }
        prev.next = null;
        ListNode leftHead = mergeSort(head);
        ListNode rightHead = mergeSort(slow);
        return merge(leftHead, rightHead);
    }

    private static ListNode merge(ListNode leftHead, ListNode rightHead) {
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
        cur.next = leftHead !=  null ? leftHead : rightHead;
        return dummy.next;
    }

    public static ListNode insertNode(ListNode head, int val) {
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

    public static void removeDuplicates(ListNode head) {
        if (head == null) return;
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

    public static ListNode partitionList(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode small = new ListNode();
        ListNode large = new ListNode();
        ListNode curSmall = small;
        ListNode curLarge = large;
        ListNode cur = head;
        while (cur != null) {
            if (cur.data < k) {
                curSmall.next = cur;
                curSmall = curSmall.next;
            } else {
                curLarge.next = cur;
                curLarge= curLarge.next;
            }
            cur = cur.next;
        }
        curSmall.next = large.next;
        return small.next;
    }

    public static ListNode reOrderList(ListNode head) {
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
            firstHead= firstHead.next;
            temp = temp.next;

            temp.next = secondHead;
            secondHead = secondHead.next;
            temp = temp.next;
        }
        temp.next = firstHead != null ? firstHead : secondHead;
        return dummy.next;
    }

    public static ListNode oddEvenList(ListNode head) {
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

    public static ListNode remove(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        if (head.data == val) {
            if (head.next == null) {
                System.out.println("Head is only node, can not be deleted!");
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
            if (cur.next == null) System.out.println("The node is not present!");
            cur.next = cur.next.next;
        }
        return head;
    }

    public static void plusOne(ListNode head) {
        if (head == null) return;
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        };
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            if (node.data == 9) {
                node.data = 0;
            } else {
                node.data++;
                return;
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
        System.out.println("====reverse====");
        list.head = reverse(list.head);
        list.print(list.head);
        list.head = reverseI(list.head);
        list.print(list.head);
        System.out.println("====reverse by range=====");
        list.head = reverseByRange(list.head, 4, 11);
        list.print(list.head);
        System.out.println("====reverse in k=====");
        list.head = reverseInK(list.head, 4);
        list.print(list.head);
        System.out.println("====count====");
        System.out.println(countNode(list.head));
        System.out.println(countNodeI(list.head));
        System.out.println("====swap in pairs====");
        list.head = swapInPais(list.head);
        list.print(list.head);
        System.out.println("====merge sort list====");
        list.head = mergeSort(list.head);
        list.print(list.head);
        System.out.println("====insert node====");
        list.head = insertNode(list.head, 0);
        list.head = insertNode(list.head, 5);
        list.head = insertNode(list.head, 14);
        list.head = insertNode(list.head, 15);
        list.print(list.head);
        System.out.println("====remove duplicates====");
        removeDuplicates(list.head);
        list.print(list.head);
        System.out.println("====re order List====");
        list.head = reOrderList(list.head);
        list.print(list.head);
        System.out.println("====partitionList====");
        list.head = partitionList(list.head, 5);
        list.print(list.head);
        System.out.println("====re order list====");
        list.head = reOrderList(list.head);
        list.print(list.head);
        System.out.println("====odd even list====");
        oddEvenList(list.head);
        list.print(list.head);
        System.out.println("====remove node====");
        list.head = remove(list.head, 0);
        list.head = remove(list.head, 15);
        list.head = remove(list.head, 11);
        list.head = remove(list.head, 12);
        list.head = remove(list.head, 10);
        list.print(list.head);
        System.out.println("====plus one====");
        plusOne(list.head);
        list.print(list.head);
        removeDuplicates(list.head);
        list.head = remove(list.head, 6);
        plusOne(list.head);
        list.print(list.head);
    }
}
