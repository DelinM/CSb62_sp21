package deque;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public class MaxArrayDequeTest {
    @Test
    public void maxWithoutComparatorTest() {
        MaxArrayDeque<Integer> mad = new MaxArrayDeque<>(new IntComparator());

        for (int i = 0; i < 5; i++) {
            mad.addLast(i);
        }

        assertEquals((Integer) 4, mad.max());
    }

    public void maxWithoutComparatorTest2() {
        MaxArrayDeque<String> mad = new MaxArrayDeque<>(new StringLengthComparator());
        mad.addLast("abc");
        mad.addLast("abc");
        mad.addLast("abc");
        mad.addLast("abc");

        assertEquals((Integer) 4, mad.max());

    }
    private static class IntComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            return  a - b;
        }
    }

    private static class StringLengthComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            int al = a.length();
            int bl = b.length();
            return al - bl;
        }
    }

}
