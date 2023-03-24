package Day199;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraversal {
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
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                res.add((Integer) cur.val);
                cur =cur.right;
            }
        }
        return res;
    }

    public static List<Integer> inorderTraversalI(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        List left = inorderTraversalI(root.left);
        List right = inorderTraversalI(root.right);
        res.addAll(left);
        res.add((Integer) root.val);
        res.addAll(right);
        return res;
    }

    public static List<Integer> inorderTraversalII(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        inorderTraversalII(root, res);
        return res;
    }

    private static void inorderTraversalII(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorderTraversalII(root.left, res);
        res.add((Integer) root.val);
        inorderTraversalII(root.right, res);
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        List left = postorderTraversal(root.left);
        List right = postorderTraversal(root.right);
        res.addAll(left);
        res.addAll(right);
        res.add((Integer) root.val);
        return res;
    }

    public static List<Integer> postorderTraversalI(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderTraversalI(root, res);
        return res;
    }

    private static void postorderTraversalI(TreeNode root, List<Integer> res) {
        if (root == null) return;
        postorderTraversalI(root.left, res);
        postorderTraversalI(root.right, res);
        res.add((Integer) root.val);
    }

    public static List<Integer> postorderTraversalII(TreeNode root) {
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


    public static void main(String[] args) {
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(6);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(3);
        TreeNode f = new TreeNode(5);
        TreeNode g = new TreeNode(7);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        System.out.println("----pre order traversal----");
        System.out.println(preorderTraversal(a));
        System.out.println(preorderTraversalI(a));
        System.out.println(preorderTraversalII(a));
        System.out.println(preorderTraversalIII(a));
        System.out.println("----in order traversal----");
        System.out.println(inorderTraversal(a));
        System.out.println(inorderTraversalI(a));
        System.out.println(inorderTraversalII(a));
        System.out.println("----post order traversal----");
        System.out.println(postorderTraversal(a));
        System.out.println(postorderTraversalI(a));
        System.out.println(postorderTraversalII(a));
    }
}

class TreeNode<E> {
    E val;
    TreeNode left;
    TreeNode right;
    public TreeNode(E val) {
        this.val = val;
        left = null;
        right = null;
    }
}
