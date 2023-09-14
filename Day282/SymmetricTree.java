package Day282;

import Day266.TreeNode;

import java.util.Stack;

public class SymmetricTree {
    public static boolean isSymmetricTree(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        return isSymmetricTree(root.left, root.right);
    }

    private static boolean isSymmetricTree(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) return true;
        if (leftNode == null || rightNode == null ||leftNode.data != rightNode.data) return false;
        return isSymmetricTree(leftNode.left, rightNode.right) && isSymmetricTree(leftNode.right, rightNode.left);
    }

    public static boolean isSymmetricTreeStack(TreeNode root) {
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
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);
        System.out.println(isSymmetricTree(root));
        System.out.println(isSymmetricTreeStack(root));
    }
}
