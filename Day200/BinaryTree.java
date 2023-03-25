package Day200;

import java.util.*;
import java.util.LinkedList;

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

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        List left = inorderTraversal(root.left);
        List right = inorderTraversal(root.right);
        res.addAll(left);
        res.add((Integer) root.val);
        res.addAll(right);
        return res;
    }

    public static List<Integer> inorderTraversalI(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        inorderTraversalI(root, res);
        return res;
    }

    private static void inorderTraversalI(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorderTraversalI(root.left, res);
        res.add((Integer) root.val);
        inorderTraversalI(root.right, res);
    }

    public static List<Integer> inorderTraversalII(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur == null) {
                cur = stack.pop();
                res.add((Integer) cur.val);
                cur = cur.right;
            } else {
                stack.push(cur);
                cur = cur.left;
            }
        }
        return res;
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.addFirst((Integer) node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return res;
    }

    public static List<Integer> postorderTraversalI(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        List left = postorderTraversalI(root.left);
        List right = postorderTraversalI(root.right);
        res.addAll(left);
        res.addAll(right);
        res.add((Integer) root.val);
        return res;
    }

    public static List<Integer> postorderTraversalII(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        postorderTraversalII(root, res);
        return res;
    }

    private static void postorderTraversalII(TreeNode root, List<Integer> res) {
        if (root == null) return;
        postorderTraversalII(root.left, res);
        postorderTraversalII(root.right, res);
        res.add((Integer) root.val);
    }

    public static int maxHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxHeight(root.left), maxHeight(root.right)) + 1;
    }

    private static int maxHeightI(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int height = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                TreeNode node = que.poll();
                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
            }
            height++;
        }
        return height;
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
        System.out.println("----inorder traversal----");
        System.out.println(inorderTraversal(a));
        System.out.println(inorderTraversalI(a));
        System.out.println(inorderTraversalII(a));
        System.out.println("post order traversal----");
        System.out.println(postorderTraversal(a));
        System.out.println(postorderTraversalI(a));
        System.out.println(postorderTraversalII(a));
        System.out.println("---max height----");
        System.out.println(maxHeight(a));
        System.out.println(maxHeightI(a));
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