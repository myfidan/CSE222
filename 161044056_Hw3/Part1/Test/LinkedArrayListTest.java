import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinkedArrayListTest {

    @Test
    void add() {
        List<Integer> test=new LinkedArrayList<>();
        test.add(3);
        test.add(2);
        test.add(1);
        test.add(5);
        /*
        List:
        3 2 1
        5
        */
        assertEquals("List:\n3 2 1\n5\n",test.toString());

    }

    @Test
    void add1() {
        List<Integer> test=new LinkedArrayList<>();
        test.add(5);
        test.add(7);
        test.add(2);
        test.add(1);
        test.remove((Integer)7);
        test.add(0,6);
        /*
        List:
        5 6 2
        1
         */
        assertEquals("List:\n5 2 6\n1\n",test.toString());
    }

    @Test
    void remove() {
        List<Integer> test=new LinkedArrayList<>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        test.remove((Integer)2);
        test.remove((Integer)4);
        test.remove((Integer)5);
        /*
        List:
        1 3
         */
        assertEquals("List:\n1 3\n",test.toString());
    }

    @Test
    void size() {
        List<Integer> test=new LinkedArrayList<>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);

        assertEquals(2,test.size());
    }
}