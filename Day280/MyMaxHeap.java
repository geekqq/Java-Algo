package Day280;

import java.util.NoSuchElementException;

import static Day37.SortedArray.swap;

public class MyMaxHeap {

    private int[] heap;
    private int size;
    private int capacity;

    public MyMaxHeap(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.size = 0;
    }

    public MyMaxHeap() {
        this(10);
    }

    public MyMaxHeap(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            heap[i] = arr[i];
        }
        size = heap.length;
    }

    public int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }


    public int getRightChildIndex(int index) {
        return index * 2 + 2;
    }

    public int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    public boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    public boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    public boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }


    private void percolateUp() {
        int index = size - 1;
        while (hasParent(index) && heap[getParentIndex(index)] < heap[index]) {
            swap(heap, index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private void percolateDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int largestChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && heap[getRightChildIndex(index)] > heap[getLeftChildIndex(index)]) {
                largestChildIndex = getRightChildIndex(index);
            }
            if (heap[index] > heap[largestChildIndex]) {
                break;
            } else {
                swap(heap, index, largestChildIndex);
            }
            index = largestChildIndex;
        }
    }

    public boolean offer(int val) {
        if (size == capacity) {
            return false;
        }
        heap[size] = val;
        size++;
        percolateUp();
        return true;
    }

    public Integer poll() {
        if (size == 0) throw new NoSuchElementException();
        int top = heap[0];
        heap[0] = heap[size - 1];
        percolateDown();
        size--;
        return top;
    }

    public Integer peek() {
        if (size == 0) throw new NoSuchElementException();
        return heap[0];
    }

    public Integer update(int index, int val) {
        if (index < 0 && index >= size) throw new NoSuchElementException();
        int oldVal = heap[index];
        heap[index] = val;
        percolateUp();
        return oldVal;
    }

}
