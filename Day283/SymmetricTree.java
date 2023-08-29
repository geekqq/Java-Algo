package Day283;

import Day266.TreeNode;

import java.util.Stack;

public class SymmetricTree {

    public static boolean isSymmetricTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        return isSymmetricTree(root.left, root.right);
    }

    private static boolean isSymmetricTree(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) return true;
        if (leftNode == null || rightNode == null) return false;
        return isSymmetricTree(leftNode.left, rightNode.right) && isSymmetricTree(leftNode.right, rightNode.left);
    }


    public static boolean isSymmetricTreeI(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()) {
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();
            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null || node1.data != node2.data) return false;
            stack.push(node1.left);
            stack.push(node2.right);
            stack.push(node1.right);
            stack.push(node2.left);
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
        System.out.println(isSymmetricTree(root));
        System.out.println(isSymmetricTreeI(root));

    }


}
