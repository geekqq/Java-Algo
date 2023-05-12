package Day196;

import java.util.LinkedList;
import java.util.Queue;

public class TreeSum {
    public static int getTreeSum(TreeNode root) {
        if (root == null) return 0;
        return root.val + getTreeSum(root.left) + getTreeSum(root.right);
    }

    public static int getTreeSumI(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int sum = 0;
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            sum += node.val;
            if (root.left != null) que.offer(root.left);
            if (root.right != null) que.offer(root.right);
        }
        return sum;
    }

}
