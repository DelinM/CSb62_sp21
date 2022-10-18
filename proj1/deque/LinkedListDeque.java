package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Iterable<T>, Deque<T> {

    public StuffNode sentinel;
    public int size;

    private class StuffNode {

        public StuffNode prev;
        public T item;
        public StuffNode next;

        public StuffNode(StuffNode p, T i, StuffNode n) {
            prev = p;
            item = i;
            next = n;
        }

    }

    /** Creats an empty LLD */
    public LinkedListDeque() {
        sentinel = new StuffNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;

    }

    /** Create an LLD with new data */
    public LinkedListDeque(T x) {
        sentinel = new StuffNode(null, null, null);
        sentinel.next = new StuffNode(sentinel, x, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    /** Add an element at location one */
    public void addFirst(T x) {
        sentinel.next = new StuffNode(sentinel, x, sentinel.next);
        sentinel.next.next.prev = sentinel.next;

        /** increase size by 1 */
        size++;
    }

    /** Add an element at location last */
    public void addLast(T x) {
        sentinel.prev = new StuffNode(sentinel.prev, x, sentinel);
        sentinel.prev.prev.next = sentinel.prev;

        /** increase size by 1 */
        size++;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        StuffNode p = sentinel.next;
        for (int i = 1; i <= size; i++) {
            System.out.println(p.item);
            p = p.next;
        }
    }

    public T removeFirst() {

        if (size == 0) {
            return null;
        }
        /** get the value of T*/
        StuffNode p = sentinel.next;
        T result = p.item;

        /** reassign stuffnode*/
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return result;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }

        /** get the last item*/
        StuffNode p = sentinel.prev;
        T result = p.item;

        /** remove the last node */
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;

        size--;

        return  result;
    }

    public T get(int index) {

        /** base condition check*/
        if (size == 0 || index > size - 1 ) {
            return null;
        }

        /** note that when it comes to size and index, size is always 1 bigger than index*/
        StuffNode p = sentinel;
        for (int i = 0;i <= index;i++ ) {
            p = p.next;
        }

        return p.item;
    }

    /** returns an iterator into ME */
    public Iterator<T> iterator() {
     return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private int pos;
        public boolean hasNext() {
            return pos < size;

        }
        public T next() {
            T returnItem = get(pos);
            pos += 1;
            return returnItem;
        }

    }

    public boolean equals(Object o) {

    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> something = new LinkedListDeque<>();
        something.addFirst(5);
        something.addFirst(5);
        something.addFirst(15);

        for (int i : something) {
            System.out.println(i);
        }
    }

}
