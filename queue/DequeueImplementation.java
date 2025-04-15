package queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeueImplementation {
    public static void main(String[] args) {
        Deque<Integer> deck = new ArrayDeque<>();

        // Adding elements to the deque
        deck.add(10);
        deck.add(20);
        deck.add(30);
        deck.add(40);
        deck.add(50);
        System.out.println("Deque after adding elements: " + deck);

        // Removing elements from the front of the deque

        int removedFromFront = deck.removeFirst();
        System.out.println("Removed from front: " + removedFromFront);

        // Removing elements from the back of the deque

        int removedFromBack = deck.removeLast();
        System.out.println("Removed from back: " + removedFromBack);

        // Adding elements to the front of the deque

        deck.addFirst(5);
        System.out.println("Deque after adding 5 to the front: " + deck);

        // Adding elements to the back of the deque

        deck.addLast(60);
        System.out.println("Deque after adding 60 to the back: " + deck);
    }




}
