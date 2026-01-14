package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueImplementation {
    public static void main(String[] args) {
        Queue<Integer> que = new LinkedList<>();


        // Enqueue elements into the queue
        que.add(1);
        que.add(2);
        que.add(3);
        System.out.println("Queue after enqueueing elements: " + que);

        // Dequeue an element from the queue
        System.out.println(que.peek());
    }
}
