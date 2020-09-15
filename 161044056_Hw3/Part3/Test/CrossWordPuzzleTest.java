import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrossWordPuzzleTest {

    @Test
    void add() {
        WordLinkedList word1=new WordLinkedList("KNOWLEDGE");
        word1.addCross("EDGE",5,0);
        WordLinkedList word2=new WordLinkedList("SCIENCE");
        word2.addCross("SNAKE",0,0);
        word1.addMainWord(word2,8,3);

        CrossWordPuzzle myPuzzle=new CrossWordPuzzle();
        myPuzzle.Add(word1);
        myPuzzle.Add(word2);

        assertEquals("Main Word:\nKNOWLEDGE\nCrossWords:\nEDGE --- Crossed index: 0 Crossed main Index:5\nSCIENCE ---" +
                " Crossed index: 3 Crossed main Index:8\nMain Word:\nSCIENCE\nCrossWords:\nSNAKE --- Crossed index: 0 Crossed main Index:0\n" +
                "KNOWLEDGE --- Crossed index: 8 Crossed main Index:3\n",myPuzzle.Print());
    }

    @Test
    void remove() {
        WordLinkedList word1=new WordLinkedList("KNOWLEDGE");
        word1.addCross("EDGE",5,0);
        WordLinkedList word2=new WordLinkedList("SCIENCE");
        word2.addCross("SNAKE",0,0);
        word1.addMainWord(word2,8,3);

        CrossWordPuzzle myPuzzle=new CrossWordPuzzle();
        myPuzzle.Add(word1);
        myPuzzle.Add(word2);
        myPuzzle.Remove(word2);

        assertEquals("Main Word:\nKNOWLEDGE\nCrossWords:\nEDGE --- Crossed index: 0 Crossed main Index:5\n",myPuzzle.Print());

    }
}