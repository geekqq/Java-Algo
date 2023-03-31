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
        System.out.println(findClosestValue(list, 2.5));
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
}
