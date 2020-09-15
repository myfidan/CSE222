import java.util.List;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {

        List<Integer> deneme=new LinkedArrayList<>();

        try {

            deneme.add(1);
            deneme.add(2);
            deneme.add(3);
            deneme.add(4);
            deneme.add(5);
            deneme.add(6);
            deneme.add(7);

            System.out.print(deneme.toString());
            System.out.println("List size="+deneme.size());
            System.out.println();

            deneme.remove((Integer) 5);
            deneme.remove((Integer) 7);
            System.out.print(deneme.toString());
            System.out.println("List size="+deneme.size());

            deneme.add(0,11);
            System.out.println();
            System.out.print(deneme.toString());
            System.out.println("List size="+deneme.size());


            deneme.remove(2);
            System.out.println();
            System.out.print(deneme.toString());
            System.out.println("List size="+deneme.size());

            deneme.remove(2);
            System.out.println();
            System.out.print(deneme.toString());
            System.out.println("List size="+deneme.size());
        }
        catch (NoSuchElementException y){
            System.out.println("Error Catched:My list doesn't have this element for removing..");
        }
        catch (IndexOutOfBoundsException x){
            System.out.println("Error Catched: Node array index out of bound..");
        }
   }
}
