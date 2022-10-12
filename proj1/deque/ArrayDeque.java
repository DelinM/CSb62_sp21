package deque;



public class ArrayDeque<T> {
    public int size;
    public int nextFirst;
    public int nextLast;
    public T[] items;

    /** instantiate ArrayDeque with no input*/
    public ArrayDeque() {

        /** instantaite deque */
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 3;
        nextLast = 4;
    }

    /** resize method required when adding */
    public void addFirst(T item) {

        size++;

    }

    public void addLast(T item) {

        size++;
    }

    public boolean isEmpty() {

    }

    public int size() {
        return size;
    }

    public void printDeque() {

    }

    public T removeFirst() {

    }

    public T removeLast() {

    }

    public T get(int index) {

    }

}
