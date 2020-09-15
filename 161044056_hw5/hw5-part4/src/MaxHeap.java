import java.util.ArrayList;
import java.util.Comparator;

public class MaxHeap<E> {
    //Arraylist Heap
    ArrayList<AgeData> heap;
    //comparator
    Comparator<AgeData> comparator=null;

    /**
     * No parameter constructer
     */
    public MaxHeap(){
        heap=new ArrayList<>();
    }

    /**
     * Comparator parameter constructer
     * @param comp
     */
    public MaxHeap(Comparator<AgeData> comp){
        heap=new ArrayList<>();
        comparator=comp;
    }

    /**
     * Compare method for compares AgeData objects
     * @param left
     * @param right
     * @return  return 0 if left and right equal,1 if right>left, -1 if right<left
     */
    private int compare(AgeData left, AgeData right){
        if(comparator != null){
            return comparator.compare(left,right);
        }
        else{
            return ((Comparable<AgeData>) left).compareTo(right);
        }
    }

    /**
     * Add AgeData elem to heap
     * @param elem
     */
    public void add(AgeData elem){

        int compVal;
        for(int i=0; i<heap.size(); i++){
            compVal = compare(heap.get(i),elem);
            if(compVal==0){
                heap.get(i).incrementNumber_age();
                int child=i;
                int parent=(i-1)/2;
                while(parent >= 0 && heap.get(parent).getNumber_age() < heap.get(child).getNumber_age()){
                    AgeData temp=new AgeData(heap.get(parent).getAge());
                    temp.setNumber_age(heap.get(parent).getNumber_age());
                    heap.get(parent).setAge(heap.get(child).getAge());
                    heap.get(parent).setNumber_age(heap.get(child).getNumber_age());
                    heap.get(child).setAge(temp.getAge());
                    heap.get(child).setNumber_age(temp.getNumber_age());

                    child=parent;
                    parent=(child-1)/2;
                }
                return;
            }
        }
        //There is not elem in list just add it
        heap.add(elem);
        int child=heap.size()-1;
        int parent=(child-1)/2;
        while(parent >= 0 && heap.get(parent).getNumber_age() < heap.get(child).getNumber_age()){
            AgeData temp=new AgeData(heap.get(parent).getAge());
            temp.setNumber_age(heap.get(parent).getNumber_age());
            heap.get(parent).setAge(heap.get(child).getAge());
            heap.get(parent).setNumber_age(heap.get(child).getNumber_age());
            heap.get(child).setAge(temp.getAge());
            heap.get(child).setNumber_age(temp.getNumber_age());

            child=parent;
            parent=(child-1)/2;
        }

    }

    /**
     * Remove elem from tree
     * @param elem
     */
    public void remove(AgeData elem){

        for(int i=0; i<heap.size(); i++){
            int comp=compare(heap.get(i),elem);

            if(comp==0){

                if(heap.get(i).getNumber_age()==1){

                    heap.get(i).setAge(heap.get(heap.size()-1).getAge());
                    heap.get(i).setNumber_age(heap.get(heap.size()-1).getNumber_age());
                    heap.remove(heap.size()-1);
                    if(i==heap.size()) break;
                    int node=i;
                    int nodes_parent=(i-1)/2;
                    int Lchild=2*node+1;
                    int Rchild=2*node+2;
                    //go down
                    if(heap.get(node).getNumber_age() < heap.get(nodes_parent).getNumber_age()){
                        while(Rchild<heap.size() && (heap.get(nodes_parent).getNumber_age()< heap.get(Lchild).getNumber_age() || heap.get(nodes_parent).getNumber_age()< heap.get(Rchild).getNumber_age())){
                            if(heap.get(Lchild).getNumber_age()<heap.get(Rchild).getNumber_age()){
                                heap.get(node).setAge(heap.get(Lchild).getAge());
                                heap.get(node).setNumber_age(heap.get(Lchild).getNumber_age());
                                node = Lchild;
                                Lchild=2*node+1;
                                Rchild=2*node+2;

                            }
                            else{
                                heap.get(node).setAge(heap.get(Rchild).getAge());
                                heap.get(node).setNumber_age(heap.get(Rchild).getNumber_age());
                                node = Rchild;
                                Lchild=2*node+1;
                                Rchild=2*node+2;
                            }
                        }
                    }
                    else{//go up
                        while(nodes_parent >= 0 && (heap.get(nodes_parent).getNumber_age() < heap.get(node).getNumber_age())){
                            AgeData temp=new AgeData(heap.get(nodes_parent).getAge());
                            temp.setNumber_age(heap.get(nodes_parent).getNumber_age());
                            heap.get(nodes_parent).setAge(heap.get(node).getAge());
                            heap.get(nodes_parent).setNumber_age(heap.get(node).getNumber_age());
                            heap.get(node).setAge(temp.getAge());
                            heap.get(node).setNumber_age(temp.getNumber_age());

                            node=nodes_parent;
                            nodes_parent=(node-1)/2;
                        }
                    }

                    break;
                }
                else{
                    heap.get(i).decrementNumber_age();
                    int parent = i;
                    int child1 = 2*i+1;
                    int child2 = 2*i+2;
                    while(child2 < heap.size() && (heap.get(parent).getNumber_age()<heap.get(child1).getNumber_age() || heap.get(parent).getNumber_age()<heap.get(child2).getNumber_age())){

                        if(heap.get(child1).getNumber_age()>heap.get(child2).getNumber_age()){
                            if(heap.get(parent).getNumber_age()<heap.get(child1).getNumber_age()){
                                AgeData temp=new AgeData(heap.get(parent).getAge());
                                temp.setNumber_age(heap.get(parent).getNumber_age());
                                heap.get(parent).setAge(heap.get(child1).getAge());
                                heap.get(parent).setNumber_age(heap.get(child1).getNumber_age());
                                heap.get(child1).setAge(temp.getAge());
                                heap.get(child1).setNumber_age(temp.getNumber_age());
                                parent=child1;
                                child1=2*parent+1;
                                child2=2*parent+2;
                            }
                        }
                        else{
                            if(heap.get(parent).getNumber_age()<heap.get(child2).getNumber_age()){
                                AgeData temp=new AgeData(heap.get(parent).getAge());
                                temp.setNumber_age(heap.get(parent).getNumber_age());
                                heap.get(parent).setAge(heap.get(child2).getAge());
                                heap.get(parent).setNumber_age(heap.get(child2).getNumber_age());
                                heap.get(child2).setAge(temp.getAge());
                                heap.get(child2).setNumber_age(temp.getNumber_age());
                                parent=child2;
                                child1=2*parent+1;
                                child2=2*parent+2;
                            }
                        }
                    }
                }
                break;
            }
        }
    }

    /**
     * Find elem in tree
     * @param elem
     * @return return found object
     */
    public AgeData find(AgeData elem){
        for(int i=0; i<heap.size(); i++){
            if(heap.get(i).getAge()==elem.getAge()){
                return heap.get(i);
            }
        }
        return null;
    }

    /**
     * Counte all node that has smaller age than compareAge and return count result
     * @param compareAge
     * @return count
     */
    public int youngerThan(int compareAge){
        int counter=0;
        for (int i=0; i<heap.size(); i++){
            if(heap.get(i).getAge()<compareAge)
                counter++;
        }
        return counter;
    }

    /**
     * Counte all node that has bigger age than compareAge and return count result
     * @param compareAge
     * @return count
     */
    public int olderThan(int compareAge){
        int counter=0;
        for(int i=0; i<heap.size(); i++){
            if (heap.get(i).getAge()>compareAge)
                counter++;
        }
        return counter;
    }

    /**
     * To string method for print heap
     * @return String
     */
    public String toString(){
        StringBuilder result=new StringBuilder();
        for(int i=0; i<heap.size(); i++){
            result.append(heap.get(i).getAge()+"-"+heap.get(i).getNumber_age()+"\n");
        }
        return result.toString();
    }


}
