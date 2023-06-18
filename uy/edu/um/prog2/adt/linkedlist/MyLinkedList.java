package uy.edu.um.prog2.adt.linkedlist;

public interface MyLinkedList<E> {
    void add(E element);
    void add(int index, E element);
    E get(int index);
    E remove(int index);
    boolean remove(E element);
    boolean contains(E element);
    int indexOf(E element);
    boolean isEmpty();
    int size();
    void clear();
}