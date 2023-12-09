package Day328;

import Day266.ListNode;

public class LinkedList {
    private ListNode head;

    public void add(int val) {
        ListNode node = new ListNode(val);
        if (head == null) head = node;
        else {
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    public void print(ListNode head) {
        if(head == null) return;
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.data + "--");
            cur = cur.next;
        }
        System.out.println("null");
    }

    public ListNode reverse(ListNode head) {
        if (head == null) return null;
        ListNode prev = null;
        ListNode next = null;
        ListNode cur = head;
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        ListNode cur = prev.next;
        for (int i = left; i < right; i++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }
        return dummy.next;
    }

    public ListNode reverseByGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        if (count < k) return head;
        ListNode prev = null;
        ListNode next = null;
        cur = head;
        for (int i = 0; i < k; i++) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head.next = reverseByGroup(cur, k);
        return prev;
    }

    public ListNode swapInPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode postHead = swapInPairs(head.next.next);
        ListNode newHead = head.next;
        head.next.next = head;
        head.next = postHead;
        return newHead;
    }

    public ListNode mergeSortList(ListNode head) {
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
        ListNode leftHead = mergeSortList(head);
        ListNode rightHead = mergeSortList(slow);
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
        if (head == null) {
            head = node;
        } else {
            if (head.data >= val) {
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
        }
        return head;
    }

    public void removeDuplicateNode(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head;
        while (slow != null && slow.next != null) {
            ListNode fast = slow.next;
            while (fast != null && fast.data == slow.data) {
                fast = fast.next;
            }
            slow.next = fast;
            slow = slow.next;
        }
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
    public ListNode partitionList(ListNode head, int val) {
        if (head ==null || head.next == null) return head;
        ListNode small = new ListNode();
        ListNode large = new ListNode();
        ListNode curSmall = small;
        ListNode curLarge = large;
        ListNode cur = head;
        while (cur != null) {
            if (cur.data < val) {
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
        ListNode even = head.next;
        ListNode evenHead = head.next;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 15; i++) {
            list.add(i);
        }
        list.print(list.head);
        System.out.println("====reverse list====");
        list.head = list.reverse(list.head);
        list.print(list.head);
        list.head = list.reverseRecursion(list.head);
        list.print(list.head);
        System.out.println("====reverse by range====");
        list.head = list.reverseByRange(list.head, 5, 10);
        list.print(list.head);
        System.out.println("====reverse between====");
        list.head = list.reverseBetween(list.head, 5, 10);
        list.print(list.head);
        System.out.println("====reverse by K group====");
        list.head = list.reverseByGroup(list.head, 4);
        list.print(list.head);
        System.out.println("====swap in pairs====");
        list.head = list.swapInPairs(list.head);
        list.print(list.head);
        System.out.println("====merge sort list====");
        list.head = list.mergeSortList(list.head);
        list.print(list.head);
        System.out.println("====insert node====");
        list.head = list.insertNode(0);
        list.head = list.insertNode(4);
        list.head = list.insertNode(15);
        list.print(list.head);
        System.out.println("====remove duplicates====");
        list.removeDuplicateNode(list.head);
        list.print(list.head);
        System.out.println("====reorder list====");
        list.head = list.reorderList(list.head);
        list.print(list.head);
        System.out.println("====partition list====");
        list.head = list.partitionList(list.head, 5);
        list.print(list.head);
        System.out.println("====odd even list====");
        list.head = list.oddEvenList(list.head);
        list.print(list.head);
    }

}
