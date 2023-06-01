package Day234;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class JumpGameII {
    public static int jump(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 0;

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(0);
        visited.add(0);

        int level = 0;
        int maxPos = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int curPos = queue.poll();
                if (curPos >= nums.length - 1) return level;
                int range = curPos + nums[curPos];
                for (int i = 1; i <= nums[curPos]; i++) {
                    if (visited.add(curPos + i)) {
                        queue.offer(curPos + i);
                        maxPos = Math.max(maxPos, curPos + i);
                    }
                }
            }
            level++;
        }
        if (maxPos < nums.length - 1) return -1;
        return level;
    }
}
