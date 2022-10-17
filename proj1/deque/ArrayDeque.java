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

        for (int i = 0; i < items.length - 1; i++) {
            T item = items[arrayInd(i)];
            temp[i] = item;
        }

        nextFirst = temp.length - 1;
        nextLast = items.length;

        items = temp;
    }

    public void addFirst(T item) {
        size++;

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
    }

    public void addLast(T item) {
        size++;

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

        for (int i = 0; i < items.length - 1; i++) {
            T item = items[arrayInd(i)];
            temp[i] = item;
        }

        nextFirst = temp.length - 1;
        nextLast = items.length;

        items = temp;
    }


    public T removeFirst() {


        if (decrease_resize()){
            deresize();
        }

        int index = arrayInd(0);
        T item = items[index];
        items[index] = null;

        nextFirst = nextFirst + 1;

        if (nextFirst == items.length){
            nextFirst = 0;
        }
        size--;
        return item;
    }

    public T removeLast() {


        if (decrease_resize()){
            deresize();
        }

        int index = arrayInd(size -1);
        T item = items[index];
        items[index] = null;

        // update the addLast location
        nextLast = nextLast - 1;

        if(nextLast == -1) {
            nextLast = items.length - 1;
        }
        size--;
        return item;

    }

    public T get(int index) {
        int arrayIndex = arrayInd(index);
        return items[arrayIndex];
    }

    public static void main(String[] args) {
        ArrayDeque test = new ArrayDeque();
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
    }
}
