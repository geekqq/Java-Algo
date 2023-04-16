package Day213;

public class InorderSuccessor {
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
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


    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        System.out.println(inorderSuccessor(root, root.right).val);
    }
}
