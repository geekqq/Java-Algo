package Day289;

import Day266.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeNodeTraversal {

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
    public static List<Integer> preOrderList(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
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

    public static List<Integer> inOrderList(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        inOrderList(root, res);
        return res;
    }

    private static void inOrderList(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inOrderList(root.left, res);
        res.add(root.data);
        inOrderList(root.right, res);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        System.out.println("==== pre order ====");
        preOrder(root);
        System.out.println();
        System.out.println(preOrderList(root));
        System.out.println("==== in order ====");
        inOrder(root);
        System.out.println();
        System.out.println(inOrderList(root));
    }
}
