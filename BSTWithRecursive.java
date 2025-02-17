class BSTWithRecursive {
    // Define the Node class representing each node in the BST
    class Node {
        int data;
        Node left, right;

        // Constructor to create a new node
        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    private Node root; // Root of the binary search tree

    // Constructor to initialize an empty BST
    public BSTWithRecursive() {
        root = null;
    }

    // Method to insert a new node into the BST (Recursive)
    public void insert(int data) {
        root = insertRecursive(root, data);
    }

    // Recursive helper method for insert
    private Node insertRecursive(Node root, int data) {
        // If the tree is empty, create a new node
        if (root == null) {
            return new Node(data);
        }

        // Otherwise, recur down the tree
        if (data < root.data) {
            root.left = insertRecursive(root.left, data); // Insert in the left subtree
        } else if (data > root.data) {
            root.right = insertRecursive(root.right, data); // Insert in the right subtree
        }

        // Return the (unchanged) node pointer
        return root;
    }

    // Method to search for a node with a given value (Recursive)
    public boolean search(int data) {
        return searchRecursive(root, data);
    }

    // Recursive helper method for search
    private boolean searchRecursive(Node root, int data) {
        // Base case: root is null or data is present at the root
        if (root == null) {
            return false;
        }

        // Data is greater than root's data, search in the right subtree
        if (data > root.data) {
            return searchRecursive(root.right, data);
        }
        // Data is smaller than root's data, search in the left subtree
        else if (data < root.data) {
            return searchRecursive(root.left, data);
        }

        // Data is equal to root's data
        return true;
    }

    // Method to delete a node from the BST (Recursive)
    public void delete(int data) {
        root = deleteRecursive(root, data);
    }

    // Recursive helper method for delete
    private Node deleteRecursive(Node root, int data) {
        // Base case: the tree is empty
        if (root == null) {
            return root;
        }

        // Otherwise, recur down the tree
        if (data < root.data) {
            root.left = deleteRecursive(root.left, data); // Data is smaller, go left
        } else if (data > root.data) {
            root.right = deleteRecursive(root.right, data); // Data is larger, go right
        } else {
            // Node with the given data found

            // Node with only one child or no child
            if (root.left == null) {
                return root.right; // Replace with the right child
            } else if (root.right == null) {
                return root.left; // Replace with the left child
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRecursive(root.right, root.data);
        }

        return root;
    }

    // Helper method to find the smallest value in a subtree
    private int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    // Method to perform inorder traversal (Left, Root, Right)
    public void inorder() {
        inorderRecursive(root);
    }

    private void inorderRecursive(Node root) {
        if (root != null) {
            inorderRecursive(root.left); // Traverse left subtree
            System.out.print(root.data + " "); // Visit root
            inorderRecursive(root.right); // Traverse right subtree
        }
    }

    // Method to perform preorder traversal (Root, Left, Right)
    public void preorder() {
        preorderRecursive(root);
    }

    private void preorderRecursive(Node root) {
        if (root != null) {
            System.out.print(root.data + " "); // Visit root
            preorderRecursive(root.left); // Traverse left subtree
            preorderRecursive(root.right); // Traverse right subtree
        }
    }

    // Method to perform postorder traversal (Left, Right, Root)
    public void postorder() {
        postorderRecursive(root);
    }

    private void postorderRecursive(Node root) {
        if (root != null) {
            postorderRecursive(root.left); // Traverse left subtree
            postorderRecursive(root.right); // Traverse right subtree
            System.out.print(root.data + " "); // Visit root
        }
    }

    // Method to find the minimum value in the BST (Recursive)
    public int findMin() {
        return findMinRecursive(root);
    }

    private int findMinRecursive(Node root) {
        if (root.left == null) {
            return root.data;
        }
        return findMinRecursive(root.left);
    }

    // Method to find the maximum value in the BST (Recursive)
    public int findMax() {
        return findMaxRecursive(root);
    }

    private int findMaxRecursive(Node root) {
        if (root.right == null) {
            return root.data;
        }
        return findMaxRecursive(root.right);
    }

    // Main method to test the BST implementation
    public static void main(String[] args) {
        BSTWithRecursive bst = new BSTWithRecursive();

        // Insert nodes into the BST
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        // Inorder traversal (Should print the elements in ascending order)
        System.out.println("Inorder traversal: ");
        bst.inorder();  // Output: 20 30 40 50 60 70 80
        System.out.println();

        // Preorder traversal
        System.out.println("Preorder traversal: ");
        bst.preorder();  // Output: 50 30 20 40 70 60 80
        System.out.println();

        // Postorder traversal
        System.out.println("Postorder traversal: ");
        bst.postorder();  // Output: 20 40 30 60 80 70 50
        System.out.println();

        // Search for a node
        System.out.println("Searching for 40: " + bst.search(40)); // true
        System.out.println("Searching for 100: " + bst.search(100)); // false

        // Find minimum and maximum values
        System.out.println("Minimum value: " + bst.findMin()); // 20
        System.out.println("Maximum value: " + bst.findMax()); // 80

        // Delete a node and traverse again
        bst.delete(20);
        System.out.println("Inorder traversal after deleting 20: ");
        bst.inorder();  // Output: 30 40 50 60 70 80
        System.out.println();

        bst.delete(30);
        System.out.println("Inorder traversal after deleting 30: ");
        bst.inorder();  // Output: 40 50 60 70 80
    }
}
