package Day202;

import java.util.*;
import java.util.LinkedList;

public class BinaryTreeTraversal {

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        List left = preorderTraversal(root.left);
        List right = preorderTraversal(root.right);
        res.add((Integer) root.val);
        res.addAll(left);
        res.addAll(right);
        return res;
    }

    public static List<Integer> preorderTraversalI(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        preorderTraversalI(root, res);
        return res;
    }

    private static void preorderTraversalI(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add((Integer) root.val);
        preorderTraversalI(root.left, res);
        preorderTraversalI(root.right, res);
    }

    public static List<Integer> preorderTraversalII(TreeNode root) {
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
    public static List<Integer> preorderTraversalIII(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                res.add((Integer) root.val);
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
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
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                res.add((Integer) cur.val);
                cur = cur.right;
            }
        }
        return res;
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
        if (root == null) return res;
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
        LinkedList<Integer> res = new LinkedList();
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

    public static List<Integer> levelOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add((Integer) node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return res;
    }

    public static int getSum(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int sum = 0;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            sum += (Integer) node.val;
            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }
        return sum;
    }

    public static int getSumI(TreeNode root) {
        if (root == null) return 0;
        int left = getSumI(root.left);
        int right = getSumI(root.right);
        return left + right + (Integer) root.val;
    }

    public static int getHeight(TreeNode root) {
        if (root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right) + 1;
    }

    public static int getHeightI(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int height = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode node = q.poll();
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
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
        a.left = b;
        b.left = d;
        b.right = e;
        a.right = c;
        c.left = f;
        c.right = g;
        System.out.println("----preorder----");
        System.out.println(preorderTraversal(a));
        System.out.println(preorderTraversalI(a));
        System.out.println(preorderTraversalII(a));
        System.out.println(preorderTraversalIII(a));
        System.out.println("----in order ----");
        System.out.println(inorderTraversal(a));
        System.out.println(inorderTraversalI(a));
        System.out.println(inorderTraversalII(a));
        System.out.println("----post order----");
        System.out.println(postorderTraversal(a));
        System.out.println(postorderTraversalI(a));
        System.out.println(postorderTraversalII(a));
        System.out.println("----level order----");
        System.out.println(levelOrderTraversal(a));
        System.out.println("----get sum----");
        System.out.println(getSum(a));
        System.out.println(getSumI(a));
        System.out.println("----get height of tree");
        System.out.println(getHeight(a));
        System.out.println(getHeightI(a));

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