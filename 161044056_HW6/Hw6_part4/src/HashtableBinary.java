

public class HashtableBinary<K extends Comparable<K>,V> implements KWHashMap<K,V> {
    /** The table */
    private Binary<EntryBinary<K,V>>[] table;
    /** The number of keys */
    private int numKeys=0;
    /** The capacity */
    private static final int CAPACITY = 101;
    /** The maximum load factor */
    private static final double LOAD_THRESHOLD = 3.0;
    // Constructor
    public HashtableBinary() {
        table = new Binary[CAPACITY];
    }

    //inner EntryOpen class for hold pairs
    public class EntryBinary<K extends Comparable<K>,V> implements Comparable<EntryBinary<K,V>>{
        /** The key */
        private final K key;
        /** The value */
        private V value;
        /** Creates a new key‐value pair.
         @param key The key
         @param value The value
         */
        public EntryBinary(K key, V value) {
            this.key = key;
            this.value = value;
        }
        /** Retrieves the key.
         @return The key
         */
        public K getKey() {
            return key;
        }
        /** Retrieves the value.
         @return The value
         */
        public V getValue() {
            return value;
        }
        /** Sets the value.
         @param val The new value
         @return The old value
         */
        public V setValue(V val) {
            V oldVal = value;
            value = val;
            return oldVal;
        }

        @Override
        public int compareTo(EntryBinary<K, V> o) {
            return key.compareTo(o.key);
        }
    }

    @Override
    public V get(Object key) {
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index] == null)
            return null; // key is not in the table.
        // Search the list at table[index] to find the key.

        V val=table[index].find((K)key);
        //System.out.println(table[index].root.data.value);;
        if(val!=null){
            return val;
        }
        else{
            return null;
        }
        // assert: key is not in the table.

    }

    @Override
    public boolean isEmpty() {
        if(numKeys==0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public V put(K key, V value) {
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index] == null) {
            // Create a new linked list at table[index].
            table[index] = new Binary<>();
        }
        // Search the list at table[index] to find the key.
        V val=table[index].find(key);
        if(val==null){
            table[index].add(key,value);
            numKeys++;
            return val;
        }
        else{
            table[index].add(key,val);
            numKeys++;
            return val;
        }
      //  if (numKeys > (LOAD_THRESHOLD * table.length))
        //    rehash();

    }

    @Override
    public V remove(Object key) {
        int index=key.hashCode()%table.length;
        if(index<0) index+=table.length;

        if(table[index]==null){
            return null;
        }
        if(table[index].find((K)key)==null){
            return null;
        }
        else{
            table[index].delete((K) key);
        }

        return null;
    }

    @Override
    public int size() {
        return numKeys;
    }

    public class Node{
        private EntryBinary<K,V> data;
        private Node left;
        private Node right;
    }

    public class Binary<EntryBinary>{
        private Node root=null;



        public V find(K target) {
            return find(root, target);
        }

        private V find(Node localRoot, K target) {
            if (localRoot == null)
                return null;
            // Compare the target with the data field at the root.
            int result=target.compareTo(localRoot.data.key);
            if (result == 0)
                return localRoot.data.value;
            else if (result<0)
                return find(localRoot.left, target);
            else
                return find(localRoot.right, target);
        }

        public void add(K k,V v) {
            root = add(root,k,v);
        }

        private Node add(Node localRoot,K k,V v) {
            if (localRoot == null) {
                // item is not in the tree — insert it.
                Node temp=new Node();
                HashtableBinary.EntryBinary x=new HashtableBinary.EntryBinary(k,v);
                temp.left=null;
                temp.right=null;
                temp.data=x;
                return temp;
            } else if (k.compareTo(localRoot.data.key) == 0) {
                // item is equal to localRoot.data
                return localRoot;
            } else if (k.compareTo(localRoot.data.key) < 0) {
                // item is less than localRoot.data
                localRoot.left = add(localRoot.left, k,v);
                return localRoot;
            } else {
                // item is greater than localRoot.data
                localRoot.right = add(localRoot.right, k,v);
                return localRoot;
            }
        }

        public void delete(K target) {
            root = delete(root, target);
        }

        private Node delete(Node localRoot, K item) {
            if (localRoot == null) {
                // item is not in the tree.
                return localRoot;
            }
            // Search for item to delete.
            int compResult = item.compareTo(localRoot.data.key);
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
                        findLargestChild(localRoot.left);
                        return localRoot;
                    }
                }
            }
        }

        private void findLargestChild(Node parent) {
            // If the right child has no right child, it is
            // the inorder predecessor.
            if (parent.right.right == null) {
                parent.right = parent.right.left;
                return;
            } else {
                findLargestChild(parent.right);
            }
        }



    }





}
