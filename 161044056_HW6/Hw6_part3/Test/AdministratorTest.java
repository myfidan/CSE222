import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class AdministratorTest {

    @Test
    void enterSystem() {
        LibrarySystem mySystem= new LibrarySystem();
        Administrator admin=new Administrator("mehmet","aslan");
        admin.enterSystem(mySystem,"123@pass");
        assertTrue(admin.getInSystemInfo());
    }

    @Test
    void enterSystemFail(){
        LibrarySystem mySystem= new LibrarySystem();
        Administrator admin=new Administrator("mehmet","aslan");
        admin.enterSystem(mySystem,"wrongpass");
        assertFalse(admin.getInSystemInfo());
    }

    @Test
    void update() {

        LibrarySystem mySystem= new LibrarySystem();
        Administrator admin=new Administrator("mehmet","aslan");
        admin.enterSystem(mySystem,"123@pass");
        Book book1=new Book("Tolkien","LOTR","c3s5.1534");
        admin.addBook(mySystem,book1);
        admin.update(mySystem,book1,"c1s1.111");
        assertEquals(book1.BookLocation,"c1s1.111");
    }

    @Test
    void addBook() {
        LibrarySystem mySystem= new LibrarySystem();
        Administrator admin=new Administrator("mehmet","aslan");
        admin.enterSystem(mySystem,"123@pass");
        Book book1=new Book("Tolkien","LOTR","c3s5.1534");
        admin.addBook(mySystem,book1);
        Iterator x=mySystem.BookMap.get("Tolkien").get("LOTR").iterator();
        assertEquals(x.next(),"c3s5.1534");
    }

    @Test
    void deleteBook() {
        LibrarySystem mySystem= new LibrarySystem();
        Administrator admin=new Administrator("mehmet","aslan");
        admin.enterSystem(mySystem,"123@pass");
        Book book1=new Book("Tolkien","LOTR","c3s5.1534");
        admin.addBook(mySystem,book1);
        admin.deleteBook(mySystem,book1);
        assertEquals(mySystem.BookMap.get("Tolkien").size(),0);
    }
}