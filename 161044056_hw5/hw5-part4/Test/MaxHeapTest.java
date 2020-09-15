import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxHeapTest {

    @Test
    void add() {
        MaxHeap<AgeData> heap=new MaxHeap<>();
        heap.add(new AgeData(40));
        heap.add(new AgeData(10));
        heap.add(new AgeData(5));
        heap.add(new AgeData(70));
        heap.add(new AgeData(10));
        assertEquals("10-2\n40-1\n5-1\n70-1\n",heap.toString());
    }

    @Test
    void remove1() {
        MaxHeap<AgeData> heap=new MaxHeap<>();
        heap.add(new AgeData(40));
        heap.add(new AgeData(10));
        heap.add(new AgeData(5));
        heap.add(new AgeData(70));
        heap.add(new AgeData(10));

        heap.remove(new AgeData(70));
        assertEquals("10-2\n40-1\n5-1\n",heap.toString());
    }

    @Test
    void remove2(){
        MaxHeap<AgeData> heap=new MaxHeap<>();
        heap.add(new AgeData(40));
        heap.add(new AgeData(10));
        heap.add(new AgeData(5));
        heap.add(new AgeData(70));
        heap.add(new AgeData(10));

        heap.remove(new AgeData(10));
        assertEquals("10-1\n40-1\n5-1\n70-1\n",heap.toString());
    }

    @Test
    void find() {
        MaxHeap<AgeData> heap=new MaxHeap<>();
        heap.add(new AgeData(40));
        heap.add(new AgeData(10));
        heap.add(new AgeData(5));
        heap.add(new AgeData(70));
        heap.add(new AgeData(10));

        assertEquals("10-2",heap.find(new AgeData(10)).toString());
    }

    @Test
    void youngerThan() {
        MaxHeap<AgeData> heap=new MaxHeap<>();
        heap.add(new AgeData(40));
        heap.add(new AgeData(10));
        heap.add(new AgeData(5));
        heap.add(new AgeData(70));
        heap.add(new AgeData(10));

        assertEquals(2,heap.youngerThan(15));
    }

    @Test
    void olderThan() {
        MaxHeap<AgeData> heap=new MaxHeap<>();
        heap.add(new AgeData(40));
        heap.add(new AgeData(10));
        heap.add(new AgeData(5));
        heap.add(new AgeData(70));
        heap.add(new AgeData(10));

        assertEquals(3,heap.olderThan(8));
    }
}