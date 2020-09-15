import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Administrator extends Person {
    private boolean inSystem;

    public Administrator(String name,String surname){
        super(name,surname);
        inSystem=false;
    }

    /**
     * Admin enter system with password if he/she enter the system succesfully,
     * admin can update,add,remove book form system
     * @param mySystem my system
     * @param password password I declare it in LibrarySystem class
     */
    public void enterSystem(LibrarySystem mySystem,String password){
        if(password.equals(mySystem.getPass())){
            this.inSystem=true;
        }
        else{
            this.inSystem=false;
            System.out.println("Wrong password!");
        }
    }

    /**
     * Admin can update a book location
     * @param mySystem
     * @param book
     * @param newLocation
     */
    public void update(LibrarySystem mySystem,Book book,String newLocation) throws IllegalArgumentException{
        if(!this.inSystem){
            System.out.println("Error,Please first enter system!");
            throw new IllegalArgumentException();
        }
        else{
            if(mySystem.BookMap.get(book.AuthorName).get(book.BookTitle).size()!=0){
                mySystem.BookMap.get(book.AuthorName).get(book.BookTitle).remove(book.BookLocation);
                mySystem.BookMap.get(book.AuthorName).get(book.BookTitle).add(newLocation);
                book.BookLocation=newLocation;
            }
            else{
                System.out.println("Can't find this book in system");
            }
        }
    }

    /**
     * Admin add book to the system
     * @param mySystem my system
     * @param book book that will added
     */
    public void addBook(LibrarySystem mySystem,Book book)throws IllegalArgumentException{
        if(!this.inSystem){
            System.out.println("Error,Please first enter system!");
            throw new IllegalArgumentException();
        }
        else{
            if(mySystem.BookMap.get(book.AuthorName)!=null){
                if(mySystem.BookMap.get(book.AuthorName).get(book.BookTitle)!=null){
                    mySystem.BookMap.get(book.AuthorName).get(book.BookTitle).add(book.BookLocation);
                }
                else{
                    mySystem.BookMap.get(book.AuthorName).put(book.BookTitle,new HashSet<>());
                    mySystem.BookMap.get(book.AuthorName).get(book.BookTitle).add(book.BookLocation);
                }
            }
            else{
                mySystem.BookMap.put(book.AuthorName,new HashMap<String, Set<String>>());
                mySystem.BookMap.get(book.AuthorName).put(book.BookTitle,new HashSet<>());
                mySystem.BookMap.get(book.AuthorName).get(book.BookTitle).add(book.BookLocation);
            }
        }

    }

    /**
     * Admin can delete book from system
     * @param mySystem my system
     * @param book book that will delete
     */
    public void deleteBook(LibrarySystem mySystem,Book book)throws IllegalArgumentException{
        if(!this.inSystem){
            System.out.println("Error,Please first enter system!");
            throw new IllegalArgumentException();
        }
        else{
            if(mySystem.BookMap.get(book.AuthorName).remove(book.BookTitle)==null){
                System.out.println("Can't delete,There is no book called "+book.BookTitle+ " in system");
            }
        }
    }

    /**
     * return inSystem info
     * @return return inSystem info
     */
    public boolean getInSystemInfo(){
        return inSystem;
    }

    @Override
    public String toString() {
        return "Admin info\nName: "+this.Name+"\nSurname: "+this.Surname+"\n";
    }
}
