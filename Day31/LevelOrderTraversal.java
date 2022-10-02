package Day31;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    public class TreeNode {
        TreeNode value;
        TreeNode left;
        TreeNode right;
    }

    public static void levelOrderTraversal(TreeNode root) {
        if (root == null ) {
            return;
        }

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode pollNode = que.poll();
                System.out.println(pollNode.value);

                if (pollNode.left != null) {
                    que.offer(pollNode.left);
                }

                if (pollNode.right != null) {
                    que.offer(pollNode.right);
                }
            }
            System.out.println(); //打印换行 分层
        }
    }
}
