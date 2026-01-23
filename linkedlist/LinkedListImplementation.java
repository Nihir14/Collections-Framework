package linkedlist;

/**
 * LinkedListImplementation is a test class used to
 * demonstrate and validate the functionality of
 * {@link CustomSinglyLinkedList}.
 *
 * <p>
 * This class focuses on:
 * <ul>
 *   <li>Adding elements to the list</li>
 *   <li>Printing the list structure</li>
 *   <li>Reversing the list using recursion</li>
 *   <li>Inserting an element at a specific position using recursion</li>
 * </ul>
 * </p>
 *
 * <p>
 * The goal of this class is to understand:
 * <ul>
 *   <li>How pointers change during reverse</li>
 *   <li>How recursive insertion works internally</li>
 * </ul>
 * </p>
 *
 * @author Nihir
 */
public class LinkedListImplementation {

    /**
     * Entry point for testing CustomSinglyLinkedList.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        /* -------------------------------------------------
         * 1. CREATE CUSTOM LINKED LIST
         * ------------------------------------------------- */

        CustomSinglyLinkedList list = new CustomSinglyLinkedList();

        /* -------------------------------------------------
         * 2. ADD ELEMENTS
         * -------------------------------------------------
         *
         * add(value) always inserts at the end of the list.
         * Because the list maintains a 'last' reference,
         * insertion happens in O(1) time.
         */

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println("Original List: " + list);

        /* -------------------------------------------------
         * 3. REVERSE LIST (RECURSIVELY)
         * -------------------------------------------------
         *
         * reverseRecursively():
         * - Uses call stack instead of loops
         * - Reverses links one by one
         * - Returns new head at the end
         */

        list.reverseRecursively();
        System.out.println("Reversed List: " + list);

        /* -------------------------------------------------
         * 4. INSERT AT POSITION (RECURSIVELY)
         * -------------------------------------------------
         *
         * insertAtPositionRecursively():
         * - Traverses using recursion
         * - When position == 0, creates new node
         * - Links remaining nodes back during stack unwind
         *
         * NOTE:
         * Since this method returns the updated head,
         * we pass list.getFirst() to start recursion.
         */

        list.insertAtPositionRecursively(
                list.getFirst(), // starting node (head)
                10,              // value to insert
                2                // position
        );

        System.out.println("After inserting 10 at position 2: " + list);
    }
}
