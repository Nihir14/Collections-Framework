package linkedlist;

/**
 * DoublyLinkedListImplementation is a test class used to
 * demonstrate and verify the working of
 * {@link CustomDoublyLinkedList}.
 *
 * <p>
 * This class focuses on:
 * <ul>
 *   <li>Adding elements to a doubly linked list</li>
 *   <li>Removing an element by value</li>
 *   <li>Accessing elements by index</li>
 *   <li>Checking size and empty state</li>
 * </ul>
 * </p>
 *
 * <p>
 * The intent of this class is to understand how
 * forward and backward links behave during operations.
 * </p>
 *
 * @author Nihir
 */
public class DoublyLinkedListImplementation {

    /**
     * Entry point for testing CustomDoublyLinkedList.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        /* -------------------------------------------------
         * 1. CREATE CUSTOM DOUBLY LINKED LIST
         * ------------------------------------------------- */

        CustomDoublyLinkedList list = new CustomDoublyLinkedList();

        /* -------------------------------------------------
         * 2. ADD ELEMENTS
         * -------------------------------------------------
         *
         * add(value):
         * - Inserts elements at the end
         * - Updates both next and prev pointers
         * - Runs in O(1) time due to tail reference
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
         * - Traverses the list to find the value
         * - Updates both next and prev links
         * - Handles head, middle, and tail removal
         */

        list.remove(3);
        System.out.println("After removing 3: " + list);

        /* -------------------------------------------------
         * 4. ACCESS ELEMENT BY INDEX
         * -------------------------------------------------
         *
         * get(index):
         * - Traverses from the head
         * - Time complexity O(n)
         */

        System.out.println("Element at index 2: " + list.get(2));

        /* -------------------------------------------------
         * 5. SIZE AND EMPTY CHECKS
         * ------------------------------------------------- */

        System.out.println("Size of the list: " + list.getSize());
        System.out.println("Is the list empty? " + list.isEmpty());
    }
}
