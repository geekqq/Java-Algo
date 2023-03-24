package Day199;

import com.sun.source.tree.Tree;

import java.util.*;

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

    public static List<Integer> leverOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                TreeNode node = que.poll();
                res.add((Integer) node.val);
                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
            }
        }
        return res;
    }

    public static List<Integer> levelOrderTraversalI(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            res.add((Integer) node.val);
            if (node.left != null) que.offer(node.left);
            if (node.right != null) que.offer(node.right);
        }
        return res;
    }

    public static List<Integer> levelOrderTraversalII(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> currentLevel = new LinkedList<>();
        Queue<TreeNode> nextLevel = new LinkedList<>();
        currentLevel.offer(root);
        while (!currentLevel.isEmpty()) {
            TreeNode node = currentLevel.poll();
            res.add((Integer) node.val);
            if (node.left != null) {
                nextLevel.offer(node.left);
            }
            if (node.right != null) {
                nextLevel.offer(node.right);
            }
            if (currentLevel.isEmpty()) {
                Queue<TreeNode> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
        return res;
    }

    //recursion way: get height of the tree, then print every level from left to right;
    public static List<Integer> levelOrderTraversalIII(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        int height = getHeight(root);
        for (int i = 1; i <= height; i++) {
            printLevel(root, i, res);
        }
        return res;
    }

    private static int getHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    private static void printLevel(TreeNode<Integer> node, int level, List<Integer> res) {
        if (node == null) return;
        if (level == 1) res.add(node.val);
        else if (level > 1) {
            printLevel(node.left, level - 1, res);
            printLevel(node.right, level - 1, res);
        }
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
        System.out.println("----max height----");
        System.out.println(maxHeight(a));
        System.out.println(maxHeightI(a));
        System.out.println("----level order traversal----");
        System.out.println(leverOrderTraversal(a));
        System.out.println(levelOrderTraversalI(a));
        System.out.println(levelOrderTraversalII(a));
        System.out.println(levelOrderTraversalIII(a));

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
