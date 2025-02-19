class AVLTree {
    Node root;

    // A utility function to get the height of the tree
    int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    // A utility function to get maximum of two integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // A utility function to right rotate subtree rooted with y
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        // Perform rotation
        x.right = y;
        y.left = T2;
        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
        // Return new root
        return x;
    }

    // A utility function to left rotate subtree rooted with x
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        // Perform rotation
        y.left = x;
        x.right = T2;
        // Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
        // Return new root
        return y;
    }

    // Get Balance factor of node N
    int getBalance(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    Node insert(Node node, int key) {
        /* 1. Perform the normal BST insertion */
        if (node == null)
            return (new Node(key));
        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else // Duplicate keys not allowed
            return node;
        /* 2. Update height of this ancestor node */
        node.height = 1 + max(height(node.left), height(node.right));
        /*
         * 3. Get the balance factor of this ancestor
         * node to check whether this node became unbalanced
         */
        int balance = getBalance(node);
        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);
        // Right Right Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);
        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        /* return the (unchanged) node pointer */
        return node;
    }

    // A utility function to print preorder traversal of the tree.
    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // A utility function to print inorder traversal of the tree.
    void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);  // Visit left child
            System.out.print(node.key + " ");  // Visit node itself
            inOrder(node.right);  // Visit right child
        }
    }

    // A utility function to print postorder traversal of the tree.
    void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);  // Visit left child
            postOrder(node.right);  // Visit right child
            System.out.print(node.key + " ");  // Visit node itself
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // Insert nodes
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 15);

        // Print preorder traversal
        System.out.print("Pre-order: ");
        tree.preOrder(tree.root); // Output might be: 20 10 15 30
        System.out.println();

        // Print inorder traversal
        System.out.print("In-order: ");
        tree.inOrder(tree.root); // Output might be: 10 15 20 30
        System.out.println();

        // Print postorder traversal
        System.out.print("Post-order: ");
        tree.postOrder(tree.root); // Output might be: 10 15 30 20
        System.out.println();
    }
}

class Node {
    int key;
    Node left, right;
    int height;

    public Node(int item) {
        key = item;
        left = right = null;
        height = 1;
    }
}
