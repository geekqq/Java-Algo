package Day285;

import Day266.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class FindMedianInBST {

    public static int findMedianBST(TreeNode root) {
        List<Integer> list = inOrder(root);
        int count = countNode(root);
        if (count % 2 == 0) {
            return (list.get(count / 2 - 1) + list.get(count / 2)) / 2;
        } else {
            return list.get(count / 2);
        }
    }

    private static List<Integer> inOrder(TreeNode root) {
        if (root == null) return null;
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.data);
                cur = cur.right;
            }
        }
        return list;
    }

    private static int countNode(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNode(root.left) + countNode(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        System.out.println(countNode(root));
        System.out.println(inOrder(root));
    }


}
