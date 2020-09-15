import org.junit.jupiter.api.Test;

import java.util.Deque;

import static org.junit.jupiter.api.Assertions.*;

class myDequeTest {

    @Test
    void addFirst() {
        Deque<Integer> x=new myDeque<>();
        x.addFirst(1);
        x.addFirst(2);
        x.addFirst(3);
        assertEquals("3\n2\n1\n",x.toString());
    }

    @Test
    void addLast() {
        Deque<Integer> x=new myDeque<>();
        x.addLast(1);
        x.addLast(2);
        x.addLast(3);
        assertEquals("1\n2\n3\n",x.toString());
    }

    @Test
    void offerFirst() {
        Deque<Integer> x=new myDeque<>();
        x.offerFirst(1);
        x.offerFirst(2);
        x.offerFirst(3);
        assertEquals("3\n2\n1\n",x.toString());
    }

    @Test
    void offerLast() {
        Deque<Integer> x=new myDeque<>();
        x.offerLast(1);
        x.offerLast(2);
        x.offerLast(3);
        assertEquals("1\n2\n3\n",x.toString());
    }

    @Test
    void removeFirst() {
        Deque<Integer> x=new myDeque<>();
        x.addFirst(1);
        x.addFirst(2);
        x.addFirst(3);
        x.removeFirst();
        assertEquals("2\n1\n",x.toString());
    }

    @Test
    void removeLast() {
        Deque<Integer> x=new myDeque<>();
        x.addFirst(1);
        x.addFirst(2);
        x.addFirst(3);
        x.removeLast();
        assertEquals("3\n2\n",x.toString());
    }

    @Test
    void pollFirst() {
        Deque<Integer> x=new myDeque<>();
        x.addFirst(1);
        x.addFirst(2);
        x.addFirst(3);
        x.pollFirst();
        assertEquals("2\n1\n",x.toString());
    }

    @Test
    void pollLast() {
        Deque<Integer> x=new myDeque<>();
        x.addFirst(1);
        x.addFirst(2);
        x.addFirst(3);
        x.pollLast();
        assertEquals("3\n2\n",x.toString());
    }

    @Test
    void getFirst() {
        Deque<Integer> x=new myDeque<>();
        x.addFirst(1);
        x.addFirst(2);
        x.addFirst(3);
        assertEquals(3,x.getFirst());
    }

    @Test
    void getLast() {
        Deque<Integer> x=new myDeque<>();
        x.addFirst(1);
        x.addFirst(2);
        x.addFirst(3);
        assertEquals(1,x.getLast());
    }

    @Test
    void peekFirst() {
        Deque<Integer> x=new myDeque<>();
        x.addFirst(1);
        x.addFirst(2);
        x.addFirst(3);
        assertEquals(3,x.peekFirst());
    }

    @Test
    void peekLast() {
        Deque<Integer> x=new myDeque<>();
        x.addFirst(1);
        x.addFirst(2);
        x.addFirst(3);
        assertEquals(1,x.peekLast());
    }

    @Test
    void removeFirstOccurrence() {
        Deque<Integer> x=new myDeque<>();
        x.addFirst(1);
        x.addFirst(2);
        x.addFirst(3);
        x.addFirst(2);
        x.addFirst(5);
        x.addFirst(6);
        x.removeFirstOccurrence(2);
        assertEquals("6\n5\n3\n2\n1\n",x.toString());
    }

    @Test
    void removeLastOccurrence() {
        Deque<Integer> x=new myDeque<>();
        x.addFirst(1);
        x.addFirst(2);
        x.addFirst(3);
        x.addFirst(2);
        x.addFirst(5);
        x.addFirst(6);
        x.removeLastOccurrence(2);
        assertEquals("6\n5\n2\n3\n1\n",x.toString());
    }

    @Test
    void offer() {
        Deque<Integer> x=new myDeque<>();
        x.addFirst(1);
        x.addFirst(2);
        x.offer(5);
        assertEquals("5\n2\n1\n",x.toString());
    }

    @Test
    void remove() {
        Deque<Integer> x=new myDeque<>();
        x.addFirst(1);
        x.addFirst(2);
        x.offer(5);
        x.remove();
        assertEquals("2\n1\n",x.toString());
    }

    @Test
    void poll() {
        Deque<Integer> x=new myDeque<>();
        x.addFirst(1);
        x.addFirst(2);
        x.offer(5);
        x.poll();
        assertEquals("2\n1\n",x.toString());
    }

    @Test
    void element() {
        Deque<Integer> x=new myDeque<>();
        x.addFirst(1);
        x.addFirst(2);
        x.offer(5);
        assertEquals(5,x.element());
    }

    @Test
    void peek() {
        Deque<Integer> x=new myDeque<>();
        x.addFirst(1);
        x.addFirst(2);
        assertEquals(2,x.peek());
    }

    @Test
    void clear() {
        Deque<Integer> x=new myDeque<>();
        x.addFirst(1);
        x.addFirst(2);
        x.clear();
        assertEquals(0,x.size());
    }

    @Test
    void push() {
        Deque<Integer> x=new myDeque<>();
        x.push(1);
        x.push(2);
        x.push(3);
        assertEquals("3\n2\n1\n",x.toString());
    }

    @Test
    void pop() {
        Deque<Integer> x=new myDeque<>();
        x.push(1);
        x.push(2);
        x.push(3);
        x.pop();
        x.pop();
        assertEquals("1\n",x.toString());
    }

    @Test
    void size() {
        Deque<Integer> x=new myDeque<>();
        x.push(1);
        x.push(2);
        x.push(3);
        assertEquals(3,x.size());
    }

    @Test
    void isEmpty() {
        Deque<Integer> x=new myDeque<>();
        x.push(1);
        x.push(2);
        x.push(3);
        assertFalse(x.isEmpty());
    }
}