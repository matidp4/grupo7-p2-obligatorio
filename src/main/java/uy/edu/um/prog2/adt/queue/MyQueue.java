package uy.edu.um.prog2.adt.queue;

public interface MyQueue<E> {
    void enqueue(E element);
    E dequeue() throws EmptyQueueException;
    E peek() throws EmptyQueueException;
    boolean isEmpty();
    int size();
    boolean contains(E value);
}
