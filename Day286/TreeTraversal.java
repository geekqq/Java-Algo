package Day286;

import Day266.TreeNode;
import Day51.MinStack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeTraversal {

    public static void preOrder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.data + " ");
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }

    public static List<Integer> preOrderI(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        preOrderI(root, res);
        return res;
    }
    private static void preOrderI(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.data);
        preOrderI(root.left, res);
        preOrderI(root.right, res);
    }

    public static void inOrder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                System.out.print(cur.data + " ");
                cur = cur.right;
            }
        }
    }

    public static List<Integer> inOrderI(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        inOrderI(root, res);
        return res;
    }

    private static void inOrderI(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inOrderI(root.left, res);
        res.add(root.data);
        inOrderI(root.right, res);
    }

    public static void postOrder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode lastVisitedNode = root;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (isLeaf(cur) || lastVisitedNode == cur.left || lastVisitedNode == cur.right) {
                System.out.print(cur.data + " ");
                lastVisitedNode = cur;
            } else {
                stack.push(cur);
                if (cur.right != null) stack.push(cur.right);
                if (cur.left != null) stack.push(cur.left);
            }
        }
    }

    public static List<Integer> postOrderI(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        postOrderI(root, res);
        return res;
    }

    private static void postOrderI(TreeNode root, List<Integer> res) {
        if (root == null) return;
        postOrderI(root.left, res);
        postOrderI(root.right, res);
        res.add(root.data);
    }

    public static List<Integer> postOrderII(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.addFirst(node.data);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return res;
    }
    private static boolean isLeaf(TreeNode root) {
        if (root == null) return false;
        return root.left == null && root.right == null;
    }

    public static void printLeafNode(TreeNode root) {
        if (root == null) return;
        if (isLeaf(root)) System.out.print(root.data + " ");
        printLeafNode(root.left);
        printLeafNode(root.right);
    }

    public static void printLeafNodeStack(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (isLeaf(node)) System.out.print(node.data + " ");
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        System.out.println("====pre order====");
        System.out.println(preOrderI(root));
        preOrder(root);
        System.out.println();
        System.out.println("====in order====");
        System.out.println(inOrderI(root));
        inOrder(root);
        System.out.println();
        System.out.println("====print leaf node====");
        printLeafNode(root);
        System.out.println();
        printLeafNodeStack(root);
        System.out.println();
        System.out.println("====post order====");
        postOrder(root);
        System.out.println();
        System.out.println(postOrderI(root));
        System.out.println(postOrderII(root));
    }
}
