package Day195;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstValues {

    public static void main(String[] args) {
        var a = new Node('a');
        var b = new Node('b');
        var c = new Node('c');
        var d = new Node('d');
        var e = new Node('e');
        var f = new Node('f');
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        System.out.println(depthFirstValues(a));
        System.out.println(depthFirstII(a));
    }
    public static List<Character> depthFirstValues(Node root) {
        if (root == null) return null;
        List<Character> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node n = stack.pop();
            res.add(n.val);
            if (n.right != null) {
                stack.push(n.right);
            }
            if (n.left != null) {
                stack.push(n.left);
            }
        }
        return res;
    }

    public static List<Character> depthFirstII(Node root) {
        List<Character> res = new ArrayList<>();
        if (root == null) return res;
        List left = depthFirstII(root.left);
        List right = depthFirstII(root.right);
        res.add(root.val);
        res.addAll(left);
        res.addAll(right);
        return res;
    }
}

class Node {
    char val;
    Node left;
    Node right;
    public Node(char val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
