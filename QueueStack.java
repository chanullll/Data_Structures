import java.util.LinkedList;
import java.util.Queue;

class QueueStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    // Constructor to initialize two queues
    public QueueStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // Push method to add an element to the stack
    public void push(int value) {
        // Push the value to queue1
        queue1.add(value);
    }

    // Pop method to remove the top element from the stack
    public int pop() {
        // If queue1 is empty, the stack is empty
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        // Move elements from queue1 to queue2, leaving the last element
        // in queue1 as the element to pop
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }

        // The last element of queue1 is the top element of the stack
        int poppedValue = queue1.poll();

        // Swap the queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return poppedValue;
    }

    // Peek method to see the top element of the stack without removing it
    public int peek() {
        // If queue1 is empty, the stack is empty
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        // Move elements from queue1 to queue2, leaving the last element
        // in queue1 as the top element
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }

        // The last element of queue1 is the top element of the stack
        int topValue = queue1.peek();

        // Swap the queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topValue;
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    // Method to return the size of the stack
    public int size() {
        return queue1.size();
    }

    public static void main(String[] args) {
        QueueStack stack = new QueueStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.peek()); // Should print 3
        System.out.println("Popped element: " + stack.pop()); // Should print 3
        System.out.println("Top element after pop: " + stack.peek()); // Should print 2
        System.out.println("Stack is empty: " + stack.isEmpty()); // Should print false
    }
}
