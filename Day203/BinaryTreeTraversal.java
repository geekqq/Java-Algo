package Day203;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraversal {

    public static List<Integer> preorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        List left = preorder(root.left);
        List right = preorder(root.right);
        res.add((Integer) root.val);
        res.addAll(left);
        res.addAll(right);
        return res;
    }
    public static List<Integer> preorderI(TreeNode root) {
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

    public static List<Integer> preorderII(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        preorderII(root, res);
        return res;
    }

    private static void preorderII(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add((Integer) root.val);
        preorderII(root.left, res);
        preorderII(root.right, res);
    }

    public static List<Integer> preorderIII(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                res.add((Integer) cur.val);
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                cur = cur.right;
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
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        System.out.println("----pre order----");
        System.out.println(preorder(a));
        System.out.println(preorderI(a));
        System.out.println(preorderII(a));
        System.out.println(preorderIII(a));
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
