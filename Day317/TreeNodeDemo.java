package Day317;

import Day266.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeNodeDemo {

    private TreeNode root;

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
        System.out.println();
    }
    public static List<Integer> preOrderList(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrderList(root, res);
        return res;
    }
    private static void preOrderList(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.data);
        preOrderList(root.left, res);
        preOrderList(root.right, res);
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
        System.out.println();
    }

    public static List<Integer> inOrderList(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrderList(root, res);
        return res;
    }

    private static void inOrderList(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inOrderList(root.left, res);
        res.add(root.data);
        inOrderList(root.right, res);
    }

    public static int count(TreeNode root) {
        if (root == null) return 0;
        return 1 + count(root.left) + count(root.right);
    }

    public static int countStack(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int count = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            count++;
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return count;
    }

    public static boolean isLeaf(TreeNode root) {
        if (root == null) return false;
        return root.left == null && root.right == null;
    }

    public static void postOrder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode lastVisited = null;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (isLeaf(cur) || cur.left == lastVisited || cur.right == lastVisited) {
                System.out.print(cur.data + " ");
                lastVisited = cur;
            } else {
                stack.push(cur);
                if (cur.right != null) stack.push(cur.right);
                if (cur.left != null) stack.push(cur.left);
            }
        }
        System.out.println();
    }

    public static List<Integer> postOrderList(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrderList(root, res);
        return res;
    }

    private static void postOrderList(TreeNode root, List<Integer> res) {
        if (root == null) return;
        postOrderList(root.left, res);
        postOrderList(root.right, res);
        res.add(root.data);
    }


    public static boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null || (root.left == null && root.right == null)) return true;
        return isValidBST(root.left, min, root.data) && isValidBST(root.right, root.data, max);
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return true;
        return isSymmetric(root.left, root.right);
    }
    private static boolean isSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) return true;
        if (leftNode == null || rightNode == null || leftNode.data != rightNode.data) return false;
        return isSymmetric(leftNode.left, rightNode.right) && isSymmetric(leftNode.right, rightNode.left);
    }

    public static boolean isSymmetricStack(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return true;
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
    public static boolean sameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.data != q.data) return false;
        return sameTree(p.left, q.left) && sameTree(p.right, q.right);
    }

    public static void printLeaf(TreeNode root) {
        if (root == null) return;
        if (isLeaf(root)) System.out.print(root.data + " ");
        printLeaf(root.left);
        printLeaf(root.right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        System.out.println("===count node===");
        System.out.println(count(root));
        System.out.println(countStack(root));
        System.out.println("===pre order===");
        preOrder(root);
        System.out.println(preOrderList(root));
        System.out.println("===in order===");
        inOrder(root);
        System.out.println(inOrderList(root));
        System.out.println("===post order===");
        postOrder(root);
        System.out.println(postOrderList(root));
        System.out.println("===print leaf===");
        printLeaf(root);
        System.out.println();
        System.out.println("=== bst and symmetric tree validation===");
        System.out.println(isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE));
        System.out.println(isSymmetric(root));
        System.out.println(isSymmetricStack(root));
    }
}
