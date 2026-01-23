package linkedlist;

/**
 * InsertionUsingRecursion is a test class used to
 * demonstrate insertion into a singly linked list
 * using a recursive approach.
 *
 * <p>
 * This class specifically tests the method:
 * {@link CustomSinglyLinkedList#insertAtPositionRecursively}
 * </p>
 *
 * <p>
 * The goal is to understand:
 * <ul>
 *   <li>How recursion replaces iteration in traversal</li>
 *   <li>How nodes are linked during stack unwinding</li>
 *   <li>How insertion at a given position works internally</li>
 * </ul>
 * </p>
 *
 * @author Nihir
 */
public class InsertionUsingRecursion {

    /**
     * Entry point for testing recursive insertion
     * in CustomSinglyLinkedList.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        /* -------------------------------------------------
         * 1. CREATE SINGLY LINKED LIST
         * ------------------------------------------------- */

        CustomSinglyLinkedList list = new CustomSinglyLinkedList();

        /* -------------------------------------------------
         * 2. ADD INITIAL ELEMENTS
         * -------------------------------------------------
         *
         * List after additions:
         * 10 -> 20 -> 30 -> 40 -> 50
         */

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        System.out.println("Original List: " + list);

        /* -------------------------------------------------
         * 3. INSERT USING RECURSION
         * -------------------------------------------------
         *
         * insertAtPositionRecursively(startNode, value, position)
         *
         * Parameters:
         * - startNode : list.getFirst() → head of list
         * - value     : 35 → value to insert
         * - position  : 3  → index where insertion happens
         *
         * Step-by-step idea:
         * - Recursive calls move forward node by node
         * - Position is reduced in each call
         * - When position becomes 0:
         *     → new node is created
         *     → linked with remaining nodes
         * - During return phase:
         *     → links are restored automatically
         */

        list.insertAtPositionRecursively(
                list.getFirst(), // head node
                35,               // value to insert
                3                 // position
        );

        /* -------------------------------------------------
         * 4. FINAL LIST STATE
         * -------------------------------------------------
         *
         * Expected output:
         * 10 -> 20 -> 30 -> 35 -> 40 -> 50
         */

        System.out.println("After recursive insertion: " + list);
    }
}
