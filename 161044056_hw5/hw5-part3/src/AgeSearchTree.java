public class AgeSearchTree<E extends Comparable<E>> extends BinarySearchTree<E> {
    private Node<AgeData> root;

    /**
     * No parameter constructer
     */
    public AgeSearchTree(){
        root=null;
    }


    /**
     * Override BinarySearchTree add method
     * for add AgeData element in my tree
     * @param item The object being inserted
     * @return  true if item inserted successfuly ,otherwise false
     */
    @Override
    public boolean add(Comparable item) {
        root=addWrap(root,item);
        return addReturn;
    }

    /**
     * A recursive wrapper function for add
     * @param localRoot root
     * @param item the object being inserted
     * @return return node
     */
    private Node<AgeData> addWrap(Node<AgeData> localRoot, Comparable item) {
        if (localRoot == null) {
            // item is not in the tree — insert it.
            addReturn = true;

            return new Node<AgeData>((AgeData) item);
        } else if (item.compareTo(localRoot.data) == 0) {
            // item is equal to localRoot.data
            localRoot.data.incrementNumber_age();
            addReturn = false;
            return localRoot;
        } else if (item.compareTo(localRoot.data) < 0) {
            // item is less than localRoot.data
            localRoot.left = addWrap(localRoot.left, item);
            return localRoot;
        } else {
            // item is greater than localRoot.data
            localRoot.right = addWrap(localRoot.right, item);
            return localRoot;
        }
    }

    /**
     * Override BinarySearchTree remove method for remove AgeData nodes in my tree
     * @param target İtem that will be removed
     * @return true if item removed successfuly, otherwise return false
     */
    @Override
    public boolean remove(Comparable target) {
        removeWrap(root,target);
        if(deleteReturn == null){
            return false;
        }
        else{
            return true;
        }
    }

    /**
     * Recursive wrapper function for my remove method
     * @param localRoot root
     * @param item removed item
     * @return Node
     */
    private Node<AgeData> removeWrap(Node<AgeData> localRoot, Comparable item) {
        if (localRoot == null) {
            // item is not in the tree.
            deleteReturn = null;
            return localRoot;
        }
        // Search for item to delete.
        int compResult = item.compareTo(localRoot.data);
        if (compResult < 0) {
            // item is smaller than localRoot.data.
            localRoot.left = removeWrap(localRoot.left, item);
            return localRoot;
        } else if (compResult > 0) {
            // item is larger than localRoot.data.
            localRoot.right = removeWrap(localRoot.right, item);
            return localRoot;
        } else {
            // item is at local root.
            Integer tut=localRoot.data.getAge();
            deleteReturn = (E)tut;
            if(localRoot.data.getNumber_age()>1){
                localRoot.data.decrementNumber_age();
                return localRoot;
            }
            if (localRoot.left == null) {
                // If there is no left child, return right child
                // which can also be null.
                return localRoot.right;
            } else if (localRoot.right == null) {
                // If there is no right child, return left child.
                return localRoot.left;
            } else {
                // Node being deleted has 2 children, replace the data
                // with inorder predecessor.
                if (localRoot.left.right == null) {
                    // The left child has no right child.
                    // Replace the data with the data in the
                    // left child.
                    localRoot.data = localRoot.left.data;
                    // Replace the left child with its left child.
                    localRoot.left = localRoot.left.left;
                    return localRoot;
                } else {
                    // Search for the inorder predecessor (ip) and
                    // replace deleted node's data with ip.
                    localRoot.data = findLargestChild(localRoot.left);
                    return localRoot;
                }
            }
        }
    }

    /**
     * This method same like in BinarySearchTree
     * I use this in my remove method for find greates left child for swapping
     * @param parent root
     * @return node
     */
    private AgeData findLargestChild(Node<AgeData> parent) {
        // If the right child has no right child, it is
        // the inorder predecessor.
        if (parent.right.right == null) {
            AgeData temp = parent.right.data;
            parent.right = parent.right.left;
            return temp;
        } else {
            return findLargestChild(parent.right);
        }
    }

    /**
     * Override BinarySearchTree find method for find AgeData nodes in my tree
     * @param target The Comparable object being sought
     * @return  return finding node
     */
    @Override
    public E find(Comparable target) {
        AgeData x=findWrap(root,target);
        if(x==null) return null;
        StringBuilder result=new StringBuilder();
        result.append(x.getAge()+"-"+x.getNumber_age());
        return (E) result;
        /*Integer return_val= x.getAge();
        return (E) return_val;

         */
    }

    /**
     * A recursive Wrapper function for find method
     * @param localRoot root
     * @param target item that will finding
     * @return AgeData object
     */
    private AgeData findWrap(Node<AgeData> localRoot,Comparable target){
        if (localRoot == null)
            return null;
        // Compare the target with the data field at the root.
        int compResult = target.compareTo(localRoot.data);
        if (compResult == 0)
            return localRoot.data;
        else if (compResult < 0)
            return findWrap(localRoot.left, target);
        else
            return findWrap(localRoot.right, target);
    }

    /**
     * Find count of younger Nodes
     * @param value find younger than this value
     * @return count of nodes
     */
    public int youngerThan(int value){
        return youngerThanWrapped(root,value,0);
    }

    /**
     * A wrapper recursive function for my younger method It didnt traverse all tree I explain this in my report
     * @param localNode root
     * @param value value
     * @param total total number of younger node
     * @return count of younger node
     */
    private int youngerThanWrapped(Node<AgeData> localNode,int value,int total){
        if(localNode == null){
            return total;
        }
        if(localNode.data.getAge()> value || localNode.data.getAge()==value){
            return youngerThanWrapped(localNode.left,value,total);
        }
        else{
            total++;
            total+=total_of_smaller_nodes(localNode.left);
            return youngerThanWrapped(localNode.right,value,total);

        }
    }

    /**
     * If a node value smaller than my value than all its left child also smaller than my value
     * so this method count left side of this node and return total nodes.
     * @param nodes
     * @return
     */
    private int total_of_smaller_nodes(Node<AgeData> nodes){
        if(nodes==null){
            return 0;
        }
        return 1+total_of_smaller_nodes(nodes.left)+total_of_smaller_nodes(nodes.right);

    }

    /**
     * Same as younger method only difference it return older ones
     * @param value value
     * @return odler nodes count
     */
    public int olderThan(int value){
        return olderThanWrapped(root,value,0);
    }

    /**
     * A wrapper recursive function for olderThan
     * @param localNode root
     * @param value value
     * @param total total number of nodes
     * @return return total num of nodes
     */
    private int olderThanWrapped(Node<AgeData> localNode,int value,int total){
        if(localNode == null){
            return total;
        }
        if(localNode.data.getAge() < value || localNode.data.getAge() == value){
            return olderThanWrapped(localNode.right,value,total);
        }
        else{
            total++;
            total+=total_of_bigger_nodes(localNode.right);
            return olderThanWrapped(localNode.left,value,total);

        }
    }

    /**
     * Same as total_of_smaller_nodes only difference is
     * its count older nodes
     * @param nodes node
     * @return total count of older nodes
     */
    private int total_of_bigger_nodes(Node<AgeData> nodes){
        if(nodes == null){
            return 0;
        }
        return 1+ total_of_bigger_nodes(nodes.left) + total_of_bigger_nodes(nodes.right);

    }

    /**
     * Override toString to print my Tree
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder result=new StringBuilder();
        toString(root,result);
        return result.toString();
    }

    /**
     * A wrapper recursive function for print tree
     * @param localroot root
     * @param result StringBuilder
     */
    private void toString(Node<AgeData> localroot,StringBuilder result){
        if(localroot==null){
            result.append("null"+"\n");
            return;
        }
        result.append(localroot.data.getAge()+"-"+localroot.data.getNumber_age()+"\n");
        toString(localroot.left,result);
        toString(localroot.right,result);

    }
}
