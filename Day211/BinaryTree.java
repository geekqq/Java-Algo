package Day211;


import com.sun.source.tree.Tree;

import java.util.*;
import java.util.LinkedList;

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

    public static TreeNode revertTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return root;
        revertTree(root.left);
        revertTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
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
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (root.left != null && root.right != null) {
            return Math.min(leftDepth, rightDepth) + 1;
        } else {
            return leftDepth != 0 ? leftDepth + 1 : rightDepth + 1;
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

    public static boolean isSameTree(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) return true;
        if (r1 == null || r2 == null) return false;
        if (r1.val != r2.val) return false;
        return isSameTree(r1.left, r2.left) && isSameTree(r1.right, r2.right);
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return true;
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBST(TreeNode root, long lower, long upper) {
        if (root == null) return true;
        if (root.val <= lower || root.val >= upper) return false;

        return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
    }

    public static boolean isValidBSTI(TreeNode root) {
        return dfs(root, new Integer[1]);
    }
    private static boolean dfs(TreeNode root, Integer[] prev) {
        if (root == null) return true;
        if (!dfs(root.left, prev)) return false;
        if (prev[0] != null && prev[0] >= root.val) {
            return false;
        }
        prev[0] = root.val;
        return dfs(root.right, prev);
    }


    public static int closestValue(TreeNode root, double target) {
        // this one is not correct!!!
        if (root == null) {
            throw new IllegalArgumentException();
        }
        int closest = root.val;
        if (target < closest && root.left != null) {
            int leftClosest = closestValue(root.left, target);
            if (Math.abs(target - leftClosest) < Math.abs(target - closest)) {
                closest = leftClosest;
            }
        } else if (target > closest && root.right != null) {
            int rightClosest = closestValue(root.right, target);
            if (Math.abs(target - rightClosest) < Math.abs(target - closest)) {
                closest = rightClosest;
            }
        }
        return closest;
    }

    public static int closestValueI(TreeNode root, double target) {
        List<Integer> list = inOrder(root);
        return findClosestValue(list, target);
    }
    private static int findClosestValue(List<Integer> list, double target) {
        if (list == null) {
            throw new IllegalArgumentException();
        }
        int left = 0;
        int right = list.size() - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) == target) return list.get(mid);
            else if (list.get(mid) < target) left = mid;
            else right = mid;
        }
        return Math.abs(list.get(left) - target) <= Math.abs(list.get(right) - target) ? list.get(left) : list.get(right);
    }

    public static int closestValueII(TreeNode root, double target) {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        int min = root.val;
        TreeNode cur = root;
        while (cur != null) {
            if (Math.abs(cur.val - target) <= Math.abs(min - target)) {
                min = cur.val;
            }
            if (cur.val < target) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return min;
    }

    private static int res = Integer.MAX_VALUE;
    public static int closestValueIII(TreeNode root, double target) {
        if (root == null) throw new IllegalArgumentException();
        dfs(root, target);
        return res;
    }

    private static void dfs(TreeNode root, double target) {
        if (root == null) return;
        if (Math.abs(target - root.val) <= Math.abs(target - res)) {
            if (Math.abs(target - root.val) == Math.abs(target - res)) {
                res = Math.min(res, root.val);
            } else {
                res = root.val;
            }
        }
        if (root.val == target) return;
        if (root.val > target) {
            dfs(root.left, target);
        } else {
            dfs(root.right, target);
        }
    }

    public static TreeNode inOrderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || root.left == null && root.right == null) return null;
        TreeNode prev = null;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val > p.val) {
                prev = cur;
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return prev;
    }

    public static int minDiffInBST(TreeNode root) {
        Integer[] res = new Integer[2];
        res[1] = Integer.MAX_VALUE;
        inOrderTraversal(root, res);
        return res[1];
    }

    private static void inOrderTraversal(TreeNode root, Integer[] res) {
        if (root == null) return;
        inOrderTraversal(root.left, res);
        if (res[0] != null) {
            res[1] = Math.min(res[1], root.val - res[0]);
        }
        res[0] = root.val;
        inOrderTraversal(root.right, res);
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
        System.out.println("----level order----");
        System.out.println(levelOrder(root));
        System.out.println(levelOrderI(root));
        System.out.println("----is valid BST----");
        System.out.println(isValidBST(root));
        System.out.println(isValidBSTI(root));
        System.out.println("----revert tree----");
        System.out.println(revertTree(root).left.val);
        System.out.println("----maxDepth----");
        System.out.println(maxDepth(root));
        System.out.println(maxDepthI(root));
        System.out.println("----minDepth----");
        System.out.println(minDepth(root));
        System.out.println("----is balanced BT----");
        System.out.println(isBalanced(root));
        System.out.println("----is symmetric tree----");
        System.out.println(isSymmetric(root));
        System.out.println("----closest value----");
        root = revertTree(root);
        System.out.println(closestValue(root, 3.5)); // this one is not correct!
        System.out.println(closestValueI(root, 3.5));
        System.out.println(closestValueII(root, 3.5));
        System.out.println(closestValueIII(root, 3.5));
        System.out.println("----print a tree in order----");
        System.out.println(inOrder(root));
        System.out.println("----in order successor----");
        System.out.println(inOrderSuccessor(root, root.left).val);
        System.out.println("----min distance in BST----");
        System.out.println(minDiffInBST(root));

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
