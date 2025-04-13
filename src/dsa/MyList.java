package dsa;

import java.util.Iterator;

public interface MyList<T> {
    void add(T item);
    void add(int index, T item);
    T get(int index);
    T remove(int index);
    void set(int index, T item);
    int size();
    Iterator<T> iterator();
}