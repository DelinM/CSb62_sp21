package deque;

//package deque;
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

    private int arrayInd(int ind) {
        if (nextFirst + 1 + ind < items.length) {
            return nextFirst + 1 + ind;
        } else {
            return nextFirst + 1 + ind - items.length;
        }
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
        if (size >= items.length / 2) {
            return true;
        } else {
            return false;
        }
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

    public void printDeque(){
        int index = 0;

        for (int i = 0; i < size; i++) {
            System.out.print(items[arrayInd(i)] + " ");
        }
    }

    public T removeFirst() {
        size--;
        int index = arrayInd(0);
        T item = items[index];
        items[index] = null;

        nextFirst = nextFirst + 1;

        if (nextFirst == items.length){
            nextFirst = 0;
        }
        return item;
    }

    public T removeLast() {
        size--;
        int index = arrayInd(size - 1);
        T item = items[index];


        // update the addLast location
        nextLast = nextLast - 1;

        if(nextLast == -1) {
            nextLast = items.length - 1;
        }

        return item;

    }

    public T get(int index) {
        int arrayIndex = arrayInd(index);
        return items[arrayIndex];
    }

    public static void main(String[] args) {
        ArrayDeque test = new ArrayDeque();
        test.addFirst(5);
        test.addFirst(3);
        test.addFirst(4);
        test.addFirst(6);
        test.addFirst(9);
        test.addFirst(10);
        test.addFirst(2);
        test.addFirst(2);
        test.printDeque();
        System.out.println();

        test.removeFirst();
        test.printDeque();


        test.removeLast();
        test.printDeque();
        System.out.println();

        test.removeLast();
        test.printDeque();
        System.out.println();

        test.removeLast();
        test.printDeque();
        System.out.println();

        int result = (int) test.get(1);
        System.out.println(result);


    }

}