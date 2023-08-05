package Day265;

public class BinarySearchTree {

    private TreeNode root;

    public void insertNode(int val) {
        root = insertNode(root, val);
    }

    public TreeNode insertNode(TreeNode root, int val) {
        if (root == null) {
            TreeNode temp = new TreeNode(val);
            root = temp;
            return root;
        }
        if (val < root.data) {
            root.left = insertNode(root.left, val);
        } else {
            root.right = insertNode(root.right, val);
        }
        return root;
    }


    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insertNode(5);
        bst.insertNode(3);
        bst.insertNode(7);
        bst.insertNode(1);
        bst.insertNode(2);
        bst.insertNode(0);

        bst.inOrder(bst.root);
    }

}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
