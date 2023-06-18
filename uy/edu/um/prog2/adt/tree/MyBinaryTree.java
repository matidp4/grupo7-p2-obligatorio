package uy.edu.um.prog2.adt.tree;

import uy.edu.um.prog2.adt.linkedlist.MyLinkedList;

public interface MyBinaryTree<K extends Comparable<K>, V> {

    void add(K key, V value);

    void remove(K key);

    boolean contains(K key);

    V find(K key);

    MyLinkedList<K> inOrder();

}
