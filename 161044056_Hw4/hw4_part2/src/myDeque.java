
import java.util.*;

public class myDeque<E> extends AbstractCollection<E> implements Deque<E> {

    //Deque list head and tail
    private Node<E> head=null;
    private Node<E> tail=null;
    //size
    private int size=0;
    //Head and tail for removed nodes link list
    private Node<E> removed_nodes_head=null;
    private Node<E> removed_nodes_tail=null;
    //removed nodes list size
    private int size_removed_nodes=0;

    //my Node class
    private static class Node<E>{
        private E data;
        private Node<E> next;
        private Node<E> prev;

        public Node(){
            next=null;
            prev=null;
        }
    }

    //my Iterator class
    private class myIterator implements Iterator<E>{
        private Node<E> iterHead=head;

        /**
         * check there is still node in structure
         * @return if there is still element return true,if not return false
         */
        @Override
        public boolean hasNext() {
            return iterHead!=null;
        }

        /**
         * return iterator node and move iterator next position
         * @return iterator node data
         */
        @Override
        public E next() {
            E temp=iterHead.data;
            iterHead=iterHead.next;
            return temp;
        }

        /**
         * remove node which iterator points
         */
        @Override
        public void remove() {
            iterHead.prev=iterHead.next;
            if(iterHead.next!=null){
                iterHead.next.prev=iterHead.prev;
            }
            iterHead.next=null;
            iterHead.prev=null;
        }

    }


    /**
     * add element to head of the deque
     * if removed_nodes link list has some nodes than use this nodes for adding node not create a new node.
     * if removed_node is empty then create a new node
     * @param e adding data
     */
    @Override
    public void addFirst(E e) {
        //Not create A new node
        if(size_removed_nodes!=0){
            //fill this
            Node<E> temp=removed_nodes_head;
            removed_nodes_head=temp.next;
            size_removed_nodes--;
            if(size_removed_nodes!=0)removed_nodes_head.prev=null;

            temp.data=e;
            if(head==null){
                temp.next=null;
                temp.prev=null;
                head=temp;
                tail=temp;
            }
            else{
                temp.next=head;
                temp.next.prev=temp;
                temp.prev=null;
                head=temp;
            }
            size++;
        }
        else{
            Node<E> temp=new Node<>();
            temp.data=e;
            if(head==null){
                temp.next=null;
                temp.prev=null;
                head=temp;
                tail=temp;
                size++;
            }
            else{
                temp.next=head;
                temp.next.prev=temp;
                temp.prev=null;
                head=temp;
                size++;
            }
        }
    }

    /**
     * Add element to the tail of the deque
     * if removed_nodes link list has some nodes than use this nodes for adding node not create a new node.
     * if removed_node is empty then create a new node
     * @param e added data
     */
    @Override
    public void addLast(E e) {
        if(size_removed_nodes!=0){
            Node<E> temp=removed_nodes_head;
            removed_nodes_head=temp.next;
            size_removed_nodes--;
            if(size_removed_nodes!=0)removed_nodes_head.prev=null;
            temp.data=e;
            if(head==null){
                temp.next=null;
                head=temp;
                tail=temp;
                temp.prev=null;
            }
            else{
                temp.next=null;
                tail.next=temp;
                temp.prev=tail;
                tail=temp;
            }

            size++;
        }
        else{
            Node<E> temp=new Node<>();
            temp.data=e;
            if(head==null){
                temp.next=null;
                head=temp;
                tail=temp;
                temp.prev=null;
                size++;
            }
            else{
                temp.next=null;
                tail.next=temp;
                temp.prev=tail;
                tail=temp;
                size++;
            }

        }
    }

    /**
     * add element to head of the deque
     * if removed_nodes link list has some nodes than use this nodes for adding node not create a new node.
     * if removed_node is empty then create a new node
     * Difference between addfirst element is only offerfirst return a boolean
     * @param e added element
     * @return return true if element added,otherwise return false
     */
    @Override
    public boolean offerFirst(E e) {
        int check=size;
        if(size_removed_nodes!=0){
            Node<E> temp=removed_nodes_head;
            removed_nodes_head=temp.next;
            size_removed_nodes--;
            if(size_removed_nodes!=0)removed_nodes_head.prev=null;

            temp.data=e;
            if(head==null){
                temp.next=null;
                head=temp;
                tail=temp;
                temp.prev=null;
            }
            else{
                temp.next=head;
                temp.next.prev=temp;
                temp.prev=null;
                head=temp;
            }
            size++;


        }
        else{
            Node<E> temp=new Node<>();
            temp.data=e;
            if(head==null){
                temp.next=null;
                head=temp;
                tail=temp;
                temp.prev=null;
                size++;
            }
            else{
                temp.next=head;
                temp.next.prev=temp;
                temp.prev=null;
                head=temp;
                size++;
            }

        }
        if(check==size){
            return false;
        }
        else{
            return true;
        }

    }

    /**
     * Add element to the tail of the deque
     * if removed_nodes link list has some nodes than use this nodes for adding node not create a new node.
     * if removed_node is empty then create a new node
     * @param e
     * @return
     */
    @Override
    public boolean offerLast(E e) {
        int check=size;
        if(size_removed_nodes!=0){
            Node<E> temp=removed_nodes_head;
            removed_nodes_head=temp.next;
            size_removed_nodes--;
            if(size_removed_nodes!=0)removed_nodes_head.prev=null;

            temp.data=e;

            if(head==null){
                temp.next=null;
                head=temp;
                tail=temp;
                temp.prev=null;
            }
            else{
                temp.next=null;
                tail.next=temp;
                temp.prev=tail;
                tail=temp;
            }


            size++;
        }
        else{
            Node<E> temp=new Node<>();
            temp.data=e;
            if(head==null){
                temp.next=null;
                head=temp;
                tail=temp;
                temp.prev=null;
                size++;
            }
            else{
                temp.next=null;
                tail.next=temp;
                temp.prev=null;
                tail=temp;
                size++;
            }
        }
        if(check==size){
            return false;
        }
        else{
            return true;
        }
    }

    /**
     * Remove first element in Deque and add this removed node to removed_node list
     * @return return removed data
     */
    @Override
    public E removeFirst() {
        E return_data;
        if(size==0){
            throw new NoSuchElementException();
        }
        else{
            Node<E> temp=head;
            return_data=temp.data;
            head=temp.next;
            head.prev=null;
            temp.next=null;
            size--;

            if(removed_nodes_head==null){
                removed_nodes_head=temp;
                removed_nodes_tail=temp;
                temp.prev=null;
                size_removed_nodes++;
            }
            else{
                temp.next=removed_nodes_head;
                temp.prev=null;
                removed_nodes_head=temp;
                size_removed_nodes++;
            }
        }

        return return_data;
    }

    /**
     * Remove last element(tail) of deque and add this node to removed_nodes list
     * @return return removed node data
     */
    @Override
    public E removeLast() {
        E return_data;
        if(size==0){
            throw new NoSuchElementException();
        }
        else{
            Node<E> temp=head;
            while(temp.next!=tail){
                temp=temp.next;
            }
            tail=temp;
            temp=temp.next;
            tail.next=null;
            return_data=temp.data;
            size--;

            if(removed_nodes_head==null){
                removed_nodes_head=temp;
                removed_nodes_tail=temp;
                temp.next=null;
                temp.prev=null;
                size_removed_nodes++;
            }
            else{
                temp.next=removed_nodes_head;
                temp.prev=null;
                removed_nodes_head=temp;
                size_removed_nodes++;
            }
        }


        return return_data;
    }

    /**
     * remove first element of deque and add this node to removed_nodes list
     * difference between remove pollfirst return null if deque empty but removefirst throw excaption.
     * @return return removed nodes data
     */
    @Override
    public E pollFirst() {
        if(size==0){
            return null;
        }

        E return_data;

        Node<E> temp=head;
        return_data=temp.data;
        head=temp.next;
        temp.next=null;
        size--;

        if(removed_nodes_head==null){
            removed_nodes_head=temp;
            removed_nodes_tail=temp;
            temp.prev=null;
            size_removed_nodes++;
        }
        else{
            temp.next=removed_nodes_head;
            temp.prev=null;
            removed_nodes_head=temp;
            size_removed_nodes++;
        }

        return return_data;

    }

    /**
     * remove last node(tail) of the deque and add node to removed_nodes list
     * @return removed nodes data
     */
    @Override
    public E pollLast() {
        if(size==0){
            return null;
        }
        E return_data;

        Node<E> temp=head;
        while(temp.next!=tail){
            temp=temp.next;
        }
        tail=temp;
        temp=temp.next;
        tail.next=null;
        return_data=temp.data;
        size--;

        if(removed_nodes_head==null){
            removed_nodes_head=temp;
            removed_nodes_tail=temp;
            temp.next=null;
            temp.prev=null;
            size_removed_nodes++;
        }
        else{
            temp.next=removed_nodes_head;
            temp.prev=null;
            removed_nodes_head=temp;
            size_removed_nodes++;
        }

        return return_data;
    }

    /**
     * return first nodes data,if deque is empty than throw excaption
     * @return first nodes data
     */
    @Override
    public E getFirst() {
        if(size==0){
            throw new NoSuchElementException();
        }
        return head.data;
    }

    /**
     * return last nodes data,if deque is empty than throw excaption
     * @return last node data
     */
    @Override
    public E getLast() {
        if(size==0){
            throw new NoSuchElementException();
        }
        return tail.data;
    }

    /**
     * return first nodes data without removing it
     * if deque is empty return null
     * @return first node data
     */
    @Override
    public E peekFirst() {
        if(size==0) return null;
        return head.data;
    }

    /**
     * return last nodes data without removing it
     * if deque is empty return null
     * @return
     */
    @Override
    public E peekLast() {
        if(size==0) return null;
        return tail.data;
    }

    /**
     * remove first occurence object o in deque
     * @param o removed object
     * @return if object cant found return false,otherwise return true
     */
    @Override
    public boolean removeFirstOccurrence(Object o) {
        if(size==0) return false;
        Node<E> temp=head;
        if(size==1){
            if(temp.data==o){
                head=null;
                tail=null;
                size--;
                return true;
            }
            else{
                return false;
            }
        }
        int flag=0;
        while(temp!=null){
            if(temp.data==o){

                if(temp.prev==null){//if element in first position
                    head=temp.next;
                    head.prev=null;
                }
                else if(temp.next==null){//if element in last position
                    temp.prev.next=null;
                    temp.prev=null;
                }
                else{
                    temp.prev.next=temp.next;
                    temp.next.prev=temp.prev;
                }
                flag=1;
                size--;
                break;
            }
            temp=temp.next;
        }

        if(flag==1) return true;
        return false;
    }

    /**
     * remove last occurence object o in deque
     * @param o removed object
     * @return if object cant found return false,otherwise return true
     */
    @Override
    public boolean removeLastOccurrence(Object o) {
        if(size==0) return false;
        Node<E> temp=tail;
        if(size==1){
            if(temp.data==o){
                tail=null;
                head=null;
                size--;
            }
            else{
                return false;
            }
        }
        int flag=0;
        while(temp!=null){
            if(temp.data==o){
                if(temp.next==null){//last position
                    tail=temp.prev;
                    temp.prev.next=null;
                    temp.prev=null;
                    temp.next=null;
                }
                else if(temp.prev==null){//head position
                    head=temp.next;
                    head.prev=null;
                    temp.next=null;
                    temp.prev=null;
                }
                else{//somewhere between head and tail but not them
                    temp.prev.next=temp.next;
                    temp.next.prev=temp.prev;
                    temp.next=null;
                    temp.prev=null;
                }
                size--;
                flag=1;
                break;
            }
            temp=temp.prev;
        }

        if(flag==1) return true;
        return false;
    }



    /**
     * add element at the beginning(head) of the deque
     *
     * @param e added element
     * @return if element added return true otherwise return false
     */
    @Override
    public boolean offer(E e) {
        boolean x=offerFirst(e);
        if(x) return true;
        return false;
    }

    /**
     * remove node at the beginning(head) of the deque.
     * add removed node to removed_nodes list
     * @return return removed node data
     */
    @Override
    public E remove() {
        E return_data;
        if(size==0){
            throw new NoSuchElementException();
        }
        else{
            Node<E> temp=head;
            return_data=temp.data;
            head=temp.next;
            head.prev=null;
            temp.next=null;
            size--;

            if(removed_nodes_head==null){
                removed_nodes_head=temp;
                removed_nodes_tail=temp;
                temp.prev=null;
                size_removed_nodes++;
            }
            else{
                temp.next=removed_nodes_head;
                temp.prev=null;
                removed_nodes_head=temp;
                size_removed_nodes++;
            }
        }

        return return_data;
    }

    /**
     * remove first element at the beginning(head) of the deque
     * add removed node to removed_nodes list
     * @return if deque empty return null or first element
     */
    @Override
    public E poll() {
        if(size==0) return null;
        return pollFirst();
    }

    /**
     * return first element of the deque
     * @return if deque is empty throw Exception
     */
    @Override
    public E element() {
        if(size==0) throw new NoSuchElementException();
        return head.data;
    }

    /**
     * return first element of the deque
     * @return if deque is empty return null
     */
    @Override
    public E peek() {
        if(size==0) return null;
        return head.data;
    }

    /**
     * make deque is empty
     */
    @Override
    public void clear() {
        head=null;
        tail=null;
        size=0;
    }

    /**
     * add element at the beginning of the deque
     * dont return anything
     * @param e added element
     */
    @Override
    public void push(E e) {
        offerFirst(e);
    }

    /**
     * remove first element from the deque
     * add removed node to removed_nodes list
     * @return removed node data
     */
    @Override
    public E pop() {
        return pollFirst();
    }

    /**
     * remove object o from the deque
     * @param o removed argument
     * @return if deque empty or object cant found return false,otherwise return tru
     */
    @Override
    public boolean remove(Object o) {
        if(size==0) return false;
        removeFirstOccurrence(o);
        return true;
    }

    /**
     *
     * @return return deque size
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Check deque is empty or not
     * @return if deque empty return true,otherwise false
     */
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    /**
     * return a iterator for my structure
     * @return myIterator that I implement for iterate my list
     */
    @Override
    public Iterator<E> iterator() {
        myIterator myIter=new myIterator();
        myIter.iterHead=head;
        return myIter;
    }

    /**
     * I implement descendingITerator but I didnt use this because my Iterator implements Iterator interface
     * so there is not a previous or hasPrevious method,Because of this descendingIteraot only point last node cant go reverse direction
     * @return
     */
    @Override
    public Iterator<E> descendingIterator() {
        myIterator myReverseIter=new myIterator();
        myReverseIter.iterHead=tail;
        return myReverseIter;
    }


    /**
     * Check if given argument in the deque or not
     * @param o given argument
     * @return if deque has argument return true,otherwise false
     */
    @Override
    public boolean contains(Object o) {
        Node<E> temp=head;
        while(temp!=null){
            if(temp.data==o) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        Node<E> temp=head;
        StringBuilder result=new StringBuilder();
        while(temp!=null){
            result.append(temp.data+"\n");
            temp=temp.next;
        }
        return result.toString();
    }
}
