package Day204;


import java.util.LinkedList;
import java.util.Queue;

public class CountCompleteTreeNode {

    public static int countNode(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                    count++;
                }
                if (node.right != null) {
                    q.offer(node.right);
                    count++;
                }
            }
        }
        return count;
    }

    public static int countNodeI(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        final int leftHeight = getLeftMostHeight(root.left);
        final int rightHeight = getLeftMostHeight(root.right);
        if (leftHeight > rightHeight) {
            return countNodeI(root.left) + (int)Math.pow(2, rightHeight);
        } else if (leftHeight == rightHeight) {
            return countNodeI(root.right) + (int)Math.pow(2, leftHeight);
        } else {
            return 0;
        }
    }

    private static int getLeftMostHeight(TreeNode root) {
        int res = 0;
        while (root != null) {
            root = root.left;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        System.out.println(countNode(root));
        System.out.println(countNodeI(root));
        System.out.println("----root only node----");
        TreeNode root1 = new TreeNode(1);
        System.out.println(countNode(root1));
        System.out.println(countNodeI(root1));
    }

}
