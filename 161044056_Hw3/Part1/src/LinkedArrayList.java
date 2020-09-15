import java.util.*;

/**
 * LinkedArrayList is a new Data structure.
 * Its a double link list but every node has an array with constant capacity
 * @param <E> generic type class
 */
public class LinkedArrayList<E> extends AbstractList<E> implements List<E> {

    private Node<E> head=null;
    private Node<E> tail=null;
    private int size=0;

    /**
     * I used this class for link list node
     * it is a private inner static class
     * I declare this class static because I don't need access this class in LinkedArrayList
     * @param <E> generic type class
     */
    private static class Node<E>{
        private E[] arr;
        private int capacity=3;//my array has constant capacity,default capacity is 3 you can change it.
        private int size_arr=0;
        private Node<E> next;
        private Node<E> prev;

        /**
         * No parameter Node constructer
         */
        public Node(){
            arr=(E[])new Object[capacity];


            this.next=null;
            this.prev=null;
        }

        /**
         * Constructer with a Node paramter
         * @param temp Node parameter
         */
        public Node(Node<E> temp){
            arr=(E[])new Object[capacity];

            this.next=null;
            this.prev=temp;

        }

    }

    /**
     * This class is my Iterator for travese linkArrayList,add element or remove element.
     * it is implements ListIterator interface
     * @param <E> generic type class
     */
    private class myIterator<E> implements ListIterator<E>{

        private Node<E> iter;

        /**
         * Override from ListIterator Interface check next element null or not
         * @return False if next element is null otherwise true
         */
        @Override
        public boolean hasNext() {
            return iter.next!=null;
        }

        /**
         * Override from ListIterator Interface check prev element null or not
         * @return False if prev element is null otherwise true
         */
        @Override
        public boolean hasPrevious() {
            return iter.prev!=null;
        }

        /**
         * Override from listIterator Interface
         * move my iterator next node and return this nodes array last item
         * @return return last array item in that node
         */
        @Override
        public E next() {
            iter=iter.next;
            if(iter.size_arr!=0) return iter.arr[iter.size_arr-1];
            return null;
        }

        /**
         * Override from listIterator Interface
         * move my iterator prev node and return this nodes array last item
         * @return return last array item in that node
         */
        @Override
        public E previous() {
            iter=iter.prev;
            if(iter.size_arr!=0) return iter.arr[iter.size_arr-1];
            return null;
        }

        /**
         * override from listIterator Interface
         * set node array last element
         * @param e set parameter
         */
        @Override
        public void set(E e) {
            iter.arr[iter.size_arr]=e;
        }

        /**
         * just return 0 I dont need this method and didnt used
         * @return just return 0
         */
        @Override
        public int nextIndex() {
            return 0;
        }

        /**
         * just return 0 I dont need this method and didnt used
         * @return just return 0
         */
        @Override
        public int previousIndex() {
            return 0;
        }

        /**
         * add an element to nodes array where iterator points
         * @param e
         */
        @Override
        public void add(E e) {
            iter.arr[iter.size_arr]=e;
            iter.size_arr++;

        }

        /**
         * remove o paremeter from linkedArrayList
         * It traverse the list from the head to tail and looking for find object o
         * when it finds an o element in a array it deletes this element and shift this arrays elements
         * other arrays not effected
         * @param o
         */
        public void remove(Object o){
            int flag=0;
            myIterator myIter=Iterator();
            while(myIter.iter!=null){
                for(int i=0; i<myIter.iter.size_arr; i++){
                    if(myIter.iter.arr[i]==o){
                        for(int j=i; j<myIter.iter.capacity-1; j++){
                            myIter.iter.arr[j]=myIter.iter.arr[j+1];
                        }
                        myIter.iter.size_arr--;
                        flag=1;

                        if(myIter.iter.size_arr==0){
                            size--;
                            if(myIter.iter==head){
                                head=myIter.iter.next;
                                if(head!=null){
                                    myIter.iter.next.prev=null;
                                }
                                else{
                                    tail=null;
                                }
                            }
                            else if(myIter.iter==tail){
                                tail=myIter.iter.prev;
                                myIter.iter.prev.next=null;
                            }
                            else{
                                myIter.iter.prev.next=myIter.iter.next;
                                myIter.iter.next.prev=myIter.iter.prev;
                            }
                        }
                        break;
                    }
                }
                if(flag==1) break;
                myIter.iter=myIter.iter.next;
            }
            if(flag==0){//there is no element for remove so an exception will be throw
                throw new NoSuchElementException();
            }
        }

        /**
         *Hence,I use remove(object o) I didn't need this remove method because I can't use
         * no parameter remove method in my data structure,but I must override it because ListIterator
         * implemented
         */
        @Override
        public void remove() {

        }
    }

    /**
     * return head ref
     * @return head node
     */
    public Node<E> getHead() {
        return head;
    }

    /**
     * add element to arrays last position
     * if array full then create a new node and add element to this nodes array
     * I dont declare a create node method for this data structure, add method
     * must be used if arrays became full automatically new node created
     * @param e added element
     * @return true always
     */
    @Override
    public boolean add(E e) {


        if(size==0){
            addNode();
        }
        //Node<E> iter=head;
        myIterator myIter=Iterator();
        while(myIter.hasNext()){
            myIter.next();
        }

        if(myIter.iter.size_arr==myIter.iter.capacity){
            addNode();
            myIter.next();
            //add node
        }

        myIter.add(e);


        return true;
    }

    /**
     * go to Indexed node and add element to this nodes array
     * if this array alreay full then create a new node and add element to this node
     * @param NodeIndex Node index
     * @param data added element
     */
    @Override
    public void add(int NodeIndex, E data){
        if(NodeIndex<0 || NodeIndex>size){

            throw new IndexOutOfBoundsException();
        }

        if(size==0){
            addNode();
        }
        myIterator myIter=Iterator();
        for(int i=0; i<NodeIndex; i++){
            myIter.next();
        }

        if(myIter.iter.size_arr==myIter.iter.capacity){
            addNode();
            myIter.iter=tail;
        }
        myIter.add(data);

    }

    /**
     * traverse list arrays and remove element from first occurence and shift other array elements
     * other arrays do not affected
     * @param o removed element
     * @return return true or throws an excaption if list doesnt have an o object
     */
    @Override
    public boolean remove(Object o) {

        //Node<E> temp=head;
        myIterator myIter=Iterator();
        myIter.remove(o);
        return true;
    }

    /**
     * This remove take index and delete the element in that position and shift corresponding array
     * @param index position that will be removed
     * @return return null
     */
    @Override
    public E remove(int index) {

        myIterator myIter=Iterator();
        int count=0;
        int flag=0;
        while(myIter.iter!=null){
            for(int i=0; i<myIter.iter.size_arr; i++){
                if(count==index){
                    for(int j=i; j<myIter.iter.size_arr-1; j++){
                        myIter.iter.arr[j]=myIter.iter.arr[j+1];
                    }
                    myIter.iter.size_arr--;
                    flag=1;
                    if(myIter.iter.size_arr==0){
                        //remove node
                        size--;
                        if(myIter.iter==head){
                            head=myIter.iter.next;
                            if(head!=null){
                                myIter.iter.next.prev=null;
                            }
                            else{
                                tail=null;
                            }
                        }
                        else if(myIter.iter==tail){
                            tail=myIter.iter.prev;
                            myIter.iter.prev.next=null;
                        }
                        else{
                            myIter.iter.prev.next=myIter.iter.next;
                            myIter.iter.next.prev=myIter.iter.prev;
                        }
                    }
                }
                if(flag==1){
                    break;
                }
                count++;
            }
            if(flag==1){
                break;
            }
            myIter.next();
        }
        return null;
    }

    /**
     * Create a node
     */
    public void addNode(){
        Node<E> temp=new Node<E>();
        if(size==0){
            temp.next=null;
            temp.prev=null;
            head=temp;
            tail=temp;
        }
        else{
            temp.next=null;
            temp.prev=tail;
            tail.next=temp;
            tail=temp;
        }
        size++;
    }

    /**
     * crete and return my iterator for my class
     * @return my iterator
     */
    public myIterator<E> Iterator(){
        myIterator<E> myIter=new myIterator<>();
        myIter.iter=head;
        return myIter;
    }

    /**
     * Print the list arrays
     * @return String
     */
    @Override
    public String toString(){
        StringBuilder printList=new StringBuilder();
        Node<E> temp=head;

        printList.append("List:\n");
        while(temp!=null){
            for(int i=0; i<temp.size_arr; i++){
               printList.append(temp.arr[i]);
               if(i!=temp.size_arr-1)
               printList.append(" ");
            }

            printList.append("\n");
            temp=temp.next;
        }

        return printList.toString();
    }

    /**
     * get last node array[index]
     * if index bigger than size throw excaption
     * @param index array index
     * @return return lastNode array[index]
     */
    @Override
    public E get(int index) {
        if(tail.size_arr>index){
            return tail.arr[index];
        }
        throw new IndexOutOfBoundsException();
    }

    /**
     * return list size
     * @return list size
     */
    @Override
    public int size() {
        return size;
    }

}
