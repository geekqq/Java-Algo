package Day200;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add((Integer) node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return res;
    }

    public static List<Integer> preorderTraversalI(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        List left = preorderTraversalI(root.left);
        List right = preorderTraversalI(root.right);
        res.add((Integer) root.val);
        res.addAll(left);
        res.addAll(right);
        return res;
    }

    public static List<Integer> preorderTraversalII(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        preorderTraversalII(root, res);
        return res;
    }

    private static void preorderTraversalII(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add((Integer) root.val);
        preorderTraversalII(root.left, res);
        preorderTraversalII(root.right, res);
    }

    public static List<Integer> preorderTraversalIII(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root == null) {
                root = stack.pop();
                root = root.right;
            } else {
                res.add((Integer) root.val);
                stack.push(root);
                root = root.left;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(6);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(3);
        TreeNode f = new TreeNode(5);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(8);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        g.left = h;
        System.out.println("----pre order traversal----");
        System.out.println(preorderTraversal(a));
        System.out.println(preorderTraversalI(a));
        System.out.println(preorderTraversalII(a));
        System.out.println(preorderTraversalIII(a));
    }
}

class TreeNode<E> {
    TreeNode left;
    TreeNode right;
    E val;
    public TreeNode(E val) {
        this.val = val;
        left = null;
        right = null;
    }
}