package Day212;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostOrderNRayTree {

    public static List<Integer> postOrderNRayTree(NRayTree root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<NRayTree> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            NRayTree node = stack.pop();
            res.addFirst(node.val);
            for (NRayTree child : node.children) {
                stack.push(child);
            }
        }
        return res;
    }
}
