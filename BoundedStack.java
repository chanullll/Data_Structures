public class BoundedStack<T> {
    private T[] stack;
    private int top;
    private int capacity;

    // Constructor to initialize the stack with a specified capacity
    public BoundedStack(int capacity) {
        this.capacity = capacity;
        stack = (T[]) new Object[capacity]; // Create an array of type T
        top = -1; // The stack is empty initially
    }

    // Push a new element onto the stack
    public boolean push(T element) {
        if (top == capacity - 1) {
            System.out.println("Stack is full. Cannot push " + element);
            return false; // Stack is full, cannot push
        }
        stack[++top] = element; // Increment top and add element to the stack
        return true;
    }

    // Pop an element from the stack
    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return null; // Stack is empty, nothing to pop
        }
        return stack[top--]; // Return the element and decrement top
    }

    // Peek the top element of the stack without removing it
    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return null;
        }
        return stack[top]; // Return the top element
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Check if the stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Get the current size of the stack
    public int size() {
        return top + 1;
    }

    // Print the stack elements (for debugging purposes)
    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a stack with a capacity of 3
        BoundedStack<Integer> stack = new BoundedStack<>(3);

        // Push elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Print the stack
        stack.printStack();

        // Try pushing another element (should fail since the stack is full)
        stack.push(4);

        // Pop elements from the stack
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        // Print the stack again
        stack.printStack();

        // Peek the top element
        System.out.println("Top element: " + stack.peek());
    }
}
