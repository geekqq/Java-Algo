package Day213;

import com.sun.jdi.Value;
import com.sun.source.tree.Tree;

import java.security.Key;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {

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
        if (root == null) {
            return 0;
        }
        int leftMinDepth = minDepth(root.left);
        int rightMinDepth = minDepth(root.right);
        if (root.left != null && root.right != null) {
            return Math.min(leftMinDepth, rightMinDepth) + 1;
        } else {
            return root.left != null ? leftMinDepth + 1 : rightMinDepth + 1;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return true;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
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

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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

    public static boolean isValidBST(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return true;
        return validBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private static boolean validBST(TreeNode root, long lower, long upper) {
        if (root == null) return true;
        if (root.val <= lower || root.val >= upper) {
            return false;
        }

        return validBST(root.left, lower, root.val) && validBST(root.right, root.val, upper);
     }

     public static boolean isValidBSTI(TreeNode root) {
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

     public static int maxWidth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> indexQueue = new LinkedList<>();

        nodeQueue.offer(root);
        indexQueue.offer(0);

        int max = 0;

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            int left = 0;
            int right = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = nodeQueue.poll();
                int index = indexQueue.poll();

                if (i == 0) left = index;
                if (i == size - 1) right = index;

                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    indexQueue.offer(index * 2);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    indexQueue.offer(index * 2 + 1);
                }
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
     }

     public static int maxWidthI(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int max = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            max = Math.max(max, size);
            while (size-- > 0) {
                TreeNode node = q.poll();
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
        return max;
     }

     public static int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);
        return leftNodes + rightNodes + 1;
     }

     public static int countNodesI(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        int count = 0;
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            count++;
            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }
        return count;
     }

     public static int countNodesII(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int leftHeight = getLeftMostHeight(root.left);
        int rightHeight = getLeftMostHeight(root.right);
        if (leftHeight > rightHeight) {
            return countNodesII(root.left) + (int)Math.pow(2, rightHeight);
        } else if (leftHeight == rightHeight) {
            return countNodesII(root.left) + (int)Math.pow(2,leftHeight);
        } else {
            return 0;
        }
     }
     private static int getLeftMostHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            root = root.left;
            height++;
        }
        return height;
     }
     public static List<List<Integer>> levelOrderByLevel(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            res.add(level);
        }
        return res;
     }
     public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        System.out.println(maxDepth(root));
        System.out.println(maxDepthI(root));
        System.out.println("----min depth----");
        System.out.println(minDepth(root));
        System.out.println("----max width----");
        System.out.println(maxWidth(root));
        System.out.println(maxWidthI(root));

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.left.left = new TreeNode(5);
        root1.left.left.left = new TreeNode(6);
        root1.right = new TreeNode(2);
        root1.right.right = new TreeNode(9);
        root1.right.right.left = new TreeNode(7);
        System.out.println(maxWidth(root1));
        System.out.println(maxWidthI(root1));
        System.out.println("----count nodes----");
        System.out.println(countNodes(root));
        System.out.println(countNodesI(root));
        System.out.println(countNodesII(root));
        System.out.println("----level order by level");
        System.out.println(levelOrderByLevel(root));
        System.out.println(levelOrderByLevel(root1));
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
