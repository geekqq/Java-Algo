package Day213;

public class MinDistanceInBST {
    public static int minDistance(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return 0;
        Integer[] res = new Integer[2];
        res[1] = Integer.MAX_VALUE;
        inorderTraverse(root, res);
        return res[1];
    }
    private static void inorderTraverse(TreeNode root, Integer[] res) {
        if (root == null) return;
        inorderTraverse(root.left, res);
        if (res[0] != null) {
            res[1] = Math.min(res[1], root.val - res[0]);
        }
        res[0] = root.val;
        inorderTraverse(root.right, res);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        System.out.println(minDistance(root));
    }
}
