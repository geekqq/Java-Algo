package Day213;

import java.util.LinkedList;
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
