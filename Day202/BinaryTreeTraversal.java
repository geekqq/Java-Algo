package Day202;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTraversal {

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        List left = preorderTraversal(root.left);
        List right = preorderTraversal(root.right);
        res.add((Integer) root.val);
        res.addAll(left);
        res.addAll(right);
        return res;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(6);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(3);
        TreeNode f = new TreeNode(5);
        TreeNode g = new TreeNode(7);
        a.left = b;
        b.left = d;
        b.right = e;
        a.right = c;
        c.left = f;
        c.right = g;
        System.out.println("----preorder----");
        System.out.println(preorderTraversal(a));
    }
}

class TreeNode<E> {
    E val;
    TreeNode left;
    TreeNode right;

    public TreeNode(E val) {
        this.val = val;
        left = null;
        right = null;
    }
}