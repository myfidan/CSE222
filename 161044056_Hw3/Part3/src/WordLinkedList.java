public class WordLinkedList {
    private Node head=null;
    private Node tail=null;
    private int size=0;

    /**
     * Static inner Node class
     * for link list nodes
     */
    private static class Node{
        private Character data;
        private Node next;
        private Node prev;
        private Node cross;

        /**
         * No parameter constructer
         */
        public Node(){
            next=null;
            prev=null;
            cross=null;
        }

        /**
         * data parameter constructer
         * @param data Node Character
         */
        public Node(Character data){
            this.data=data;
            next=null;
            prev=null;
            cross=null;
        }

    }

    /**
     * The constructor which gets a string and constructs itself as WordLinkedList.
     * @param word paramater String
     */
    public WordLinkedList(String word){
        Character temp_char;
        for(int i=0; i<word.length(); i++){
            temp_char=word.charAt(i);
            Node temp=new Node();
            temp.data=temp_char;
            if(head==null){//if list empty
                head=temp;
                tail=temp;
                temp.next=null;
                temp.prev=null;
                temp.cross=null;
                size++;
            }
            else{
                temp.next=null;
                temp.prev=tail;
                tail.next=temp;
                tail=temp;
                size++;
            }
        }
    }

    /**
     * Add cross string to main words
     * @param OtherWord String
     * @param MainWordIndex int
     * @param OtherWordIndex int
     */
    public void addCross(String OtherWord,int MainWordIndex,int OtherWordIndex){
        Node otherWordHead=null;
        Node otherWordTail=null;

        for(int i=0; i<OtherWord.length(); i++){
            Node temp=new Node();
            temp.data=OtherWord.charAt(i);
            if(otherWordHead==null){
                otherWordHead=temp;
                otherWordTail=temp;
                temp.next=null;
                temp.prev=null;
                temp.cross=null;
            }
            else{
                temp.next=null;
                temp.prev=otherWordTail;
                otherWordTail.next=temp;
                otherWordTail=temp;
            }
        }

        Node traveseOtherWord=otherWordHead;
        for(int i=0; i<OtherWordIndex; i++){
            traveseOtherWord=traveseOtherWord.next;
        }
        Node traverseMainWord=head;
        for(int i=0; i<MainWordIndex; i++){
            traverseMainWord=traverseMainWord.next;
        }

        traverseMainWord.cross=traveseOtherWord;
        traveseOtherWord.cross=traverseMainWord;
        size+=OtherWord.length()-1;

    }

    /**
     * combine main words
     * @param word2 WordLinkedList
     * @param MainIndex int
     * @param OtherIndex int
     */
    public void addMainWord(WordLinkedList word2,int MainIndex,int OtherIndex){
        Node temp=head;
        for(int i=0; i<MainIndex; i++){
            temp=temp.next;
        }
        Node temp2=word2.head;
        for(int i=0; i<OtherIndex; i++){
            temp2=temp2.next;
        }

        temp.cross=temp2;
        temp2.cross=temp;
    }

    /**
     * Remove index element crossed string from the main words
     * @param index int
     */
    public void RemoveCross(int index){
        Node temp=head;
        for(int i=0; i<index; i++){
            temp=temp.next;
        }
        temp.cross.cross=null;
        temp.cross=null;
    }

    /**
     * Remove All crosses from main word
     */
    public void RemoveAllCross(){
        Node temp=head;
        while(temp!=null){
            if(temp.cross!=null){
                temp.cross.cross=null;
                temp.cross=null;
            }
            temp=temp.next;
        }
    }

    /**
     * print words and their cross
     */
    public String Print(){
        StringBuilder result=new StringBuilder();
        System.out.println("Main Word:");
        result.append("Main Word:\n");
        Node tempMainWord=head;
        while(tempMainWord!=null){
            System.out.print(tempMainWord.data);
            result.append(tempMainWord.data);
            tempMainWord=tempMainWord.next;
        }
        System.out.println("\nCrossWords:");
        result.append("\nCrossWords:\n");

        tempMainWord=head;
        int MainWordCrossIndex=0;
        while(tempMainWord!=null){
            Node temp=tempMainWord;
            if(tempMainWord.cross!=null){
                tempMainWord=tempMainWord.cross;

                int otherWordCrossIndex=0;
                while(tempMainWord.prev!=null){
                    tempMainWord=tempMainWord.prev;
                    otherWordCrossIndex++;
                }

                while(tempMainWord!=null){
                    System.out.print(tempMainWord.data);
                    result.append(tempMainWord.data);
                    tempMainWord=tempMainWord.next;
                }
                System.out.print(" --- Crossed index: "+otherWordCrossIndex+" Crossed main Index:" +MainWordCrossIndex);
                System.out.println();
                result.append(" --- Crossed index: "+otherWordCrossIndex+" Crossed main Index:" +MainWordCrossIndex+"\n");
            }
            tempMainWord=temp;


            tempMainWord=tempMainWord.next;
            MainWordCrossIndex++;
        }
        return result.toString();
    }

    /**
     * override toString
     * it prints main word
     * @return main word
     */
    @Override
    public String toString() {
        StringBuilder result=new StringBuilder();
        Node temp=head;
        while(temp!=null){
            result.append(temp.data);
            result.append(" ");
            temp=temp.next;
        }
        return result.toString();
    }
}
