package Day213;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NRayTreePreorder {
    public static List<Integer> preorder(NRayTree root) {
        List<Integer> res = new LinkedList<>();
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
