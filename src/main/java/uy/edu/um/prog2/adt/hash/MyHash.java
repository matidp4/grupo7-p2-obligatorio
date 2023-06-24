package uy.edu.um.prog2.adt.hash;

import uy.edu.um.prog2.adt.linkedlist.MyLinkedList;

public interface MyHash<K, V> {
    void put(K key, V value);
    V get(K key);
    boolean containsKey(K key);
    boolean containsValue(V value);
    void remove(K key);
    void clear();
    int size();
    boolean isEmpty();
    MyLinkedList<Integer> keySet();
    MyLinkedList<String> values();

    boolean contains(K i);

}