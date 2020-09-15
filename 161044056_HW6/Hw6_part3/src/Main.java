

public class Main {

    public static void main(String[] args) {

        LibrarySystem mySystem=new LibrarySystem();
        try{
            Administrator admin1=new Administrator("Yasir","Fidan");
            admin1.enterSystem(mySystem,"123@pass");
            User user1=new User("John","Locke");

            Book book1=new Book("Tolkien","LOTR","c3s5.1534");
            Book book2=new Book("JJR","Harry Potter Ates Kadehi","c5s8.732");
            Book book3=new Book("JJR","Harry Potter Ates Kadehi","c2s1.2121");
            Book book4=new Book("Dostoyevski","Demons","c1s1.3431");
            Book book5=new Book("Tolkien","Hobbit","c6s2.4211");
            Book book6=new Book("Stefan Zweig","Chess","c2s1.1113");
            Book book7=new Book("JJR","Harry Potter Melez Prens","c4s4.1541");

            //Admin add books to the system-
            admin1.addBook(mySystem,book1);
            admin1.addBook(mySystem,book2);
            admin1.addBook(mySystem,book3);
            admin1.addBook(mySystem,book4);
            admin1.addBook(mySystem,book5);
            admin1.addBook(mySystem,book6);
            admin1.addBook(mySystem,book7);

            //Admin delete book4 in system
            admin1.deleteBook(mySystem,book4);
            //update a book location
            admin1.update(mySystem,book2,"c3s3.123");
            //user search a book with parameter name of the book
            user1.searchBook(mySystem,"Harry Potter Ates Kadehi");
            System.out.println();
            //user search a book with parameter name of the author
            user1.searchBook(mySystem,"Tolkien");
        }catch (IllegalArgumentException x){
            System.out.println("Admin must enter system!");
        }

    }
}
