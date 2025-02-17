class BinarySearchTree {
    // Node class representing each node in the BST
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
    public BinarySearchTree() {
        root = null;
    }

    // Insert a new node into the BST
    public void insert(int data) {
        root = insertRec(root, data);
    }

    // Recursive helper method for insert
    private Node insertRec(Node root, int data) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(data);
            return root;
        }

        // Otherwise, recur down the tree
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        // Return the (unchanged) node pointer
        return root;
    }

    // Search for a node with a given value
    public boolean search(int data) {
        return searchRec(root, data);
    }

    // Recursive helper method for search
    private boolean searchRec(Node root, int data) {
        // Base case: root is null or data is present at the root
        if (root == null) {
            return false;
        }

        // Data is greater than root's data, search in the right subtree
        if (data > root.data) {
            return searchRec(root.right, data);
        }
        // Data is smaller than root's data, search in the left subtree
        else if (data < root.data) {
            return searchRec(root.left, data);
        }

        // Data is equal to root's data
        return true;
    }

    // Delete a node from the BST
    public void delete(int data) {
        root = deleteRec(root, data);
    }

    // Recursive helper method for delete
    private Node deleteRec(Node root, int data) {
        // Base case: if the tree is empty
        if (root == null) {
            return root;
        }

        // Otherwise, recur down the tree
        if (data < root.data) {
            root.left = deleteRec(root.left, data);
        } else if (data > root.data) {
            root.right = deleteRec(root.right, data);
        } else {
            // Node with the given data found

            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    // Method to find the smallest value in a subtree
    private int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    // Inorder traversal of the BST (Left, Root, Right)
    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    // Preorder traversal of the BST (Root, Left, Right)
    public void preorder() {
        preorderRec(root);
    }

    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Postorder traversal of the BST (Left, Right, Root)
    public void postorder() {
        postorderRec(root);
    }

    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Method to find the minimum value in the BST
    public int findMin() {
        return minValue(root);
    }

    // Method to find the maximum value in the BST
    public int findMax() {
        return maxValue(root);
    }

    // Method to find the maximum value in the BST
    private int maxValue(Node root) {
        int maxValue = root.data;
        while (root.right != null) {
            maxValue = root.right.data;
            root = root.right;
        }
        return maxValue;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        System.out.println("Inorder traversal: ");
        bst.inorder();  // Output: 20 30 40 50 60 70 80
        System.out.println();

        System.out.println("Preorder traversal: ");
        bst.preorder();  // Output: 50 30 20 40 70 60 80
        System.out.println();

        System.out.println("Postorder traversal: ");
        bst.postorder();  // Output: 20 40 30 60 80 70 50
        System.out.println();

        System.out.println("Searching for 40: " + bst.search(40)); // true
        System.out.println("Searching for 100: " + bst.search(100)); // false

        System.out.println("Minimum value: " + bst.findMin()); // 20
        System.out.println("Maximum value: " + bst.findMax()); // 80

        bst.delete(20);
        System.out.println("Inorder traversal after deleting 20: ");
        bst.inorder();  // Output: 30 40 50 60 70 80
        System.out.println();

        bst.delete(30);
        System.out.println("Inorder traversal after deleting 30: ");
        bst.inorder();  // Output: 40 50 60 70 80
    }
}
