package Day203;

import OODAdv.A;

import java.util.*;

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

    public static List<Integer> inorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        List left = inorder(root.left);
        List right = inorder(root.right);
        res.addAll(left);
        res.add((Integer) root.val);
        res.addAll(right);
        return res;
    }

    public static List<Integer> inorderI(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        inorderI(root, res);
        return res;
    }

    private static void inorderI(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorderI(root.left, res);
        res.add((Integer) root.val);
        inorderI(root.right, res);
    }

    public static List<Integer> inorderII(TreeNode root) {
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

    public static List<Integer> postorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        List left = postorder(root.left);
        List right = postorder(root.right);

        res.addAll(left);
        res.addAll(right);
        res.add((Integer) root.val);
        return res;
    }

    public static List<Integer> postorderI(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        postorderI(root, res);
        return res;
    }

    private static void postorderI(TreeNode root, List<Integer> res) {
        if (root == null) return;
        postorderI(root.left, res);
        postorderI(root.right, res);
        res.add((Integer) root.val);
    }

    private static List<Integer> postorderII(TreeNode root) {
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

    public static List<Integer> levelOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            res.add((Integer) node.val);
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
                res.add((Integer) node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
        return res;
    }

    public static int maxHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxHeight(root.left), maxHeight(root.right)) + 1;
    }

    public static int maxHeightI(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        int height = 0;
        q.offer(root);
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

    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null && root.right != null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        } else {
            return root.left != null ? minDepth(root.left) + 1 : minDepth(root.right) + 1;
        }
    }

    public static int minDepthI(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode node = q.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            depth++;
        }
        return 0;
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
        System.out.println("----in order----");
        System.out.println(inorder(a));
        System.out.println(inorderI(a));
        System.out.println(inorderII(a));
        System.out.println("----post order----");
        System.out.println(postorder(a));
        System.out.println(postorderI(a));
        System.out.println(postorderII(a));
        System.out.println("----level order----");
        System.out.println(levelOrder(a));
        System.out.println(levelOrderI(a));
        System.out.println("---max height of tree");
        System.out.println(maxHeight(a));
        System.out.println(maxHeightI(a));
        System.out.println("---min depth----");
        System.out.println(minDepth(a));
        System.out.println(minDepthI(a));
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
