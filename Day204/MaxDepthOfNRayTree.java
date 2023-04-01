package Day204;

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

}

class NTreeNode {
    public int val;
    public List<NTreeNode> children;

    public NTreeNode(int val) {
        this.val = val;
    }

    public NTreeNode(int val, List<NTreeNode> children) {
        this.val = val;
        this.children = children;
    }
}