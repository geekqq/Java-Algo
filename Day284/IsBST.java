package Day284;

import Day266.TreeNode;

import java.util.Stack;

public class IsBST {

    public static boolean isBST(TreeNode root, long min, long max) {
        if (root == null || (root.left == null && root.right == null)) return true;
        return isBST(root.left, min, root.data) && isBST(root.right, root.data, min);
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) return true;
        if (leftNode == null || rightNode == null) return false;
        return isSymmetric(leftNode.left, rightNode.right) && isSymmetric(leftNode.right, rightNode.left);
    }

    public static boolean isSymmetricI(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()) {
            TreeNode n1 = stack.pop();
            TreeNode n2 = stack.pop();
            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null || n1.data != n2.data) return false;
            stack.push(n1.left);
            stack.push(n2.right);
            stack.push(n1.right);
            stack.push(n2.left);
        }
        return true;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.left.right = new TreeNode(4);
        System.out.println(isBST(root, Long.MIN_VALUE, Long.MAX_VALUE));
        System.out.println(isSymmetric(root));
        System.out.println(isSymmetricI(root));

    }
}
