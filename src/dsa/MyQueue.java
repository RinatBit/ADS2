package dsa;

public class MyQueue<T> {
    private MyLinkedList<T> list;

    public MyQueue() {
        list = new MyLinkedList<>();
    }

    public void enqueue(T item) {
        list.add(item);
    }

    public T dequeue() {
        if (list.size() == 0) throw new IndexOutOfBoundsException("Queue is empty.");
        return list.remove(0);
    }

    public T peek() {
        if (list.size() == 0) throw new IndexOutOfBoundsException("Queue is empty.");
        return list.get(0);
    }

    public int size() {
        return list.size();
    }
}