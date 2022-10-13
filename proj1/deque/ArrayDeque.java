package deque;

public class ArrayDeque<T> {
    public int size;
    private int nextFirst;
    private int nextLast;
    public T[] items;

    public ArrayDeque() {

        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    public void addFirst(T item) {
        size++;

        // if nextFirst reach 0, assign it to items.length - 1;

        if (nextFirst == -1) {
            nextFirst = items.length - 1;
        }

        items[nextFirst] = item;
        nextFirst = nextFirst - 1;
    }

    public void addLast(T item) {
        size++;

        // if nextLast is longer than the length - 1, assign it to 0
        if(nextLast > items.length - 1) {
            nextLast = 0;
        }
        items[nextLast] = item;
        nextLast = nextLast + 1;
    }

    private boolean checkResize(int nFirst, int nLast) {
        if ((nFirst - nLast) == 2) {
            return true;
        }
        return false;
    }

    private void adResize() {

    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {

        for(int i = nextFirst+1; i < items.length; i ++) {
            System.out.println(items[i]);
        }



    }
//
//    public T removeFirst() {
//
//    }
//
//    public T removeLast() {
//
//    }
//
//    public T get(int index) {
//
//    }

    public static void main(String[] args) {
        ArrayDeque test = new ArrayDeque();
        test.addFirst(5);
        test.addFirst(3);
        test.addFirst(4);
        test.addFirst(6);
        test.addFirst(9);
        test.addLast(10);
        test.addFirst(2);
        test.addFirst(2);
    }

}
