package Day258;

import java.util.Collections;
import java.util.PriorityQueue;

import static Day256.PrintArray.printArray;
import static Day256.RandomArray.randomArray;

public class MaxHeapDemo {

    public static void main(String[] args) {

        int[] nums = randomArray(10, 20);
        printArray(nums);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int x : nums) {
            minHeap.add(x);
        }
        System.out.println(minHeap);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : nums) {
            maxHeap.add(x);
        }
        System.out.println(maxHeap);
    }
}
