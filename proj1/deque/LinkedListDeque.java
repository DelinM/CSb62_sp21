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
    }

    /* first item is at sentinel.next */
    private StuffNode sentinel;
    public int size;

    /**
     * Creats an empty LLD
     */
    public LinkedListDeque() {
        sentinel = new StuffNode(null, null, null);
        size = 0;
    }

    /**
     * Create an LLD with new data
     */
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
        size++;
    }

    /** Add an element at location last */
    public void addLast(T x) {
        sentinel.prev.next = new StuffNode(sentinel.prev, x, sentinel);
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

        while(p.item != null) {
            System.out.println(p.item);
            p = p.next;
        }

    }

    public T removeFirst() {
        T i = sentinel.next.item;
        if (sentinel.prev.equals(sentinel.next)) {
            sentinel = new StuffNode(null, null, null);
        } else {
            sentinel.next = sentinel.next.next;
            sentinel.next.next.prev = sentinel;
        }
    return i;
    }

    public static void main(String[] args) {
        LinkedListDeque<String> lld1 = new LinkedListDeque<>("something1");
        lld1.addFirst("something2");
        lld1.addFirst("something3");
        lld1.addFirst("something3");
        lld1.addLast("something4");
        System.out.println("2");
    }
    public T removeLast() {

    }

    public T get(int index) {

    }

//    public Iterator<T> iterator() {
//
//    }
//
//    public boolean equals(Object o) {
//
//    }


}
