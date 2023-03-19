package Day196;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstValues {
    public static List<Character> depthFirst(TreeNode root) {
        List<Character> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return res;
    }

    public static List<Character> depthFirstII(TreeNode root) {
        List<Character> res = new ArrayList<>();
        if (root == null) return null;
        List left = depthFirstII(root.left);
        List right = depthFirstII(root.right);
        res.add(root.val);
        res.addAll(left);
        res.addAll(right);
        return res;
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    char val;

    public TreeNode(char val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
