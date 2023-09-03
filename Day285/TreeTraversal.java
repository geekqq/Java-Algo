package Day285;

import Day266.TreeNode;
import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversal {

    public static void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void preOrderI(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.data + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
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

    public static void inOrderII(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
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

    public static void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static List<Integer> postOrderII(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        postOrderII(root, res);
        return res;
    }

    private static void postOrderII(TreeNode node, List<Integer> res) {
        if (node == null) return;
        postOrderII(node.left, res);
        postOrderII(node.right, res);
        res.add(node.data);
    }


    public static boolean isLeaf(TreeNode root) {
        if (root == null) throw new IllegalArgumentException("Invalid input!");
        return root.left == null && root.right == null;
    }
    public static void postOrderI(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastNodeVisited = root;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (isLeaf(cur) || lastNodeVisited == cur.right || lastNodeVisited == cur.left) {
                System.out.print(cur.data + " ");
                lastNodeVisited = cur;
            } else {
                stack.push(cur);
                if (cur.right != null) stack.push(cur.right);
                if (cur.left != null) stack.push(cur.left);
            }
        }
    }

    public static void printLeaf(TreeNode root) {
        if (root == null) return;
        if (isLeaf(root)) System.out.print(root.data + " ");
        printLeaf(root.left);
        printLeaf(root.right);
    }

    public static void printLeafStack(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (isLeaf(node)) {
                System.out.print(node.data + " ");
            }
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

        System.out.println("===pre order====");
        preOrder(root);
        System.out.println("====");
        preOrderI(root);
        System.out.println();
        System.out.println("====in order====");
        List<Integer> inOrderList = inOrderI(root);
        System.out.println(inOrderList);
        inOrder(root);
        System.out.println();
        inOrderII(root);
        System.out.println();
        System.out.println("====post order====");
        postOrder(root);
        System.out.println();
        System.out.println(postOrderII(root));
        postOrderI(root);
        System.out.println();
        printLeaf(root);
        System.out.println();
        printLeafStack(root);

    }
}
