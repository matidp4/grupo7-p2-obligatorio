package uy.edu.um.prog2.adt.heap;

import java.util.Arrays;

public class MyHeapImpl<E extends Comparable<E>> implements MyHeap<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private E[] heap;
    private int size;

    @SuppressWarnings("unchecked")
    public MyHeapImpl(int i, boolean b) {
        this.heap = (E[]) new Comparable[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @SuppressWarnings("unchecked")
    public MyHeapImpl(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.heap = (E[]) new Comparable[capacity];
        this.size = 0;
    }

    @Override
    public void insert(E element) {
        if (size == heap.length) {
            resizeHeap();
        }

        heap[size] = element;
        heapifyUp(size);
        size++;
    }

    private void resizeHeap() {
        int newCapacity = heap.length * 2;
        heap = Arrays.copyOf(heap, newCapacity);
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;

        while (index > 0 && heap[index].compareTo(heap[parentIndex]) > 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        return heap[0];
    }

    @Override
    public E extract() {
        return null;
    }

    @Override
    public void clear() {

    }


    public E extractMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        E maxElement = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);

        return maxElement;
    }

    private void heapifyDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        int largestIndex = index;

        if (leftChildIndex < size && heap[leftChildIndex].compareTo(heap[largestIndex]) > 0) {
            largestIndex = leftChildIndex;
        }
        if (rightChildIndex < size && heap[rightChildIndex].compareTo(heap[largestIndex]) > 0) {
            largestIndex = rightChildIndex;
        }

        if (largestIndex != index) {
            swap(index, largestIndex);
            heapifyDown(largestIndex);
        }
    }

    private void swap(int i, int j) {
        E temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}