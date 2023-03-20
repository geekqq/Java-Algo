package Day196;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

    public static List<Character> inorderTraversal(TreeNode root) {
        List<Character> res = new ArrayList<>();
        if (root == null) return res;
        inOrder(root, res);
        return res;
    }

    private static void inOrder(TreeNode root, List<Character> res) {
        if (root == null) return;

        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }

    private static void inOrderII(TreeNode root, List<Character> res) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null && !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.peek();
                res.add(cur.val);
                cur = cur.right;
            }
        }
    }
}
