package Day287;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC347 {

    public static int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((node1, node2) -> node2.freq - node1.freq);
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Integer i : map.keySet()) {
            pq.offer(new Node(i, map.get(i)));
        }
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().data;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1, 1, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
}

class Node {
    int data;
    int freq;

    public Node(int data, int freq) {
        this.data = data;
        this.freq = freq;
    }
}