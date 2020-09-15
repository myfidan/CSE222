public class Main {

    public static void main(String[] args) {

        /*
        WordLinkedList deneme=new WordLinkedList("PUZZLES");
        deneme.addCross("FUN",1,1);
        deneme.addCross("SNAKE",6,0);
        deneme.Print();

        System.out.println();
        deneme.RemoveCross(1);
        deneme.Print();
        */


        WordLinkedList word1=new WordLinkedList("PUZZLES");
        word1.addCross("FUN",1,1);
        WordLinkedList word2=new WordLinkedList("CROSSWORD");
        word2.addCross("ARE",1,1);

        word1.addMainWord(word2,6,4);

        CrossWordPuzzle myPuzzle=new CrossWordPuzzle();
        myPuzzle.Add(word1);
        myPuzzle.Add(word2);
        myPuzzle.Print();

        System.out.println();
        myPuzzle.Remove(word2);
        myPuzzle.Print();

    }
}
