import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordLinkedListTest {

    @Test
    void addCross() {
        WordLinkedList word1=new WordLinkedList("SNAKES");
        word1.addCross("LION",1,3);
        assertEquals("Main Word:\nSNAKES\nCrossWords:\nLION --- Crossed index: 3 Crossed main Index:1\n",word1.Print());
    }

    @Test
    void addMainWord() {
        WordLinkedList word1=new WordLinkedList("SNAKES");
        WordLinkedList word2=new WordLinkedList("OKAY");
        word1.addMainWord(word2,3,1);
        assertEquals("Main Word:\nSNAKES\nCrossWords:\nOKAY --- Crossed index: 1 Crossed main Index:3\n",word1.Print());
        assertEquals("Main Word:\nOKAY\nCrossWords:\nSNAKES --- Crossed index: 3 Crossed main Index:1\n",word2.Print());
    }

    @Test
    void removeCross() {
        WordLinkedList word1=new WordLinkedList("SNAKES");
        word1.addCross("ENABLE",4,0);
        word1.RemoveCross(4);
        assertEquals("Main Word:\nSNAKES\nCrossWords:\n",word1.Print());
    }

    @Test
    void removeAllCross() {
        WordLinkedList word1=new WordLinkedList("SNAKES");
        word1.addCross("ENABLE",4,0);
        word1.addCross("ACKNOWLEDGE",2,0);
        word1.RemoveAllCross();
        assertEquals("Main Word:\nSNAKES\nCrossWords:\n",word1.Print());
    }

    @Test
    void print() {
        WordLinkedList word1=new WordLinkedList("HUMAN");
        word1.addCross("ALIAN",3,0);
        word1.addCross("UNIVERSE",1,0);
        assertEquals("Main Word:\nHUMAN\nCrossWords:\nUNIVERSE --- Crossed index: 0 Crossed main Index:1\nALIAN --- Crossed index: 0 Crossed main Index:3\n",word1.Print());
    }
}