package Day212;

import com.sun.source.tree.Tree;

import java.util.*;

public class BinaryTree {

    public static List<Integer> preOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        List left = preOrder(root.left);
        List right = preOrder(root.right);
        res.add(root.val);
        res.addAll(left);
        res.addAll(right);
        return res;
    }

    public static List<Integer> preOrderI(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        preOrderI(root, res);
        return res;
    }

    private static void preOrderI(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        preOrderI(root.left,res);
        preOrderI(root.right, res);
    }

    public static List<Integer> preOrderII(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
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

    public static List<Integer> inOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        List left = inOrder(root.left);
        List right = inOrder(root.right);
        res.addAll(left);
        res.add(root.val);
        res.addAll(right);
        return res;
    }

    public static List<Integer>inOrderI(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        inOrderI(root, res);
        return res;
    }

    private static void inOrderI(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inOrderI(root.left, res);
        res.add(root.val);
        inOrderI(root.right, res);
    }
    public static List<Integer> inOrderII(TreeNode root) {
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
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        List left = postOrder(root.left);
        List right = postOrder(root.right);
        res.addAll(left);
        res.addAll(right);
        res.add(root.val);
        return res;
    }

    public static List<Integer> postOrderI(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        postOrderI(root, res);
        return res;
    }

    private static void postOrderI(TreeNode root, List<Integer> res) {
        if (root == null) return;
        postOrderI(root.left, res);
        postOrderI(root.right, res);
        res.add(root.val);
    }

    public static List<Integer> postOrderII(TreeNode root) {
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

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static int maxDepthI(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        int depth = 0;
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode node = q.poll();
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            depth++;
        }
        return depth;
    }

    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        int lefDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (root.left != null && root.right != null) {
            return Math.min(lefDepth, rightDepth) + 1;
        } else {
            return root.left != null ? lefDepth + 1 : rightDepth + 1;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        return isSymmetric(root.left, root.right);
    }
    private static boolean isSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) return true;
        if (leftNode == null || rightNode == null) return false;
        if (leftNode.val != rightNode.val) return false;
        return isSymmetric(leftNode.left, rightNode.right) && isSymmetric(leftNode.right, rightNode.left);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return root;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    public static boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root1.val) return false;
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }

    public static boolean validBST(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return true;
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private static boolean isValid(TreeNode root, long lower, long upper) {
        if (root == null) return true;
        if (root.val <= lower || root.val >= upper) {
            return false;
        }
        return isValid(root.left, lower, root.val) && isValid(root.right, root.val, upper);
    }

    public static boolean validBSTI(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return true;
        TreeNode[] pre = new TreeNode[1];
        boolean[] res = new boolean[]{true};
        inOrderBST(pre, root, res);
        return res[0];
    }

    private static void inOrderBST(TreeNode[] pre, TreeNode root, boolean[] res) {
        if (root == null) return;
        inOrderBST(pre, root.left, res);
        if (pre[0] == null) {
            pre[0] = root;
        } else {
            if (pre[0].val >= root.val) {
                res[0] = false;
            } else {
                pre[0] = root;
            }
        }
        inOrderBST(pre, root.right, res);
    }

    public static boolean validBSTII(TreeNode root) {
        return dfs(root, new Integer[1]);
    }

    private static boolean dfs(TreeNode root, Integer[] prev) {
        if (root == null) return true;
        if (!dfs(root.left, prev)) return false;
        if (prev[0] != null && prev[0] > root.val) {
            return false;
        }
        prev[0] = root.val;
        return dfs(root.right, prev);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        System.out.println("---pre order----");
        System.out.println(preOrder(root));
        System.out.println(preOrderI(root));
        System.out.println(preOrderII(root));
        System.out.println(preOrderIII(root));
        System.out.println("----in order----");
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
        System.out.println("----max depth----");
        System.out.println(maxDepth(root));
        System.out.println(maxDepthI(root));
        System.out.println("----is balanced BT----");
        System.out.println(isBalanced(root));
        System.out.println("----symmetric tree----");
        System.out.println(isSymmetric(root));
        System.out.println("----is valid BST");
        System.out.println(validBST(root));
        System.out.println(validBSTI(root));
        System.out.println(validBSTII(root));
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
