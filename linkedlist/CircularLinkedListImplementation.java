package linkedlist;

/**
 * CircularLinkedListImplementation is a test class used to
 * demonstrate and validate the behavior of
 * {@link CustomCircularLinkedList}.
 *
 * <p>
 * This class focuses on:
 * <ul>
 *   <li>Adding elements to a circular linked list</li>
 *   <li>Removing an element by value</li>
 *   <li>Understanding circular traversal</li>
 *   <li>Checking size and empty state</li>
 * </ul>
 * </p>
 *
 * <p>
 * The main goal is to visualize how the last node
 * points back to the first node instead of {@code null}.
 * </p>
 *
 * @author Nihir
 */
public class CircularLinkedListImplementation {

    /**
     * Entry point for testing CustomCircularLinkedList.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        /* -------------------------------------------------
         * 1. CREATE CUSTOM CIRCULAR LINKED LIST
         * ------------------------------------------------- */

        CustomCircularLinkedList list = new CustomCircularLinkedList();

        /* -------------------------------------------------
         * 2. ADD ELEMENTS
         * -------------------------------------------------
         *
         * add(value):
         * - Inserts elements at the end of the list
         * - Maintains circular linkage (last.next → first)
         * - Runs in O(1) time
         */

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println("Original List: " + list);

        /* -------------------------------------------------
         * 3. REMOVE ELEMENT
         * -------------------------------------------------
         *
         * remove(value):
         * - Traverses the circular list
         * - Stops traversal when it reaches the start again
         * - Updates links correctly based on removal position
         */

        list.remove(3);
        System.out.println("After removing 3: " + list);

        /* -------------------------------------------------
         * 4. SIZE AND EMPTY CHECKS
         * ------------------------------------------------- */

        System.out.println("Size of the list: " + list.getSize());
        System.out.println("Is the list empty? " + list.isEmpty());
    }
}
