package Day213;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ClosestValue {

    public static int closestValue(TreeNode root, double target) {
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
        return Math.abs(list.get(left) - target) <= Math.abs(list.get(right) - target) ? list.get(left) : list.get(right);
    }

    //this one is not correct, it is not returning the correct answer.
    public static int closestValueI(TreeNode root, double target) {
        if (root == null) throw new IllegalArgumentException();

        int min = root.val;
        TreeNode cur = root;
        while (cur != null) {
            if (Math.abs(cur.val - target) <= Math.abs(min - target)) {
                min = cur.val;
            }
            if (cur.val < target) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return min;
    }

    private static int res = Integer.MAX_VALUE;
    public static int closestValueII(TreeNode root, double target) {
        if (root == null) throw new IllegalArgumentException();
        dfs(root, target);
        return res;
    }
    private static void dfs(TreeNode root, double target) {
        if (root == null) return;
        if (Math.abs(root.val - target) <= Math.abs(res - target)) {
            if (Math.abs(root.val - target) == Math.abs(res - target)) {
                res = Math.min(res, root.val);
            } else {
                res = root.val;
            }
        }
        if (root.val == target) {
            return;
        }
        if (root.val > target) {
            dfs(root.left, target);
        } else {
            dfs(root.right, target);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        System.out.println(closestValue(root, 4.5));
        System.out.println(closestValueI(root, 4.5));
        System.out.println(closestValueII(root, 4.5));
    }
}


