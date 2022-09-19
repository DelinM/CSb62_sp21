package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public static void testThreeAddThreeRemove(){
        AListNoResizing<Integer> alist = new AListNoResizing<>();
        BuggyAList<Integer> blist = new BuggyAList<>();

        for (int i = 4; i <= 6; i++) {
            alist.addLast(i);
            blist.addLast(i);
        }

        assertEquals(alist.size(), blist.size());

        assertEquals(alist.removeLast(), blist.removeLast());
        assertEquals(alist.removeLast(), blist.removeLast());
        assertEquals(alist.removeLast(), blist.removeLast());
    }
    @Test
    public static void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        

        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                System.out.println("size: " + size);
            } else if (operationNumber == 2 & L.size() > 0) {
                int number = L.getLast();
                L.removeLast();
                System.out.println("removeLast(" + number + ")");
            }
        }
    }

    public static void main(String[] args) {
        randomizedTest();
    }
}
