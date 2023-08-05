package Day265;

public class BinarySearchTree {

    private Day266.TreeNode root;

    public void insertNode(int val) {
        root = insertNode(root, val);
    }

    public Day266.TreeNode insertNode(Day266.TreeNode root, int val) {
        if (root == null) {
            Day266.TreeNode temp = new Day266.TreeNode(val);
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


    public void inOrder(Day266.TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public boolean search(Day266.TreeNode root, int key) {
        if (root == null) return false;
        if (key < root.data) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public Day266.TreeNode searchNode(Day266.TreeNode root, int key) {
        if (root == null || root.data == key) return root;
        if (key < root.data) {
            return searchNode(root.left, key);
        } else {
            return searchNode(root.right, key);
        }
    }

    public boolean isValidBST(Day266.TreeNode root, long min, long max) {

        if (root == null) return true; //base case
        if (root.data <= min || root.data >= max) return false;
        boolean left = isValidBST(root.left, min, root.data);
        if (left) {
            boolean right = isValidBST(root.right, root.data, max);
            return right;
        }
        return false;
    }

    public boolean isValidI(Day266.TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.data <= min || root.data >= max) return false;
        return isValidBST(root.left, min, root.data) && isValidBST(root.right, root.data, max);
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
        System.out.println();
        System.out.println(bst.search(bst.root, 8));
        System.out.println(bst.searchNode(bst.root, 2));
        System.out.println(bst.isValidBST(bst.root, Long.MIN_VALUE, Long.MAX_VALUE));
        System.out.println(bst.isValidI(bst.root, Long.MIN_VALUE, Long.MAX_VALUE));
    }

}

class TreeNode {
    int data;
    Day266.TreeNode left;
    Day266.TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
