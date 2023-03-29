package Day204;

import com.sun.source.tree.Tree;

import java.util.*;

public class BinaryTree {


    public static List<Integer> preOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return res;
    }

    public static List<Integer> preOrderI(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        List left = preOrderI(root.left);
        List right = preOrderI(root.right);
        res.add(root.val);
        res.addAll(left);
        res.addAll(right);
        return res;
    }

    public static List<Integer> preOrderII(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        preOrderII(root, res);
        return res;
    }

    private static void preOrderII(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        preOrderII(root.left, res);
        preOrderII(root.right, res);
    }

    public static List<Integer> preOrderIII(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                res.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                cur = cur.right;
            }
        }
        return res;
    }

    public static List<Integer> inOrderI(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        List left = inOrderI(root.left);
        List right = inOrderI(root.right);
        res.addAll(left);
        res.add(root.val);
        res.addAll(right);
        return res;
    }

    public static List<Integer> inOrderII(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        inOrderII(root, res);
        return res;
    }

    private static void inOrderII(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inOrderII(root.left, res);
        res.add(root.val);
        inOrderII(root.right, res);
    }

    public static List<Integer> inOrder(TreeNode root) {
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
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }

    public static List<Integer> postOrder(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.addFirst(node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return res;
    }

    public static List<Integer> levelOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            res.add(node.val);
            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }
        return res;
    }

    public static List<Integer> levelOrderI(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode node = q.poll();
                res.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
        return res;
    }
    public static List<Integer> postOrderI(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        List left = postOrderI(root.left);
        List right = postOrderI(root.right);
        res.addAll(left);
        res.addAll(right);
        res.add(root.val);
        return res;
    }

    public static int maxHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxHeight(root.left), maxHeight(root.right)) + 1;
    }

    public static int maxHeightI(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> que = new LinkedList<>();
        int height = 0;
        que.offer(root);
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
    public static List<Integer> postOrderII(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        postOrderII(root, res);
        return res;
    }

    private static void postOrderII(TreeNode root, List<Integer> res) {
        if (root == null) return;
        postOrderII(root.left, res);
        postOrderII(root.right, res);
        res.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        System.out.println("----pre order traversal----");
        System.out.println(preOrder(root));
        System.out.println(preOrderI(root));
        System.out.println(preOrderII(root));
        System.out.println(preOrderIII(root));
        System.out.println("----in order traversal----");
        System.out.println(inOrder(root));
        System.out.println(inOrderI(root));
        System.out.println(inOrderII(root));
        System.out.println("----post order----");
        System.out.println(postOrder(root));
        System.out.println(postOrderI(root));
        System.out.println(postOrderII(root));
        System.out.println("----level order----");
        System.out.println(levelOrder(root));
        System.out.println(levelOrderI(root));
        System.out.println("---max height----");
        System.out.println(maxHeight(root));
        System.out.println(maxHeightI(root));
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}
