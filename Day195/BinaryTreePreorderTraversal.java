package Day195;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        preorderTraversal(root, res);
        return res;
    }
    //helper
    private void preorderTraversal(TreeNode root, LinkedList<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorderTraversal(root.left, res);
        preorderTraversal(root.right, res);
    }
}

class TreeNode {
    TreeNode root;
     TreeNode left;
     TreeNode right;
     int val;

    public TreeNode() {
        root = null;
        left = null;
        right = null;
        val = 0;
    }

    public TreeNode(TreeNode root, TreeNode left, TreeNode right, int val) {
        this.root = root;
        this.left = left;
        this.right = right;
        this.val = val;
    }
}
