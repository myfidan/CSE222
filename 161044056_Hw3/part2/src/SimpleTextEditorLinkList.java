import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class SimpleTextEditorLinkList {
    private List<Character> Text=new LinkedList<>();

    /**
     * Linked list loop read
     * read input.txt and add every characters into the linkedlist
     * @throws IOException
     */
    public void Read() throws IOException {

        File fd=new File("input.txt");
        FileReader fr=new FileReader(fd);
        BufferedReader br=new BufferedReader(fr);
        int c=0;
        char character;
        while((c= br.read())!= -1){

            character=(char)c;
            if(character!='\r'){
                Text.add(character);
            }
        }

    }

    /**
     * List loop add method
     * Add given string into the given position in list
     * @param ekle given string
     * @param index given position
     */
    public void Add(String ekle,int index){

        for(int i=ekle.length()-1; i>-1; i--){
            Text.add(index,ekle.charAt(i));
        }
    }

    /**
     * linkedlist loop find method
     * Find the given string in the list
     * @param findingString given string
     * @return the position where the given string begin in list
     */
    public int Find(String findingString){

        for(int i=0; i<Text.size(); i++){
            if((findingString.length()+i)<=Text.size()){
                int check=0;
                for(int j=0; j<findingString.length(); j++){
                    if(findingString.charAt(j)!=Text.get(i+j)){
                        check=1;
                    }
                }
                if(check==0){
                    return i;
                }
            }
        }
        return 0;
    }

    /**
     * List replace loop method
     * Replace x character to y in list
     * @param x replaced character
     * @param y replace x by y
     */
    public void Replace(Character x,Character y){//replace all x characters to y character
        for(int i=0; i<Text.size(); i++){//O(n)
            if(Text.get(i)==x){//O(n)
                Text.set(i,y);//O(n)
            }
        }
    }

    /**
     * Linked list Iterator Read method
     * read the input.txt file and construct the my character list
     * @throws IOException
     */
    public void ReadIterator() throws IOException{
        File fd=new File("input.txt");
        FileReader fr=new FileReader(fd);
        BufferedReader br=new BufferedReader(fr);
        int c=0;
        char character;
        ListIterator<Character> iter=Text.listIterator();//Iterator
        while((c= br.read())!= -1){

            character=(char)c;
            if(character!='\r'){
                iter.add(character);//Iterator add O(1)
            }
        }
    }

    /**
     * Linked list Iterator Add method
     * Add given string into the given index
     * @param ekle string that will aded
     * @param index position that will added
     */
    public void AddIterator(String ekle,int index){

        ListIterator<Character> iter=Text.listIterator(index);

        for(int i=0; i<ekle.length(); i++){
            iter.add(ekle.charAt(i));
        }

    }

    /**
     * Find the given string in the linked list
     * @param findingString searching string
     * @return return the position where the findgingstring starts
     */
    public int FindIterator(String findingString){

        ListIterator<Character> iter=Text.listIterator();
        while(iter.hasNext()){
            int flag=0;
            for(int i=0; i<findingString.length(); i++){
                if(!iter.hasNext()){
                    return 0;//error
                }
                if(findingString.charAt(i)!=iter.next()){
                    flag=1;
                }
            }
            for(int i=0; i<findingString.length(); i++){
                iter.previous();
            }
            if(flag==0){
                return iter.nextIndex();
            }
            iter.next();
        }
        return 0;
    }

    /**
     * Linkedlist Replace Iterator method
     * Replace x by y character
     * @param x replaced character
     * @param y every x replaced by y
     */
    public void ReplaceIterator(Character x,Character y){//replace all x characters to y character
        ListIterator<Character> iter=Text.listIterator();
        while(iter.hasNext()){
            if(iter.next()==x){
                iter.set(y);
            }
        }
    }

    /**
     * return the linked list to use in main
     * like for print the list
     * @return my character list
     */
    public List<Character> getText() {
        return Text;
    }
}
