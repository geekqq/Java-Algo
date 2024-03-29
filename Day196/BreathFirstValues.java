package Day196;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreathFirstValues {
    public static List<Character> breathFirst(TreeNode root) {
        List<Character> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            res.add(node.val);
            if (node.left != null) que.offer(node.left);
            if (node.right != null) que.offer(node.right);
        }
        return res;
    }

    public static boolean breathFirstFindTarget(TreeNode root, char x) {
        if (root == null) return false;
        Queue<TreeNode> que = new LinkedList();
        que.offer(root);
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            if (node.val == x) return true;
            if (node.left != null) que.offer(node.left);
            if (node.right != null) que.offer(node.right);
        }
        return false;
    }

    public static boolean breathFirstFindTargetII(TreeNode root, char x) {
        if (root == null) return false;
        if (root.val == x) return true;
        return breathFirstFindTargetII(root.left, x) || breathFirstFindTargetII(root.right, x);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode('a');
        TreeNode b = new TreeNode('b');
        TreeNode c = new TreeNode('c');
        TreeNode d = new TreeNode('d');
        TreeNode e = new TreeNode('e');
        TreeNode f = new TreeNode('f');
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        System.out.println(breathFirst(a));
        char target = a.val;
        System.out.println(breathFirstFindTargetII(a, target));
    }
}


