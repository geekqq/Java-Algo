package Day207;

import com.sun.source.tree.Tree;

import java.util.*;

public class BinaryTreeTraversal {

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
        preOrderI(root.left, res);
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
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return res;
    }

    public static List<Integer> preOrderIII(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
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

    public static List<Integer> inOrderI(TreeNode root) {
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
        List <Integer> res = new ArrayList<>();
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

    public static int getTotalNodes(TreeNode root) {
        if (root == null) return 0;
        int left = getTotalNodes(root.left);
        int right = getTotalNodes(root.right);
        return left + right + 1;
    }

    public static int getTotalNodesI(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int total = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                    total++;
                }
                if (node.right != null) {
                    q.offer(node.right);
                    total++;
                }
            }
        }
        return total;
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
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static int maxDepthI(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 0;
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
        if (root.left == null && root.right == null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        } else {
            return root.left != null ? (minDepth(root.left) + 1) : (minDepth(root.right) + 1);
        }
    }

    public static int minDepthI(TreeNode root) {
        if (root == null) return 0;
        int leftMinDepth = minDepthI(root.left);
        int rightMinDepth = minDepthI(root.right);
        if (root.left != null && root.right != null) {
            return Math.min(leftMinDepth, rightMinDepth) + 1;
        } else {
            return root.left != null ? minDepthI(root.left) + 1 : minDepthI(root.right) + 1;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private static int getDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        return isSymmetric(root.left, root.right);
    }
    private static boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return root;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    public static TreeNode invertTreeI(TreeNode root) {
        if (root == null) return null;
        dfs(root);
        return root;
    }

    private static void dfs(TreeNode root) {
        if (root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        dfs(root.left);
        dfs(root.right);

    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValid(TreeNode root, long lower, long upper) {
        if (root == null) return true;
        if (root.val <= lower || root.val >= upper) return false;
        return isValid(root.left, lower, root.val) && isValid(root.right, root.val, upper);
    }

    public static boolean isValidBSTI(TreeNode root) {
        // inOrder Traversal increasing order
        return dfs(root, new Integer[1]);
    }

    private static boolean dfs(TreeNode root, Integer[] prev) {
        if (root == null) {
            return true;
        }
        if (!dfs(root.left, prev)) {
            return false;
        }
        if (prev[0] != null && prev[0] >= root.val) {
            return false;
        }
        prev[0] = root.val;
        return dfs(root.right, prev);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        System.out.println("----pre order----");
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
        System.out.println("----total nodes----");
        System.out.println(getTotalNodes(root));
        System.out.println(getTotalNodesI(root));
        System.out.println("----level order----");
        System.out.println(levelOrder(root));
        System.out.println(levelOrderI(root));
        System.out.println("----maxDepth----");
        System.out.println(maxDepth(root));
        System.out.println(maxDepthI(root));
        System.out.println("----minDepth");
        System.out.println(minDepth(root));
        System.out.println("----is balanced BT----");
        System.out.println(isBalanced(root));
        System.out.println("----is symmetric----");
        System.out.println(isSymmetric(root));
        System.out.println("----is valid BST----");
        System.out.println(isValidBST(root));
        System.out.println(isValidBSTI(root));
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