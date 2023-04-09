package Day208;

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
        List<Integer> res= new ArrayList<>();
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
        Stack<TreeNode> stack= new Stack<>();
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
        List<Integer> res =  new ArrayList<>();
        if (root == null) return res;
        inOrder(root, res);
        return res;
    }

    private static void inOrder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
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
        LinkedList res = new LinkedList();
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
        if (res == null) return res;
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
        int leftMinDepth = minDepth(root.left);
        int rightMinDepth = minDepth(root.right);
        if (root.left != null && root.right != null) {
            return Math.min(leftMinDepth, rightMinDepth) + 1;
        } else {
            return root.left != null ? leftMinDepth + 1 : rightMinDepth + 1;
        }
    }

    public static int minDepthI(TreeNode root) {
        if (root == null) return 0;
        return dfs(root);
    }

    private static int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        if (leftDepth == 0 && rightDepth == 0) {
            return 1;
        } else if (leftDepth == 0) {
            return rightDepth + 1;
        } else if (rightDepth == 0) {
            return leftDepth + 1;
        } else {
            return Math.min(leftDepth, rightDepth) + 1;
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
    private static boolean isSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) return true;
        if (leftNode == null || rightNode == null) return false;
        if (leftNode.val != rightNode.val) {
            return false;
        }
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
        if (root.val <= lower || root.val >= upper) {
            return false;
        }
        return isValid(root.left, lower, root.val) && isValid(root.right, root.val, upper);
     }

     public static boolean isValidBSTI(TreeNode root) {
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

    public static int closestValue(TreeNode root, double target) {
        if (root == null) throw new IllegalArgumentException();
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

    static int res = Integer.MAX_VALUE;
    public static int closestValueI(TreeNode root, double target) {
        if (root == null) throw new IllegalArgumentException();
        dfs(root, target);
        return res;
    }

    private static void dfs(TreeNode root, double target) {
        if (root == null) return;
        if (Math.abs(root.val - target) <= Math.abs(target - res)) {
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

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;
        TreeNode pre = null;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val > p.val) {
                pre = cur;
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return pre;
    }

    public static int minDiffINBST(TreeNode root) {
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

    static Integer minValue = Integer.MAX_VALUE;
    static TreeNode prev = null;
    public static int minDiffInBSTI(TreeNode root) {
        if (root == null) throw new IllegalArgumentException();
        inOrderTraversalI(root);
        return minValue;
    }

    private static void inOrderTraversalI(TreeNode root) {
        if (root == null) return;
        inOrderTraversalI(root.left);
        if (prev != null) {
            if (root.val - prev.val < minValue) {
                minValue = root.val - prev.val;
            }
        }
        prev = root;
        inOrderTraversalI(root.right);
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
        System.out.println("----max depth----");
        System.out.println(maxDepth(root));
        System.out.println(maxDepthI(root));
        System.out.println("----min depth----");
        TreeNode root1 = new TreeNode(1);
        //root1.left = new TreeNode(5);
        root1.right = new TreeNode(2);
        root1.right.right = new TreeNode(3);
        root1.right.right.right = new TreeNode(4);
        System.out.println(minDepth(root1));
        System.out.println(minDepthI(root1));
        System.out.println("----is balanced tree----");
        System.out.println(isBalanced(root));
        System.out.println(isBalanced(root1));
        System.out.println("----is valid BST");
        System.out.println(isValidBST(root));
        System.out.println(isValidBSTI(root));
        System.out.println("----is symmetric----");
        System.out.println(isSymmetric(root));
        System.out.println(isSymmetric(root1));
        System.out.println("----invert binary tree----");
        TreeNode invertRoot = invertTree(root);
        System.out.println(invertRoot.left.val);
        System.out.println(invertRoot.left.left.val);
        System.out.println(invertRoot.right.val);
        System.out.println(invertRoot.right.right.val);
        System.out.println("----closest value----");
        System.out.println(closestValue(root, 2.3453));
        System.out.println(closestValueI(root, 2.3453));
        System.out.println("----min distance btw BST nodes----");
        System.out.println(minDiffINBST(root1));
        System.out.println(minDiffInBSTI(root1));
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