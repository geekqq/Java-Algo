package Day265;

import Day221.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class FindMax {

    public static int findMax(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int max = root.val;
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp.val > max) {
                max = temp.val;
            }
            if (temp.left != null) q.offer(temp.left);
            if (temp.right != null) q.offer(temp.right);
        }
        return max;
    }

    public static int findMaxUsingRecursion(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        int res = root.val;
        int leftMax = findMaxUsingRecursion(root.left);
        int rightMax = findMaxUsingRecursion(root.right);
        res = Math.max(res, Math.max(leftMax, rightMax));
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(8);
        root.right = new TreeNode(10);
        System.out.println(findMax(root));
        System.out.println(findMaxUsingRecursion(root));
    }
}
