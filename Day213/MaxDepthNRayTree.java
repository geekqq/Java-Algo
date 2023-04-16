package Day213;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthNRayTree {

    public static int maxDepthNRayTree(NRayTree root) {
        if (root == null) return 0;
        Queue<NRayTree> q = new LinkedList<>();
        q.offer(root);
        int depth = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                NRayTree node = q.poll();
                for (NRayTree child : node.children) {
                    if (child != null) q.offer(child);
                }
            }
            depth++;
        }
        return depth;
    }

    public static int maxDepth(NRayTree root) {
        if (root == null) return 0;
        int max = 0;
        for (NRayTree node : root.children) {
            max = Math.max(max, maxDepth(node));
        }
        return max + 1;
    }
}
