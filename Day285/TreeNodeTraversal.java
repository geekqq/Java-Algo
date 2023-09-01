package Day285;

import Day266.TreeNode;


import java.util.Stack;

public class TreeNodeTraversal {

    public static void postOrder(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException();
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode lastPrintedNode = root;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (isLeaf(cur)|| lastPrintedNode == cur.right || lastPrintedNode == cur.left) {
                System.out.print(cur.data + " ");
                lastPrintedNode = cur;
            } else {
                stack.push(cur);
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
    }

    public static boolean isLeaf(TreeNode root) {
        if (root == null) throw new IllegalArgumentException("The tree is empty!");
        return root.left == null && root.right == null;
    }

    public static void printLeafNode(TreeNode root) {
        if (isLeaf(root)) System.out.print(root.data + " ");
        if (root.left != null) printLeafNode(root.left);
        if (root.right != null) printLeafNode(root.right);
    }

    private static void printLeafNodeStack(TreeNode root) {
        if (root == null) throw new IllegalArgumentException();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (isLeaf(node)) {
                System.out.print(node.data + " ");
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
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
        System.out.println("====print the leaf node====");
        printLeafNode(root);
        System.out.println();
        printLeafNodeStack(root);
        System.out.println();
        System.out.println("====post order====");
        postOrder(root);
    }
}
