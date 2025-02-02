import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        // Create a PriorityQueue (Min-Heap by default)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Adding elements to the PriorityQueue
        pq.add(30);
        pq.add(10);
        pq.add(20);
        pq.add(5);

        // Displaying the PriorityQueue
        System.out.println("PriorityQueue: " + pq);

        // Removing elements from the PriorityQueue (smallest element first)
        System.out.println("Polled element: " + pq.poll());
        System.out.println("PriorityQueue after poll: " + pq);

        // Peeking the top element without removing
        System.out.println("Top element: " + pq.peek());
    }
}
