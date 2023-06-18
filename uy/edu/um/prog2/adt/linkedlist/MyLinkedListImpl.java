package uy.edu.um.prog2.adt.linkedlist;

import uy.edu.um.prog2.adt.queue.EmptyQueueException;
import uy.edu.um.prog2.adt.queue.MyQueue;
import uy.edu.um.prog2.adt.stack.EmptyStackException;
import uy.edu.um.prog2.adt.stack.MyStack;

public class MyLinkedListImpl<E> implements MyLinkedList<E>, MyQueue<E>, MyStack<E> {
    private ListNode<E> head;
    private int size;
    private ListNode<E> last;


    public static class ListNode<E> {
        private final Object last;
        private E element;
        private ListNode<E> next;

        public ListNode(Object last, E element) {
            this.last = last;
            this.element = element;
            this.next = null;
        }

        public ListNode(E element) {
            this.element = element;
            this.next = null;
            this.last = null;
        }

        public E getValue() {
            return null;
        }

        public void setNext(ListNode<E> head) {
        }
    }

    public MyLinkedListImpl() {
        this.head = null;
        this.size = 0;
    }


    /*
    public void add(E element) {
        ListNode<E> newNode = new ListNode<>(element);
        if (head == null) {
            head = newNode;
        } else {
            ListNode<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    } */
    // add más rápido
    @Override
    public void add(E element) {
        ListNode<E> newNode = new ListNode<E>(element);
        if (head == null) {
            head = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    @Override
    public void add(int index, E element) {

    }


    /*
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        ListNode<E> newNode = new ListNode<>(element);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            ListNode<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    } */

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        ListNode<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        E removedElement;
        if (index == 0) {
            removedElement = head.element;
            head = head.next;
        } else {
            ListNode<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            removedElement = current.next.element;
            current.next = current.next.next;
        }
        size--;
        return removedElement;
    }

    @Override
    // aca no tendria q ser un public void ????
    public boolean remove(E element) {
        if (head == null) {
            return false;
        }

        if (head.element.equals(element)) {
            head = head.next;
            size--;
            return true;
        }

        ListNode<E> current = head;
        while (current.next != null) {
            if (current.next.element.equals(element)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }

        return false;
    }

    @Override
    public boolean contains(E element) {
        ListNode<E> current = head;
        while (current != null) {
            if (current.element.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int indexOf(E element) {
        ListNode<E> current = head;
        int index = 0;
        while (current != null) {
            if (current.element.equals(element)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;}

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {
    }

    // para queue
    private void addToBeginning(E value) {
        if (value != null) {

            ListNode<E> elementToAdd = new ListNode<>(value);

            if (this.head == null) {
                this.head = elementToAdd;
                this.last = elementToAdd;

            } else {
                elementToAdd.setNext(this.head);
                this.head = elementToAdd;
            }
        }
    }
    @Override
    public void enqueue(E element) { // agrego adelante
        addToBeginning(element);
    }
    public E dequeue() throws EmptyQueueException { // saco atras (primero que entra)
        if (this.last == null) { // si la queue esta vacia

            throw new EmptyQueueException();
        }
        return remove(this.size());
    }

    public E peek() throws EmptyQueueException {
        if (this.last == null) { // si la queue esta vacia

            throw new EmptyQueueException();
        }
        return this.last.getValue();
    }
    // para stack
    @Override
    public void push(E element) { // agrego al final
        add(element);
    }
    public E pop() throws EmptyStackException { // saco el ultimo
        if (this.last == null) { // si la queue esta vacia

            throw new EmptyStackException();
        }
        return remove(this.size());
    }

}