package collections;

import java.util.LinkedList;

/**
 * Test_07_List_Deque_LinkedList demonstrates the usage and
 * internal working of {@link java.util.LinkedList}.
 *
 * <p>
 * LinkedList is a doubly-linked list implementation that
 * implements multiple interfaces:
 * <ul>
 *   <li>List</li>
 *   <li>Deque</li>
 *   <li>Queue</li>
 * </ul>
 * </p>
 *
 * <h2>Key Characteristics</h2>
 * <ul>
 *   <li>Allows duplicates</li>
 *   <li>Allows null elements</li>
 *   <li>Maintains insertion order</li>
 *   <li>Fast insertion & deletion (O(1))</li>
 *   <li>Slow random access (O(n))</li>
 * </ul>
 *
 * <p>
 * Internally, LinkedList uses a <b>doubly linked list</b>:
 * each node stores:
 * <ul>
 *   <li>Previous reference</li>
 *   <li>Data</li>
 *   <li>Next reference</li>
 * </ul>
 * </p>
 *
 * @author Nihir
 */
public class Test_07_List_Deque_LinkedList {

    public static void main(String[] args) {

        /* -------------------------------------------------
         * 1. CREATE LINKEDLIST
         * ------------------------------------------------- */

        LinkedList<Object> list = new LinkedList<>();

        System.out.println("==== INITIAL STATE ====");
        System.out.println(list);
        System.out.println("Size : " + list.size());
        System.out.println();

        /* -------------------------------------------------
         * 2. LIST OPERATIONS
         * ------------------------------------------------- */

        System.out.println("==== LIST OPERATIONS ====");

        list.add(1);
        list.add(2);
        list.add(3);
        list.add("a");
        list.add(null);
        list.add("a"); // duplicate allowed

        System.out.println("After add(): " + list);

        System.out.println("Element at index 2 : " + list.get(2));

        list.set(2, 100);
        System.out.println("After set(2,100): " + list);

        list.add(1, "INSERTED");
        System.out.println("After add at index 1: " + list);

        list.remove("a"); // removes first occurrence
        System.out.println("After remove('a'): " + list);

        System.out.println();

        /* -------------------------------------------------
         * 3. DEQUE OPERATIONS (DOUBLE ENDED QUEUE)
         * ------------------------------------------------- */

        System.out.println("==== DEQUE OPERATIONS ====");

        list.addFirst("FIRST");
        list.addLast("LAST");

        System.out.println("After addFirst & addLast: " + list);

        System.out.println("getFirst(): " + list.getFirst());
        System.out.println("getLast(): " + list.getLast());

        System.out.println("removeFirst(): " + list.removeFirst());
        System.out.println("removeLast(): " + list.removeLast());

        System.out.println("After deque removals: " + list);
        System.out.println();

        /* -------------------------------------------------
         * 4. QUEUE OPERATIONS (FIFO)
         * ------------------------------------------------- */

        System.out.println("==== QUEUE OPERATIONS ====");

        list.offer("Q1");
        list.offer("Q2");

        System.out.println("After offer(): " + list);

        System.out.println("peek(): " + list.peek()); // head element
        System.out.println("poll(): " + list.poll()); // removes head

        System.out.println("After poll(): " + list);
        System.out.println();

        /* -------------------------------------------------
         * 5. ITERATION
         * ------------------------------------------------- */

        System.out.println("==== ITERATION ====");
        for (Object o : list) {
            System.out.print(o + " | ");
        }
        System.out.println();

        /* -------------------------------------------------
         * 6. FINAL STATE
         * ------------------------------------------------- */

        System.out.println("\nFinal List: " + list);
        System.out.println("Size : " + list.size());
    }
}
