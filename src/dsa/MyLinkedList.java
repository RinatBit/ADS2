package dsa;

import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {
    private class MyNode {
        T element;
        MyNode next;
        MyNode prev;

        MyNode(T element) {
            this.element = element;
            this.next = null;
            this.prev = null;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(T item) {
        MyNode newNode = new MyNode(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        MyNode newNode = new MyNode(item);
        if (index == 0) {
            newNode.next = head;
            if (head != null) head.prev = newNode;
            head = newNode;
        } else if (index == size) {
            newNode.prev = tail;
            if (tail != null) tail.next = newNode;
            tail = newNode;
        } else {
            MyNode current = getNodeAt(index);
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
        }
        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return getNodeAt(index).element;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        MyNode nodeToRemove = getNodeAt(index);
        if (nodeToRemove.prev != null) nodeToRemove.prev.next = nodeToRemove.next;
        if (nodeToRemove.next != null) nodeToRemove.next.prev = nodeToRemove.prev;
        if (nodeToRemove == head) head = nodeToRemove.next;
        if (nodeToRemove == tail) tail = nodeToRemove.prev;
        size--;
        return nodeToRemove.element;
    }

    @Override
    public void set(int index, T item) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        getNodeAt(index).element = item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                T element = currentNode.element;
                currentNode = currentNode.next;
                return element;
            }
        };
    }

    private MyNode getNodeAt(int index) {
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}