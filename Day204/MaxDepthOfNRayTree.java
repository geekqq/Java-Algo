package Day204;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//LC559
public class MaxDepthOfNRayTree {

    public static int maxDepth(NTreeNode root) {
        if (root == null) return 0;

        int max = 0;
        for (NTreeNode n : root.children) {
            max = Math.max(max, maxDepth(n));
        }
        return max + 1;
    }

    public static int maxDepthI(NTreeNode root) {
        if (root == null) return 0;
        Queue<NTreeNode> q = new LinkedList<>();
        q.offer(root);
        int maxDepth = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                NTreeNode node = q.poll();
                for (NTreeNode n : node.children) {
                    q.offer(n);
                }
            }
            maxDepth++;
        }
        return maxDepth;
    }

    public static List<List<Integer>> levelOrder(NTreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<NTreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            int size = q.size();
            while (size-- > 0) {
                NTreeNode node = q.poll();
                level.add(node.val);
                for (NTreeNode child : node.children) {
                    q.offer(child);
                }
            }
            res.add(level);
        }
        return res;
    }

    public static void main(String[] args) {
        NTreeNode root = new NTreeNode(1);
        root.children.add(new NTreeNode(3));
        root.children.add(new NTreeNode(2));
        root.children.add(new NTreeNode(4));
        root.children.get(0).children.add(new NTreeNode(5));
        root.children.get(0).children.add(new NTreeNode(6));
        System.out.println(maxDepth(root));
        System.out.println(levelOrder(root));
    }

}

class NTreeNode {
    public int val;
    public List<NTreeNode> children;

    public NTreeNode(int val) {
        this.val = val;
        this.children = new LinkedList<NTreeNode>();
    }

}