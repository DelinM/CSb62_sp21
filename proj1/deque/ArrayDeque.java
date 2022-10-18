package deque;

import java.util.Iterator;

//package deque;
public class ArrayDeque<T> implements Iterable<T>, Deque<T> {
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

    private boolean increase_Resize() {
        if (size >= items.length / 2) {
            return true;
        } else {
            return false;
        }
    }

    private void adResize() {
        int tempSize = items.length * 2;
        T[] temp = (T[]) new Object[tempSize];

        for (int i = 0; i < size; i++) {
            T item = items[arrayInd(i)];
            temp[i] = item;
        }

        nextFirst = temp.length - 1;
        nextLast = size;

        items = temp;
    }

    public void addFirst(T item) {

        // update size of the ArrayDeque
        if (increase_Resize()) {
            adResize();
        }

        // if nextFirst reach 0, assign it to items.length - 1;
        if (nextFirst == -1) {
            nextFirst = items.length - 1;
        }
        items[nextFirst] = item;
        nextFirst = nextFirst - 1;
        size++;
    }

    public void addLast(T item) {

        // update size of the ArrayDeque
        if (increase_Resize()) {
            adResize();
        }

        // if nextLast is longer than the length - 1, assign it to 0
        if(nextLast > items.length - 1) {
            nextLast = 0;
        }
        items[nextLast] = item;
        nextLast = nextLast + 1;
        size++;

    }

    private int arrayInd(int ind) {
        if (nextFirst + 1 + ind < items.length) {
            return nextFirst + 1 + ind;
        } else {
            return nextFirst + 1 + ind - items.length;
        }
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

    public void printDeque(){
        int index = 0;

        for (int i = 0; i < size; i++) {
            System.out.print(items[arrayInd(i)] + " ");
        }
    }

    private boolean decrease_resize() {
        if (items.length >= 16 && size <= items.length / 4) {
            return true;
        } else {
            return false;
        }
    }

    private void deresize() {
        T[] temp = (T[]) new Object[items.length/2];

        for (int i = 0; i < size; i++) {
            T item = items[arrayInd(i)];
            temp[i] = item;
        }

        nextFirst = temp.length - 1;
        nextLast = size + 2;

        items = temp;
    }


    public T removeFirst() {

        if (isEmpty()){
            items = (T[]) new Object[8];
            size = 0;
            nextFirst = 4;
            nextLast = 5;
            return null;
        }

        if (decrease_resize()){
            deresize();
        }

        int index = arrayInd(0);
        T item = items[index];
        items[index] = null;

        nextFirst = nextFirst + 1;

        size--;

        return item;
    }

    public T removeLast() {

        if (isEmpty()){
            items = (T[]) new Object[8];
            size = 0;
            nextFirst = 4;
            nextLast = 5;
            return null;
        }

        if (decrease_resize()){
            deresize();
        }

        int index = arrayInd(size -1);
        T item = items[index];
        items[index] = null;

        // update the addLast location
        nextLast = nextLast - 1;

        size--;

        return item;
    }

    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int pos = 0;
        public boolean hasNext() {
            return pos < size;
        }

        public T next() {
            T returnItem = get(pos);
            pos += 1;
            return returnItem;
        }
    }



    public T get(int index) {
        int arrayIndex = arrayInd(index);
        return items[arrayIndex];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if(!(o instanceof Deque)) {
            return false;
        }

        Deque<T> oa = (Deque<T>) o;
        if (oa.size() != this.size()) {
            return false;
        }
        for (int i = 0; i < size; i += 1) {
            if (!(oa.get(i).equals(this.get(i)))) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        ArrayDeque<Integer> test = new ArrayDeque<>();
        test.addFirst(12);
        test.addFirst(11);
        test.addFirst(10);
        test.addFirst(9);
        test.addFirst(8);
        test.addFirst(7);
        test.addFirst(6);
        test.addFirst(5);
        test.addFirst(4);
        test.addFirst(3);
        test.addFirst(2);
        test.addFirst(1);
        test.addFirst(0);
        test.addFirst(-1);
        test.addLast(-2);

        test.removeLast();
        test.removeLast();
        test.removeLast();
        test.removeLast();
        test.removeLast();
        test.removeLast();
        test.removeLast();
        test.removeLast();
        test.removeLast();
        test.removeLast();
        test.printDeque();
        System.out.println();

        for (int i : test) {
            System.out.println(i);
        }

    }
}
