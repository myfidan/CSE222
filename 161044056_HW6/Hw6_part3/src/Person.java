import java.util.*;

public class Person {
    protected String Name;
    protected String Surname;

    public Person(String Name,String Surname){
        this.Name=Name;
        this.Surname=Surname;
    }

    /**
     * Admin or user can search book
     * @param mySystem my system
     * @param bookInfo bookinfo can be either authorname or book name both of them works
     */
    public void searchBook(LibrarySystem mySystem,String bookInfo){
        //if this true than it meand input bookInfo is a book author
        if(mySystem.BookMap.containsKey(bookInfo)){
            System.out.println("Author name: "+bookInfo);
            System.out.print("Books: ");
            System.out.println(mySystem.BookMap.get(bookInfo).keySet());

            if(mySystem.BookMap.get(bookInfo).size()==0){
                System.out.println("This Author doesn't have any book in system");
                return;
            }

            Scanner input= new Scanner(System.in);
            System.out.println("Enter Book name for see book locations:");
            String bookname=input.nextLine();
            if(!(mySystem.BookMap.get(bookInfo).keySet().contains(bookname))){
                System.out.println("Wrong input,Can't find a book named "+bookname);
                return;
            }
            System.out.println("Locations:");
            Iterator<String> Locations = mySystem.BookMap.get(bookInfo).get(bookname).iterator();
            while(Locations.hasNext()){
                System.out.println(Locations.next());
            }
            return;
        }
        //it means input is a book title
        boolean check_book_title=false;
        Set<String> keys=mySystem.BookMap.keySet();
        Iterator<String> iter=keys.iterator();
        while(iter.hasNext()){
            String title = iter.next();
            if(mySystem.BookMap.get(title).containsKey(bookInfo)){
                System.out.print("Author name: ");
                System.out.println(title);
                System.out.print("Locations: ");
                System.out.println(mySystem.BookMap.get(title).get(bookInfo));
                return;
            }
        }

        System.out.println("There is no element");
    }
}
