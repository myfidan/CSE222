import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class SimpleTextEditorArrayList {
    private List<Character> Text=new ArrayList<>();

    /**
     * Arraylist loop read
     * Read input.txt into the character arraylist
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
     * ArrayList loop add
     * Its add the string to the given index position in arraylist
     * @param ekle String
     * @param index position
     */
    public void Add(String ekle,int index){

        for(int i=ekle.length()-1; i>-1; i--){
            Text.add(index,ekle.charAt(i));
        }
    }

    /**
     * Arraylist loop find
     * Find the given string and return its index
     * @param findingString find this index in arraylist
     * @return index
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
     * Array list loop Replace
     * Replace x with y in the Arraylist
     * @param x Replaced x
     * @param y x will Replaced with y
     */
    public void Replace(Character x,Character y){//replace all x characters to y character
        for(int i=0; i<Text.size(); i++){
            if(Text.get(i)==x){
                Text.set(i,y);
            }
        }
    }

    /**
     * Array list iterator read
     * read file in list
     * @throws IOException if file not found
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
     * Array list Iterator add method
     * Add given string into the given index position in list
     * @param ekle add this string
     * @param index the position where index will be added
     */
    public void AddIterator(String ekle,int index){

        ListIterator<Character> iter=Text.listIterator(index);

        for(int i=0; i<ekle.length(); i++){
            iter.add(ekle.charAt(i));//Iterator add O(1)
        }

    }

    /**
     * Array list find iterator method
     * Find the given string in the list
     * return the start position of the given string in list
     * @param findingString find this string
     * @return return beginning index of the given index
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
     * Array list iterator Replace method
     * Replace x character by y in list
     * @param x Replaced character
     * @param y x will be replaced by this character
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
     * For return the list to use in main
     * like print list
     * @return List itself
     */
    public List<Character> getText() {
        return Text;
    }
}
