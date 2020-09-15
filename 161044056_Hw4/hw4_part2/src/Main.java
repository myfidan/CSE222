import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {

        try{
            Deque<Integer> x=new myDeque<>();

            x.addFirst(2);
            x.addFirst(4);
            x.addFirst(5);
            x.addLast(1);
            x.offerFirst(3);
            x.offerLast(11);
            x.removeFirst();
            x.removeFirst();
            x.addFirst(0);
            x.addFirst(3);
            x.removeLast();
            x.addFirst(7);
            x.pollFirst();
            x.pollLast();
            x.addFirst(1);
            x.addLast(5);
            x.removeLast();
            x.offer(8);
            x.remove();
            x.poll();
            x.addLast(0);
            x.addFirst(2);
            x.removeFirstOccurrence(0);
            x.removeLastOccurrence(2);
            //Using my iterator with calling myDeque class iterator method.
            Iterator<Integer> myIter=x.iterator();

            while(myIter.hasNext())
                System.out.println(myIter.next());

            System.out.println("myDeque size: "+x.size());
            System.out.println("first element: "+x.getFirst());
            System.out.println("Last element: "+x.getLast());
            System.out.println("first element peekFist : "+x.peekFirst());
            System.out.println("Last element peekLast: "+x.peekLast());

        }
        catch (NoSuchElementException x){
            System.out.println("Error Catched: No such Element");
        }
        catch (UnsupportedOperationException y){
            System.out.println("Error Catched: You call a method which I dont implement");
        }


    }
}
