package Day213;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderNRayTree {
    public static List<Integer> levelOrderNRayTree(NRayTree root) {
        List<Integer> res = new ArrayList<>();
        if (res == null) return res;
        Queue<NRayTree> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                NRayTree node = q.poll();
                res.add(node.val);
                for (NRayTree child : node.children) {
                    if (child != null) q.offer(child);
                }
            }
        }
        return res;
    }
}
