package deque;



public class ArrayDeque<T> {
    public int size;
    private int nextFirst;
    private int nextLast;
    public T[] items;

    /** instantiate ArrayDeque with no input*/
    public ArrayDeque() {

        /** instantaite deque */
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    /** resize method required when adding */
    public void addFirst(T item) {
        size++;

        items[nextFirst] = item;
        nextFirst = nextFirst - 1;


    }

    public void addLast(T item) {
        size++;



    }

    private 

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
