package uy.edu.um.prog2.adt.stack;

import uy.edu.um.prog2.adt.queue.EmptyQueueException;

public interface MyStack<E> {
    void push(E element);
    E pop() throws EmptyStackException;
    E peek() throws EmptyQueueException;
    boolean isEmpty();
    int size();
    void clear();
}
