class SinglyLinkedList {
    // Define the Node class which represents each element of the linked list
    class Node {
        int data;       // Data of the node
        Node next;      // Reference to the next node in the list

        // Constructor to create a new node
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;  // Head of the linked list

    // Constructor to initialize the linked list
    public SinglyLinkedList() {
        head = null;
    }

    // Method to insert a new node at the end of the list
    public void insert(int data) {
        Node newNode = new Node(data);
        
        // If the list is empty, set the new node as the head
        if (head == null) {
            head = newNode;
            return;
        }

        // Otherwise, traverse to the last node and insert the new node
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Method to insert a node at the beginning of the list
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;  // Point the new node to the current head
        head = newNode;       // Update head to the new node
    }

    // Method to delete the first occurrence of a given value
    public void delete(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // If the data is at the head of the list
        if (head.data == data) {
            head = head.next;  // Move head to the next node
            return;
        }

        // Traverse the list and find the node to delete
        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        // If data is not found in the list
        if (current.next == null) {
            System.out.println("Element " + data + " not found");
        } else {
            current.next = current.next.next;  // Remove the node
        }
    }

    // Method to display the entire linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");  // End of the list
    }

    // Method to find if an element exists in the list
    public boolean contains(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;  // Element found
            }
            current = current.next;
        }
        return false;  // Element not found
    }

    // Method to get the size (length) of the list
    public int size() {
        int size = 0;
        Node current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    // Main method to test the SinglyLinkedList
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insertAtBeginning(5);  // Insert 5 at the beginning

        System.out.println("Singly Linked List: ");
        list.display();  // Should display: 5 -> 10 -> 20 -> 30 -> null

        System.out.println("Size of list: " + list.size());  // Should print: 4

        System.out.println("Contains 20? " + list.contains(20));  // Should print: true
        System.out.println("Contains 100? " + list.contains(100));  // Should print: false

        list.delete(20);  // Delete element 20
        System.out.println("List after deleting 20: ");
        list.display();  // Should display: 5 -> 10 -> 30 -> null

        list.delete(100);  // Try deleting an element that doesn't exist
    }
}
