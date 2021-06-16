package classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * An implementation of a Tree Map to store Keys and Values using a B Tree.
 *
 * @author Josué Fernández
 * @version 1.0
 * @param <K> The key type.
 * @param <V> The value type.
 */
public class BTree<K extends Comparable, V> implements Serializable {

    private static final long serialVersionUID = 777L;

    //-------------------------------Clase ENTRY-------------------------------
    /**
     * Public Entry class to hold the Key-Value pairs in the B TreeMap.
     *
     * @param <K> The key type.
     * @param <V> The value type.
     */
    public class Entry<K extends Comparable, V> implements Serializable{

        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "";
        }

    }
    //--------------------------Fin de la clase ENTRY--------------------------

    //-------------------------------Clase NODE--------------------------------
    /**
     * Public Node class to make up the containers in the B TreeMap.
     *
     * @param <K> The key type.
     * @param <V> The value type.
     */
    public class Node<K extends Comparable, V> implements Serializable{

        private ArrayList<Entry<K, V>> entries;
        private ArrayList<Node<K, V>> children;
        private int t;

        // minimum # of keys = (degree - 1)/2
        // maximum # of keys = degree - 1
        /**
         * Creates a new instance of a Node with the given degere.
         *
         * @param t The minimum degree of the node
         */
        public Node(int t) throws IllegalArgumentException {
            if (t < 2) {
                throw new IllegalArgumentException("The degree of the Node cannot be less than 2.");
            }

            this.t = t;
            entries = new ArrayList<>();
            children = new ArrayList<>();

            if (t < 16) {
                entries.ensureCapacity(2 * t);         //Uno más que la capacidad máxima de llaves
                children.ensureCapacity(2 * t + 1);    //Uno más que la capacidad máxima de hijos
            }

        }

        public int getMinDegree() {
            return this.t;
        }

        public int numChildren() {
            return children.size();
        }

        public int numEntries() {
            return entries.size();
        }

        public boolean isLeaf() {
            return children.isEmpty();
        }

        public void split(Node<K, V> parent, int index) {

            // minimum # of keys = (degree - 1)/2
            // maximum # of keys = degree - 1
            if (this.numEntries() < 2 * t - 1) {
                return;
            }

            Node<K, V> z = new Node<>(t);

            // Adding half of the leaves to the newly allocated node
            for (int j = 0; j < t - 1; j++) {
                z.entries.add(this.getEntry(t + j));     //Already in order
            }

            // Removing the same keys from this node
            for (int j = 0; j < t - 1; j++) {
                this.entries.remove(this.entries.size() - 1);       // Remove the last key each time
            }

            // Adding the corresponding children to the new node
            if (!this.isLeaf()) {
                for (int j = 0; j < t; j++) {
                    z.children.add(this.children.get(t + j));     //Already in order
                }

                for (int j = 0; j < t; j++) {
                    this.children.remove(this.children.size() - 1);     // Remove the last node each time
                }
            }

            // Adding the new node to the list of children of the parent
            // It is added after the index of this node
            // It automatically shifts all other nodes
            parent.children.add(index + 1, z);

            // Adding the middle key to the list of keys of the parent
            parent.entries.add(index, this.getEntry(this.entries.size() - 1));

            // Removing the key that was promoted
            this.entries.remove(this.entries.size() - 1);

        }

        public void addEntry(K key, V value) {
            Entry<K, V> entry = new Entry<>(key, value);
            addEntry(entry);
            entries.add(entry);
        }

        public void addEntry(Entry<K, V> entry) {
            if (entry == null) {
                return;
            }

            entries.add(entry);
            Collections.sort(entries,
                    (e1, e2) -> {
                        return e1.getKey().compareTo(e2.getKey());
                    }
            );
        }

        public ArrayList<Node<K, V>> children() {
            ArrayList<Node<K, V>> c = new ArrayList<>(this.numChildren() + 1);
            for (int i = 0; i < numChildren(); i++) {
                c.add(this.children.get(i));
            }
            return c;
        }

        public Node<K, V> getChild(int child) {
            if (child < 0 || child >= children.size()) {
                return null;
            }
            return children.get(child);
        }

        public ArrayList<K> keys() {
            ArrayList<K> k = new ArrayList<>(this.numChildren());
            for (int i = 0; i < numEntries(); i++) {
                k.add(this.getEntry(i).getKey());
            }
            return k;
        }

        public K getKey(int index) {
            if (index < 0 || index >= entries.size()) {
                return null;
            }

            return getEntry(index).getKey();
        }

        public Entry<K, V> getEntry(int index) {
            if (index < 0 || index >= entries.size()) {
                return null;
            }

            return entries.get(index);
        }

        public Iterable<Entry<K, V>> entries() {
            ArrayList<Entry<K, V>> e = new ArrayList<>(this.numChildren() + 1);
            for (int i = 0; i < numEntries(); i++) {
                e.add(this.getEntry(i));
            }
            return e;
        }

        @Override
        public String toString() {
            return "Node{" + entries.toString() + '}';
        }

        protected class EntryComparator implements Comparator<Entry<K, V>> {

            @Override
            public int compare(Entry<K, V> e1, Entry<K, V> e2) {
                return e1.getKey().compareTo(e2.getKey());
            }
        }
    }
    //--------------------------Fin de la clase NODE--------------------------

    //ATRIBUTES
    private int t;                  // The minimum degree of the B Tree
    private int size;               // The number of elements in the tree
    private Node<K, V> root;        // The root of the tree

    //CONSTRUCTOR
    /**
     * Creates an empty multiway B TreeMap with the specified degree.
     *
     * @param t The minimum degree of the B Tree
     * @throws IllegalArgumentException
     */
    public BTree(int t) throws IllegalArgumentException {

        if (t < 2) {
            throw new IllegalArgumentException("The minimum degree of the B Tree cannot be less than 2.");
        }

        this.t = t;

        Node<K, V> node = new Node<>(t);
        root = node;

    }

    //METHODS
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        toStringPreorder(s, this.root, 0);
        return "B_TreeMap{\n\n"
                + s.toString()
                + "\n}";
    }

    private void toStringPreorder(StringBuilder s, Node<K, V> root, int depth) {
        if (root == null) {
            return;
        }

        // First way to do it
//        for(int n=0; n<depth; n++) s.append("    ");
//
//        for (Entry e : root.entries) {
//            s.append(e.getKey().toString());
//            s.append(" ");
//        }
//        s.append('\n');
//        
//        for (Node<K, V> node : root.children) {
//            toStringPreorder(s, node, depth + 1);
//        }
        // Second way to do it (comment the first one out to use)
        if (root.isLeaf()) {
            for (int n = 0; n < depth; n++) {
                s.append("    ");
            }

            for (int i = 0; i < root.entries.size(); i++) {
                s.append(root.entries.get(i).getKey().toString());
                s.append(" ");
            }
            s.append('\n');
        } else {
            for (int i = 0; i < root.entries.size(); i++) {

                toStringPreorder(s, root.getChild(i), depth + 1);

                for (int n = 0; n < depth; n++) {
                    s.append("    ");
                }

//                if (root == this.root) {
//                    s.append('\n');
//                }
                s.append(root.getKey(i).toString());
                s.append("\n");

//                if (root == this.root) {
//                    s.append('\n');
//                }
            }
            toStringPreorder(s, root.getChild(root.entries.size()), depth + 1);
        }
    }

    /**
     * Realiza una búsqueda en el árbol B en búsqueda de la llave específicada.
     *
     * @param key La llave a buscar
     * @param root La raíz del subarbol donde buscar la llave
     * @return Si se encuentra la llave, el nodo y el índice en el nodo de la
     * llave; de otro modo, se retorna el nodo hoja donde se buscó por último y
     * el índice del elemento menor que la llave.
     */
    private Pair<Node<K, V>, Integer> treeSearch(K key, Node<K, V> root) {
        int i = 0;

        while (i < root.numEntries() && key.compareTo(root.getKey(i)) > 0) {
            i++;
        }

        if ((i < root.numEntries() && key.compareTo(root.getKey(i)) == 0) || root.isLeaf()) {
            Pair<Node<K, V>, Integer> p = new Pair<>(root, i);
            return p;
        }
        return treeSearch(key, root.getChild(i));
    }

    public Pair<Node<K, V>, Integer> search(K key) {

        Pair<Node<K, V>, Integer> pair = treeSearch(key, root);

        Node<K, V> node = pair.getPrimero();
        int index = pair.getSegundo();

        if (key.equals(node.getKey(index))) {
            return pair;
        }
        return null;
    }

    public boolean insert(K key, V value) {

        if (key == null || value == null) {
            return false;
        }

        Pair<Node<K, V>, Integer> p = search(key);

        if (p != null) {
            return false;
        }

        Entry<K, V> e = new Entry(key, value);
        insert(e);
        return true;
    }

    private void insert(Entry<K, V> e) {

        Node<K, V> r = this.root;

        if (r.numEntries() == 2 * t - 1) {
            Node<K, V> s = new Node<>(t);
            root = s;
            s.children.add(r);
            r.split(s, 0);
            insertNonFull(s, e);
        } else {
            insertNonFull(r, e);
        }
    }

    public int size() {
        return size;
    }

    private void insertNonFull(Node<K, V> root, Entry<K, V> e) {

        if (root.isLeaf()) {
            root.addEntry(e);
            size++;
        } else {

            //Perform a binary search to find the appropiate child
            int i = binarySearch(e.getKey(), root.entries, 0, root.entries.size() - 1);

            // Get the appropiate child
            Node<K, V> c = root.getChild(i);

            // If it has the maximum number of keys, split the node
            if (c.numEntries() == 2 * t - 1) {
                c.split(root, i);

                //Compare to the newly added key on the current node
                if (e.getKey().compareTo(root.getKey(i)) > 0) {
                    i++;
                }

            }
            insertNonFull(root.getChild(i), e);
        }
    }

    public boolean remove(K key) {
        if (key == null || size == 0) {
            return false;
        }

        boolean ret = delete(key, this.root);

        if (this.root.numEntries() == 0 && !this.root.isLeaf()) {
            this.root = this.root.getChild(0);
        }

        return ret;
    }

    /**
     * Performs a binary search on the specified portion of the ArrayList.
     *
     * @param key The key to search for.
     * @param list The arraylist in which to search the key.
     * @param start The start of the range to search (inclusive).
     * @param end The end of the range to search (inclusive).
     * @return The index of the searched key on the ArrayList, if present. Else,
     * it returns the index where the key should be inserted.
     */
    private int binarySearch(K key, ArrayList<Entry<K, V>> list, int start, int end) {

        // The key is not present
        if (start > end) {
            return end + 1;
        }

        // The middle of the range
        int mid = (start + end) / 2;

        if (key.equals(list.get(mid).getKey())) // The key has been found
        {
            return mid;
        } else if (key.compareTo(list.get(mid).getKey()) < 0) // The key is less than the element at mid
        {
            return binarySearch(key, list, start, mid - 1);
        } else {
            return binarySearch(key, list, mid + 1, end);   // The key is greater than the element at mid
        }
    }

    private boolean delete(K k, Node<K, V> root) {
        if (root == null || root.numEntries() == 0) {
            return false;
        }

        int index = binarySearch(k, root.entries, 0, root.entries.size() - 1);
        boolean contained = index < root.numEntries() && root.getKey(index).equals(k);

        if (root.isLeaf()) {

            //The key is not in the tree
            if (!contained) {
                return false;
            }

            //Remove the key from the leaf node
            root.entries.remove(index);
            size--;
            return true;

        } else if (contained) { //If the key is in an internal node containing the key

            //Get the preceding and succeeding child
            Node<K, V> prev = root.getChild(index);
            Node<K, V> next = root.getChild(index + 1);

            if (prev.numEntries() > t - 1) {    //prev has more than the minimum

                //Get the last key from the preceding child
                Entry<K, V> k_ = prev.getEntry(prev.numEntries() - 1);

                //Replace k with k_
                Entry<K, V> old = root.entries.get(index);
                old.setKey(k_.getKey());
                old.setValue(k_.getValue());

                // Delete k_ from the preceding child
                return delete(k_.getKey(), prev);

            } else if (next.numEntries() > t - 1) { //next has more than the minimum

                //Get the first key from the succeeding child
                Entry<K, V> k_ = next.getEntry(0);

                //Replace k with k_
                Entry<K, V> old = root.entries.get(index);
                old.setKey(k_.getKey());
                old.setValue(k_.getValue());

                // Delete k_ from the succeeding child
                return delete(k_.getKey(), next);

            } else {    //Both nodes have the minimum amount of keys

                //MERGING PREVIOUS AND SUCCEEDING NODES
                //Add the key to be deleted to the preceding node
                prev.entries.add(root.entries.remove(index));

                //Add the keys from the succeeding to the preceding node
                for (int i = 0; i < next.numEntries(); i++) {
                    prev.entries.add(next.getEntry(i));
                }

                //Remove the keys from the succeeding node
                for (int i = next.numEntries() - 1; i >= 0; i--) {
                    next.entries.remove(i);

                }

                if (!prev.isLeaf()) {
                    //Add the children from the succeeding to the preceding node
                    for (int i = 0; i < next.numChildren(); i++) {
                        prev.children.add(next.getChild(i));
                    }

                    //Remove the children from the succeeding node
                    for (int i = next.numChildren() - 1; i >= 0; i--) {
                        next.children.remove(i);
                    }
                }

                //Remove succeeding children from current
                root.children.remove(index + 1);

                //Recursively delete from merged node
                return delete(k, prev);

            }

        } else {        //This internal node doesn't have the key

            //The index variable is of that child where the key might be
            Node<K, V> child = root.getChild(index);

            if (child.numEntries() > t - 1) {
                return delete(k, child);
            }

            Node<K, V> sibling;
            boolean isRight = true;

            if (index == 0) //If child is the first node
            {
                sibling = root.getChild(index + 1);
            } else if (index == root.numChildren() - 1) { //If it is the last node
                sibling = root.getChild(index - 1);
                isRight = false;
            } else if (root.getChild(index + 1).numEntries() > t - 1) {
                sibling = root.getChild(index + 1);
            } else {
                sibling = root.getChild(index - 1);
                isRight = false;
            }

            if (isRight) {

                //Borrow from sibling
                if (sibling.numEntries() > t - 1) {
                    //Get the first key from the sibling
                    Entry<K, V> k_ = sibling.entries.remove(0);

                    //Get the corresponding key from the root
                    Entry<K, V> k_2 = root.entries.get(index);

                    // Replace the key in the root node
                    root.entries.set(index, k_);

                    //Add the replaced key from the parent node to the child
                    child.entries.add(k_2);

                    //Move the first child of the sibling to the child
                    if (!child.isLeaf()) {
                        child.children.add(sibling.children.remove(0));
                    }

                    // Delete k from the child
                    return delete(k, child);

                    //Merge with sibling
                } else {
                    mergeWithRight(root, child, sibling, index);

                    //Recursively delete from merged node
                    return delete(k, child);
                }

            } else {

                //Borrow from sibling
                if (sibling.numEntries() > t - 1) {
                    //Get the last key from the sibling
                    Entry<K, V> k_ = sibling.entries.remove(sibling.numEntries() - 1);

                    //Get the corresponding key from the root
                    Entry<K, V> k_2 = root.entries.get(index - 1);

                    // Replace the key in the root node
                    root.entries.set(index - 1, k_);

                    //Add the replaced key from the parent node to the child
                    child.entries.add(0, k_2);

                    //Move the last child of the sibling to the child
                    if (!child.isLeaf()) {
                        child.children.add(0, sibling.children.remove(sibling.numChildren() - 1));
                    }

                    // Delete k from the child
                    return delete(k, child);

                    //Merge with sibling
                } else {
                    mergeWithLeft(root, child, sibling, index);

                    //Recursively delete from merged node
                    return delete(k, sibling);
                }
            }
        }
    }

    private void mergeWithRight(Node<K, V> root, Node<K, V> child, Node<K, V> sibling, int index) {
        //MERGING CHILD AND RIGHT SIBLING

        //Add the median key to the child
        child.entries.add(root.entries.remove(index));

        //Add the keys from the sibling to the child
        for (int i = 0; i < sibling.numEntries(); i++) {
            child.entries.add(sibling.getEntry(i));
        }

        //Remove the keys from the sibling
        for (int i = sibling.numEntries() - 1; i >= 0; i--) {
            sibling.entries.remove(i);

        }

        if (!child.isLeaf()) {
            //Add the children from the sibling to the child
            for (int i = 0; i < sibling.numChildren(); i++) {
                child.children.add(sibling.getChild(i));
            }

            //Remove the children from the sibling
            for (int i = sibling.numChildren() - 1; i >= 0; i--) {
                sibling.children.remove(i);
            }
        }

        //Remove sibling from current
        root.children.remove(index + 1);
    }

    private void mergeWithLeft(Node<K, V> root, Node<K, V> child, Node<K, V> sibling, int index) {
        //MERGING LEFT SIBLING AND CHILD

        //Add the median key to the sibling
        sibling.entries.add(root.entries.remove(index - 1));

        //Add the keys from the child to the sibling
        for (int i = 0; i < child.numEntries(); i++) {
            sibling.entries.add(child.getEntry(i));
        }

        //Remove the keys from the child
        for (int i = child.numEntries() - 1; i >= 0; i--) {
            child.entries.remove(i);

        }

        if (!sibling.isLeaf()) {
            //Add the children from the child to the sibling
            for (int i = 0; i < child.numChildren(); i++) {
                sibling.children.add(child.getChild(i));
            }

            //Remove the children from the child
            for (int i = child.numChildren() - 1; i >= 0; i--) {
                child.children.remove(i);
            }
        }

        //Remove child from current
        root.children.remove(index);

    }

}
