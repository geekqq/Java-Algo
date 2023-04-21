package Day216;

import java.util.*;

public class BianryTree {

    public static List<List<Integer>> levelOrderByLevel(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            res.add(level);
        }
        return res;
    }

    public static List<List<Integer>> levelOrderButtom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            res.addFirst(level);
        }
        return res;
    }


    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> indexQueue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int min = 0;
        int max = 0;

        nodeQueue.offer(root);
        indexQueue.offer(0);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int col = indexQueue.poll();

            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(node.val);
            if (node.left != null) {
                nodeQueue.offer(node.left);
                indexQueue.offer(col - 1);
                min = Math.min(min, col - 1);
            }
            if (node.right != null) {
                nodeQueue.offer(node.right);
                indexQueue.offer(col + 1);
                max = Math.max(max, col + 1);
            }
        }
        for (int i = min; i < max; i++) {
            res.add(map.get(i));
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        System.out.println("----level order by level----");
        System.out.println(levelOrderByLevel(root));
        System.out.println("----level order from bottom----");
        System.out.println(levelOrderButtom(root));
        System.out.println("----vertical traversal----");
        System.out.println(verticalOrder(root));
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode() {};
    public TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}