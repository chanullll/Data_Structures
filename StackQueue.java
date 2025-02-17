import java.util.Stack;

class StackQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    // Constructor to initialize two stacks
    public StackQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue method to add an element to the queue
    public void enqueue(int value) {
        stack1.push(value);
    }

    // Dequeue method to remove the front element from the queue
    public int dequeue() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        // If stack2 is empty, move elements from stack1 to stack2
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        // Pop from stack2, which is the front element of the queue
        return stack2.pop();
    }

    // Peek method to see the front element of the queue without removing it
    public int peek() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        // If stack2 is empty, move elements from stack1 to stack2
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        // Peek from stack2, which is the front element of the queue
        return stack2.peek();
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Method to return the size of the queue
    public int size() {
        return stack1.size() + stack2.size();
    }

    public static void main(String[] args) {
        StackQueue queue = new StackQueue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Front element: " + queue.peek()); // Should print 1
        System.out.println("Dequeued element: " + queue.dequeue()); // Should print 1
        System.out.println("Front element after dequeue: " + queue.peek()); // Should print 2
        System.out.println("Queue is empty: " + queue.isEmpty()); // Should print false
    }
}
