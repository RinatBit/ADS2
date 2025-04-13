package dsa;

public class MyStack<T> {
    private MyArrayList<T> list;

    public MyStack() {
        list = new MyArrayList<>();
    }

    public void push(T item) {
        list.add(item);
    }

    public T pop() {
        if (list.size() == 0) throw new IndexOutOfBoundsException("Stack is empty.");
        return list.remove(list.size() - 1);
    }

    public T peek() {
        if (list.size() == 0) throw new IndexOutOfBoundsException("Stack is empty.");
        return list.get(list.size() - 1);
    }

    public int size() {
        return list.size();
    }
}