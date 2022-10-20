package deque;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Filteredlist<T> implements Iterable<T> {
    List<T> list;
    Predicate<T> pred;

    public Filteredlist(List<T> L, Predicate<T> filter) {
        list = L;
        pred = filter;
    }

    @Override
    public Iterator<T> iterator() {
        return new FLiterator();
    }
    public class FLiterator implements Iterator<T> {
        int index;

        public FLiterator() {
            index = 0;
            moveIndex();
        }

        private void moveIndex() {
            while (hasNext() & !pred.test(list.get(index))) {
                index += 1;
            }
        }


        Filteredlistt sada = list;

        public boolean hasNext(){
            list.
            return true;
        }

        public T next() {
            return T;
        }
    }


}
