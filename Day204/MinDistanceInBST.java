package Day204;

public class MinDistanceInBST {

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

    static int res = Integer.MAX_VALUE;
    static TreeNode prev = null;
    public static int minDiffInBSTI(TreeNode root) {
        inOrderTraverse(root);
        return res;
    }

    private static void inOrderTraverse(TreeNode root) {
        if (root == null) return;
        inOrderTraverse(root.left);
        if (prev != null) {
            if (root.val - prev.val < res) {
                res = root.val - prev.val;
            }
        }
        prev = root;
        inOrderTraverse(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(12);
        System.out.println(minDiffInBST(root));
        System.out.println(minDiffInBSTI(root));
    }
}
