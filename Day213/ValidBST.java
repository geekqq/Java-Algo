package Day213;

public class ValidBST {

    public static boolean validBST(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return true;

        return isValidBST(root.left, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private static boolean isValidBST(TreeNode root, long lower, long upper) {
        if(root == null) return true;
        if (root.val <= lower || root.val >= upper) return false;
        return isValidBST(root.left, lower, root.val) && isValidBST(root.right, upper, root.val);
    }

    public static boolean validBSTI(TreeNode root) {
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


    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        System.out.println(validBST(root));
        System.out.println(validBSTI(root));
    }
}
