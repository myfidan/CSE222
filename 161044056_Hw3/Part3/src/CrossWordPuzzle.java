import java.util.ArrayList;
import java.util.List;

public class CrossWordPuzzle {
    private List<WordLinkedList> WordLK=new ArrayList<>();

    /**
     * add word to the WordLİnkedList WordLK
     * @param word added word
     */
    public void Add(WordLinkedList word){
        WordLK.add(word);
    }

    /**
     * Remove a word from the list
     * @param word removed word
     */
    public void Remove(WordLinkedList word){
        word.RemoveAllCross();
        WordLK.remove(word);
    }

    /**
     * print all Words and theire Crosses
     */
    public String Print(){
        StringBuilder result =new StringBuilder();
        for(int i=0; i<WordLK.size(); i++){
            result.append(WordLK.get(i).Print());
        }
        return result.toString();
    }
}
