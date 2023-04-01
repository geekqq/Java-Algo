package Day204;

import java.util.ArrayList;
import java.util.List;

public class FindClosestValue {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
        System.out.println("-------------------");
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(closestValue(root, 3.714286));
        System.out.println(closestValueI(root, 3.714286));
        System.out.println(closestValueII(root, 3.714286));
        TreeNode root1 = new TreeNode(1);
        System.out.println(closestValue(root1, 4.428571));
        System.out.println(closestValueI(root1, 4.428571));
        System.out.println(closestValueII(root1, 4.428571));

    }

    public static List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        List left = inOrderTraversal(root.left);
        List right = inOrderTraversal(root.right);
        res.addAll(left);
        res.add(root.val);
        res.addAll(right);
        return res;
    }

    private static int findClosestValue(List<Integer> res, double x) {
        int left = 0;
        int right = res.size() - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (res.get(mid) == x) return res.get(mid);
            else if (res.get(mid) < x) left = mid;
            else right = mid;
        }
        return Math.abs(res.get(left) - x) <= Math.abs(res.get(right) - x) ? res.get(left) : res.get(right);
    }

    public static int closestValue(TreeNode root, double target) {
        List res = inOrderTraversal(root);
        return findClosestValue(res, target);
    }

    public static int closestValueI(TreeNode root, double target) {
        if (root == null) {
            throw new IllegalArgumentException();
        }

        int closest = root.val;
        TreeNode cur = root;
        while (cur != null) {
            if (Math.abs(cur.val - target) <= Math.abs(closest - target)) {
                closest = cur.val;
            }
            if (cur.val > target) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return closest;
    }

    //closestValueII 有问题，LC提交错误，不能输出正确答案，暂时搁置
    static int res = Integer.MAX_VALUE;
    public static int closestValueII(TreeNode root, double target) {
        if (root == null) return -1;
        dfs(root, target);
        return res;
    }

    private static void dfs(TreeNode root, double target) {
        if (root == null) return;
        if (Math.abs(target - root.val) <= Math.abs(target - res)) {
            if (Math.abs(target - root.val) == Math.abs(target - res)) {
                res = Math.min(res, root.val);
            } else {
                res = root.val;
            }
        }
        if (root.val == target) return;
        if (root.val > target) {
            dfs(root.left, target);
        } else {
            dfs(root.right, target);
        }
    }
}
