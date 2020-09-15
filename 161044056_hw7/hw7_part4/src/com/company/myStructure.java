package com.company;

public class myStructure<E extends Comparable<E>> implements SearchTree<E> {

    private Node<E> root;

    private boolean addReturn;
    private E deleteReturn;

    public class Node<E>{
        public E data;
        public Node<E> left;
        public Node<E> right;

        public Node(){
            data=null;
            left=null;
            right=null;
        }

        public Node(E data){
            this.data=data;
            left=null;
            right=null;
        }
    }

    /**
     * Add item to my structure
     * @param item software
     * @return return true if adding succesfull otherwise false
     */
    @Override
    public boolean add(E item) {
        root = add(root, item);
        return addReturn;
    }

    /**
     * Helper add method
     * @param localRoot root
     * @param item my software that will added
     * @return return Node
     */
    private Node<E> add(Node<E> localRoot, E item) {
        if (localRoot == null) {
            // item is not in the tree — insert it.
            addReturn = true;
            return new Node<>(item);
        } else if (item.compareTo(localRoot.data) == 0) {
            // item is equal to localRoot.data
            addReturn = false;
            return localRoot;
        } else if (item.compareTo(localRoot.data) < 0) {
            // item is less than localRoot.data
            localRoot.left = add(localRoot.left, item);
            return localRoot;
        } else {
            // item is greater than localRoot.data
            localRoot.right = add(localRoot.right, item);
            return localRoot;
        }
    }

    /**
     * Check my structure contains an item or not
     * @param target search item
     * @return if contains true otherwise not
     */
    @Override
    public boolean contains(E target) {
        E x=find(target);
        if(x!=null) return true;
        return false;
    }

    /**
     * same with contains method just return finding value not boolean
     * @param target search item
     * @return return finding value
     */
    @Override
    public E find(E target) {
        return find(root, target);
    }

    /**
     * Find helper recursive method
     * @param localRoot root
     * @param target searching key
     * @return return software
     */
    private E find(Node<E> localRoot, E target) {
        if (localRoot == null)
            return null;
        // Compare the target with the data field at the root.
        int compResult = target.compareTo(localRoot.data);
        if (compResult == 0)
            return localRoot.data;
        else if (compResult < 0)
            return find(localRoot.left, target);
        else
            return find(localRoot.right, target);
    }

    /**
     * Delete a software from the system
     * @param target item that will deleted
     * @return return deleted item
     */
    @Override
    public E delete(E target) {
        root = delete(root, target);
        return deleteReturn;
    }

    /**
     * Delete helper recursive method
     * @param localRoot root
     * @param item item that will added
     * @return return software
     */
    private Node<E> delete(Node<E> localRoot, E item) {
        if (localRoot == null) {
            // item is not in the tree.
            deleteReturn = null;
            return localRoot;
        }
        // Search for item to delete.
        int compResult = item.compareTo(localRoot.data);
        if (compResult < 0) {
            // item is smaller than localRoot.data.
            localRoot.left = delete(localRoot.left, item);
            return localRoot;
        } else if (compResult > 0) {
            // item is larger than localRoot.data.
            localRoot.right = delete(localRoot.right, item);
            return localRoot;
        } else {
            // item is at local root.
            deleteReturn = localRoot.data;
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
     * Find largest child to a node
     * I use this method for Delete operation in tree
     * @param parent root
     * @return largest child value
     */
    private E findLargestChild(Node<E> parent) {
        // If the right child has no right child, it is
        // the inorder predecessor.
        if (parent.right.right == null) {
            E returnValue = parent.right.data;
            parent.right = parent.right.left;
            return returnValue;
        } else {
            return findLargestChild(parent.right);
        }
    }

    /**
     * Same with the delete method
     * just return boolean
     * @param target deleted item
     * @return true if target removed otherwise false
     */
    @Override
    public boolean remove(E target) {
        E x=delete(target);
        if(x!=null) return true;
        return false;
    }

    /**
     * getter for root
     * @return root
     */
    public Node<E> getRoot() {
        return root;
    }


}
