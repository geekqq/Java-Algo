package Day273;


import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalByLevel {

    TreeNode root;

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    public static void levelOrderByLevel(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode node = q.poll();
                System.out.print(node.data + " ");
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            System.out.println();
        }
    }

    public static boolean validBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.data >= max || root.data <= min) return false;
        return validBST(root.left, min, root.data) && validBST(root.right, root.data, max);
    }


    public static boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.data <= min || root.data >= max) return false;
        boolean left = isValidBST(root.left, min, root.data);
        if (left) {
            boolean right = isValidBST(root.right, root.data, max);
            return right;
        }
        return false;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        System.out.println(validBST(root, Long.MIN_VALUE, Long.MAX_VALUE));
        System.out.println(isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE));
        levelOrderByLevel(root);
    }
}
