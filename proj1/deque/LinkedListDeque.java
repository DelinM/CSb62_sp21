package deque;

public class LinkedListDeque<T> {

    private class StuffNode {
        public StuffNode prev;
        public T item;
        public StuffNode next;

        public StuffNode(StuffNode p, T i, StuffNode n) {
            prev = p;
            item = i;
            next = n;
    }

    /* first item is at sentinel.next */
    private StuffNode sentinel;
    public int size;
    
    /** Creats an empty LLD */
    public LinkedListDeque() {
        sentinel = new StuffNode(null, null, null);
        size = 0;
    }

    /** Create an LLD with new data */
    public LinkedListDeque(T x) {
        sentinel = new StuffNode(null, null, null);
        sentinel.next = new StuffNode(sentinel, x, sentinel);
        size = 1;
    }

    
    public void addFirst(T x) {
        sentinel.next = new StuffNode(sentinel, x, sentinel.next);
        first.prev = new StuffNode(null, x, first);
        size++;

    }

    public void addLast(T x) {
        IntNode p = sentinel;

        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(p, x, sentinel);
        size++;

    }

    public boolean isEmpty() {
        if (size = 0){
            return True;
        } else {
            return False;
        }

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

    public Iterator<T> iterator() {

    }

    public boolean equals(Object o) {

    }

    public static void main(String[] args){

    }
}

