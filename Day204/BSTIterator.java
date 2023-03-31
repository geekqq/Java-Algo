package Day204;


import java.util.Stack;

public class BSTIterator {

    Stack<TreeNode> stack;
    public  BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeftNode(root);
    }

    public int next() {
        TreeNode temp = stack.pop();
        if (temp.right != null) {
            pushLeftNode(temp.right);
        }
        return temp.val;
    }

    private void pushLeftNode(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);
        BSTIterator bstI = new BSTIterator(root);
        System.out.println(bstI.next());
        System.out.println(bstI.next());
        System.out.println(bstI.hasNext());
        System.out.println(bstI.next());
        System.out.println(bstI.hasNext());
        System.out.println(bstI.next());
        System.out.println(bstI.hasNext());
        System.out.println(bstI.next());
        System.out.println(bstI.hasNext());
    }
}
