package Day212;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderNRayNode {
    public static List<Integer> preOrderNRayTree(NRayTree root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<NRayTree> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            NRayTree node = stack.pop();
            res.add(node.val);
            int size = node.children.size();
            for (int i = size - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
        }
        return res;
    }
}
