package classes;

public class Tree {

    public NodeTree root; // Pointer to root node
    public int t; // Minimum degree

    // Constructor (Initializes tree as empty)
    Tree(int t) {
        this.root = null;
        this.t = t;
    }

    // function to traverse the tree
    public void traverse() {
        if (this.root != null) {
            this.root.traverse();
        }
        System.out.println();
    }

    // function to search a key in this tree
    public NodeTree search(int k) {
        if (this.root == null) {
            return null;
        } else {
            return this.root.search(k);
        }
    }

    public void insert(int k) {
        // If tree is empty
        if (root == null) {
            // Allocate memory for root
            root = new NodeTree(t, true);
            root.keys[0] = k;  // Insert key
            root.n = 1;  // Update number of keys in root
        } else // If tree is not empty
        {
            // If root is full, then tree grows in height
            if (root.n == 2 * t - 1) {
                // Allocate memory for new root
                NodeTree s = new NodeTree(t, false);

                // Make old root as child of new root
                s.C[0] = root;

                // Split the old root and move 1 key to the new root
                s.splitChild(0, root);

                // New root has two children now.  Decide which of the
                // two children is going to have new key
                int i = 0;
                if (s.keys[0] < k) {
                    i++;
                }
                s.C[i].insertNonFull(k);

                // Change root
                root = s;
            } else // If root is not full, call insertNonFull for root
            {
                root.insertNonFull(k);
            }
        }

    }

    //    private static <T> void printTree(NodeTree<T> node, String appender) {
    //        System.out.println(appender + node.getData());
    //        node.getChildren().forEach(each -> printTree(each, appender + appender));
    //    }
}
