package uy.edu.um.prog2.adt.heap;

public interface MyHeap<E extends Comparable<E>> {
    boolean isEmpty();
    int size();
    void insert(E element);
    E peek();
    E extract();
    void clear();

    boolean contains(E parseInt);
}