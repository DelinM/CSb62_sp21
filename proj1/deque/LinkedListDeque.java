package deque;

public class LinkedListDeque<T> {

    private class IntNode() {
        public IntNode prev;
        public T item;
        public IntNode next;

        public IntNode(IntNode p, T i, IntNode n) {
            prev = p;
            item = i;
            next = n;
    }

    private IntNode sentinel;
    public int size;
    
    public LinkedListDeque(T item) {
        
        size = 1;

    }

    
    public void addFirst(T item) {

    }

    public void addLast(T item) {

    }

    public boolean isEmpty() {

    }

    public int size() {

    }

    public void printDeque() {

    }

    public T removeFirst() {

    }

    public T removeLast() {

    }

    public T get(int index) {

    }

    public Iterator<T> iterator() {

    }

    public boolean equals(Object o) {

    }
}

