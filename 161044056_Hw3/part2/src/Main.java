import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {


        System.out.println("---ARRAYLIST ITERATOR IMPLEMENTATION---");
        SimpleTextEditorArrayList test_arraylist_iterator=new SimpleTextEditorArrayList();
        test_arraylist_iterator.ReadIterator();

        for(int i=0; i<test_arraylist_iterator.getText().size(); i++){
            System.out.print(test_arraylist_iterator.getText().get(i));
        }
        System.out.println("\n\nAddITerator methodu ile verilen indexe yeni string ekledi:");

        test_arraylist_iterator.AddIterator("123",6);

        for(int i=0; i<test_arraylist_iterator.getText().size(); i++){
            System.out.print(test_arraylist_iterator.getText().get(i));
        }
        System.out.println("\n\nReplaceIterator methodu ile character arraylisti degistirildi.:");
        test_arraylist_iterator.ReplaceIterator('a','i');

        for(int i=0; i<test_arraylist_iterator.getText().size(); i++){
            System.out.print(test_arraylist_iterator.getText().get(i));
        }
        System.out.println("\nVerilen String bulundu indexi:"+test_arraylist_iterator.FindIterator("bu"));
        System.out.println();



/*

        System.out.println("\n---LINKLIST ITERATOR IMPLEMENTATION---");
        SimpleTextEditorLinkList test_linklist_iterator=new SimpleTextEditorLinkList();
        test_linklist_iterator.ReadIterator();

        for(int i=0; i<test_linklist_iterator.getText().size(); i++){
            System.out.print(test_linklist_iterator.getText().get(i));
        }
        System.out.println("\n\nAddITerator methodu ile verilen indexe yeni string ekledi:");

        test_linklist_iterator.AddIterator("123",6);

        for(int i=0; i<test_linklist_iterator.getText().size(); i++){
            System.out.print(test_linklist_iterator.getText().get(i));
        }
        System.out.println("\n\nReplaceIterator methodu ile character arraylisti degistirildi.:");
        test_linklist_iterator.ReplaceIterator('a','i');

        for(int i=0; i<test_linklist_iterator.getText().size(); i++){
            System.out.print(test_linklist_iterator.getText().get(i));
        }
        System.out.println("\nVerilen String bulundu indexi:"+test_linklist_iterator.FindIterator("bu"));
        System.out.println();
*/

/*


        System.out.println("\n---ARRAYLIST LOOP IMPLEMENTATION---");
        SimpleTextEditorArrayList test_arraylist_loop=new SimpleTextEditorArrayList();
        test_arraylist_loop.Read();

        for(int i=0; i<test_arraylist_loop.getText().size(); i++){
            System.out.print(test_arraylist_loop.getText().get(i));
        }
        System.out.println("\n\nAddITerator methodu ile verilen indexe yeni string ekledi:");

        test_arraylist_loop.Add("123",6);

        for(int i=0; i<test_arraylist_loop.getText().size(); i++){
            System.out.print(test_arraylist_loop.getText().get(i));
        }
        System.out.println("\n\nReplaceIterator methodu ile character arraylisti degistirildi.:");
        test_arraylist_loop.Replace('a','i');

        for(int i=0; i<test_arraylist_loop.getText().size(); i++){
            System.out.print(test_arraylist_loop.getText().get(i));
        }
        System.out.println("\nVerilen String bulundu indexi:"+test_arraylist_loop.Find("bu"));
        System.out.println();
*/


/*
        System.out.println("\n---LINKLIST LOOP IMPLEMENTATION---");
        SimpleTextEditorLinkList test_linklist_loop=new SimpleTextEditorLinkList();
        test_linklist_loop.Read();

        for(int i=0; i<test_linklist_loop.getText().size(); i++){
            System.out.print(test_linklist_loop.getText().get(i));
        }
        System.out.println("\n\nAddITerator methodu ile verilen indexe yeni string ekledi:");

        test_linklist_loop.Add("123",6);

        for(int i=0; i<test_linklist_loop.getText().size(); i++){
            System.out.print(test_linklist_loop.getText().get(i));
        }
        System.out.println("\n\nReplaceIterator methodu ile character arraylisti degistirildi.:");
        test_linklist_loop.Replace('a','i');

        for(int i=0; i<test_linklist_loop.getText().size(); i++){
            System.out.print(test_linklist_loop.getText().get(i));
        }
        System.out.println("\nVerilen String bulundu indexi:"+test_linklist_loop.Find("bu"));
        System.out.println();

        */

    }
}
