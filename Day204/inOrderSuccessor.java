package Day204;

public class inOrderSuccessor {

    public static TreeNode inOrderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;
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
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        System.out.println(inOrderSuccessor(root, root).val);
    }
}
