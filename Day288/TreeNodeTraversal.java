package Day288;

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
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.data);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return list;
    }

    public static List<Integer> preOrderListI(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;
        preOrderListI(root, list);
        return list;
    }
    public static void preOrderListI(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.data);
        preOrderListI(root.left, list);
        preOrderListI(root.right, list);
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
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                res.add(cur.data);
                cur = cur.right;
            }
        }
        return res;
    }

    public static List<Integer> inOrderListI(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        inOrderListI(root, res);
        return res;
    }

    public static void inOrderListI(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inOrderListI(root.left, res);
        res.add(root.data);
        inOrderListI(root.right, res);
    }

    public static boolean isLeaf(TreeNode root) {
        if (root == null) return false;
        return root.left == null && root.right == null;
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

    public static List<Integer> printLeafList(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return  res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (isLeaf(node)) {
                res.add(node.data);
            }
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return res;
    }

    public static void postOrder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastVisited = root;
        stack.push(root);
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
    }

    public static List<Integer> postOrderList(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastVisited = root;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (isLeaf(cur) || cur.left == lastVisited || cur.right == lastVisited) {
                res.add(cur.data);
                lastVisited = cur;
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
        return res;
    }

    public static List<Integer> postOrderListI(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        postOrderListI(root, res);
        return res;
    }

    private static void postOrderListI(TreeNode root, List<Integer> res) {
        if (root == null) return;
        postOrderListI(root.left, res);
        postOrderListI(root.right, res);
        res.add(root.data);
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
        preOrder(root);
        System.out.println();
        System.out.println(preOrderList(root));
        System.out.println(preOrderListI(root));

        System.out.println("====in order====");
        inOrder(root);
        System.out.println();
        System.out.println(inOrderList(root));
        System.out.println(inOrderListI(root));

        System.out.println("====post order====");
        postOrder(root);
        System.out.println();
        System.out.println(postOrderList(root));
        System.out.println(postOrderListI(root));

        System.out.println("====print leaf node====");
        printLeaf(root);
        System.out.println();
        System.out.println(printLeafList(root));
        printLeafStack(root);
        System.out.println();
    }
}
