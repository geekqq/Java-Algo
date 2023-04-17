package Day214;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0 || k > n) return res;

        getRes(n, k, 1, new ArrayList<>(), res);
        return res;
    }

    private static void getRes(int n, int k, int index, List<Integer> list, List<List<Integer>> res) {
        if (list.size() >= k) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i <= n; i++) {
            list.add(i);
            getRes(n, k, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }

    // this is wrong answer
    public static List<List<Integer>> combineI(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int temp = n;
        ArrayList<Integer> array = new ArrayList<>();
        do {
            array.add(n % 10);
            n /= 10;
        } while (n > 0);
        dfs(array, 0, k, res, new LinkedList<>());
        return res;
    }

    private static void dfs(ArrayList<Integer> array, int index, int k, List<List<Integer>> res, LinkedList path) {
        if (index == array.size()) {
            res.add(new LinkedList<>(path));
            return;
        }
        path.add(array.get(index));
        dfs(array, index + 1, k - 1, res, path);
        path.remove(path.size() - 1);

        dfs(array, index + 1, k - 1, res, path);
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
        System.out.println(combineI(4, 2));
    }
}
