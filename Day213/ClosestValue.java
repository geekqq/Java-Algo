package Day213;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ClosestValue {

    public static int ClosestValue(TreeNode root, double target) {
        List<Integer> list = inOrder(root);
        return findClosestValue(list, target);
    }

    private static List<Integer> inOrder(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }

    private static int findClosestValue(List<Integer> list, double target) {
        int left = 0;
        int right = list.size() - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) == target) return list.get(mid);
            else if (list.get(mid) < target) left = mid;
            else right = mid;
        }
        return Math.abs((double)(list.get(left) - target)) <= Math.abs((double)(list.get(right) - target)) ? list.get(left) : list.get(right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        System.out.println(ClosestValue(root, 3.5));
    }
}


