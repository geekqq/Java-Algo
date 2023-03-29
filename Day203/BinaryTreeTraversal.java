package Day203;

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

    public static int minDepthII(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = minDepthII(root.left);
        int rightDepth = minDepthII(root.right);
        if (leftDepth == 0) return rightDepth + 1;
        if (rightDepth == 0) return leftDepth + 1;
        return Math.min(leftDepth, rightDepth) + 1;
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private static int getHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) return true;
        if (leftNode == null || rightNode == null) return false;
        if (leftNode.val != rightNode.val) return false;
        return isSymmetric(leftNode.left, rightNode.right) && isSymmetric(leftNode.right, rightNode.left);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }


    public static TreeNode invertTreeI(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return root;
        invertTreeI(root.left);
        invertTreeI(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    public static TreeNode invertTreeII(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return root;
        TreeNode leftNode = invertTreeII(root.left);
        TreeNode rightNode = invertTreeII(root.right);
        root.left = rightNode;
        root.right = leftNode;
        return root;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;

        TreeNode[] pre = new TreeNode[1];
        boolean[] res = new boolean[]{true};

        inOrder(pre, root, res);

        return res[0];
    }

    private static void inOrder(TreeNode[] pre, TreeNode root, boolean[] res) {
        if (root == null) return;
        inOrder(pre, root.left, res);

        if (pre[0] == null) {
            pre[0] = root;
        } else {
            if (pre[0].val >= root.val) {
                res[0] = false;
            } else {
                pre[0] = root;
            }
        }

        inOrder(pre, root.right, res);
    }

    public static boolean isValidBSTI(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValid(TreeNode root, long lower, long upper) {
        if (root == null) return true;
        if (root.val <= lower || root.val >= upper) return false;
        return isValid(root.left, lower, root.val) && isValid(root.right, root.val, upper);
    }

    public boolean isValidBSTII(TreeNode root) {
        return dfs(root);
    }


    private TreeNode prev = null;
    private boolean dfs(TreeNode cur) {
        if (cur == null) {
            return true;
        }
        if (!dfs(cur)) {
            return false;
        }
        if (prev != null && prev.val >= cur.val) {
            return false;
        }
        prev = cur;
        return dfs(cur.right);
    }

    public static boolean isValidBSTIII(TreeNode root) {
        return dfs(root, new Integer[1]);
    }

    private static boolean dfs(TreeNode root, Integer[] prev) {
        if (root == null) return true;
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
        System.out.println(minDepthII(a));
        System.out.println("----is balanced----");
        System.out.println(isBalanced(a));
        System.out.println("----is symmetric tree");
        System.out.println(isSymmetric(a));
        System.out.println("----invert tree----");
        System.out.println(invertTree(a).left.val);
        System.out.println(invertTreeII(a).right.val);
        System.out.println(invertTreeI(a).right.val);
        System.out.println("----is same tree----");
        System.out.println(isSameTree(a, a));
        System.out.println("----valid BST----");
        TreeNode x = new TreeNode(4);
        x.left = new TreeNode(3);
        x.left.left = new TreeNode(1);
        x.right = new TreeNode(5);
        x.right.right = new TreeNode(6);
        System.out.println(isValidBST(x));
        System.out.println(isValidBSTI(x));
        System.out.println(isValidBSTI(x));
        System.out.println(inorder(x));
        System.out.println(isValidBSTIII(x));
        System.out.println("----");
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
