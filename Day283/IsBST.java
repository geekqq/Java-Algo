package Day283;

import Day266.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class IsBST {


    private static boolean isBST(TreeNode root, long min, long max) {
        if (root == null || (root.left == null && root.right == null)) return true;
        if (root.data >= max || root.data <= min) return false;
        return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
    }

    public static void levelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            System.out.print(node.data + " ");
            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        System.out.println(isBST(root, Long.MIN_VALUE, Long.MAX_VALUE));
        levelOrder(root);
    }
}
