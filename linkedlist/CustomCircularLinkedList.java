package linkedlist;

/**
 * CustomCircularLinkedList is a custom implementation of a
 * Circular Singly Linked List.
 *
 * <p>
 * In a Circular Linked List:
 * <ul>
 *   <li>The last node points back to the first node</li>
 *   <li>There is no null reference in next pointers</li>
 *   <li>The list forms a closed loop</li>
 * </ul>
 * </p>
 *
 * <p>
 * This implementation maintains only a reference to
 * the <b>last (tail)</b> node.
 * From the last node, the first node can always be accessed
 * using {@code last.next}.
 * </p>
 *
 * <h3>Why store only last?</h3>
 * <ul>
 *   <li>Access to both head and tail is possible</li>
 *   <li>Insertion at end becomes O(1)</li>
 *   <li>Less memory than storing both first and last</li>
 * </ul>
 *
 * <h3>Time Complexity</h3>
 * <ul>
 *   <li>Add → O(1)</li>
 *   <li>Remove → O(n)</li>
 *   <li>Traversal → O(n)</li>
 * </ul>
 *
 * @author Nihir
 */
public class CustomCircularLinkedList {

    /** Reference to the last (tail) node */
    private Node last;

    /** Number of elements in the list */
    private int size;

    /**
     * Node represents a single element in the circular linked list.
     *
     * <p>
     * Each node contains:
     * <ul>
     *   <li>Data (value)</li>
     *   <li>Reference to the next node</li>
     * </ul>
     *
     * The next reference of the last node points back
     * to the first node.
     * </p>
     */
    private class Node {

        /** Data stored in the node */
        private int value;

        /** Reference to the next node */
        private Node next;

        /**
         * Creates a node with the given value.
         *
         * @param value data to store
         */
        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * Adds a new value to the circular linked list.
     *
     * <p>
     * Logic:
     * <ul>
     *   <li>If list is empty:
     *       <ul>
     *         <li>last points to new node</li>
     *         <li>new node points to itself</li>
     *       </ul>
     *   </li>
     *   <li>If list is not empty:
     *       <ul>
     *         <li>new node points to first (last.next)</li>
     *         <li>last.next points to new node</li>
     *         <li>last is updated to new node</li>
     *       </ul>
     *   </li>
     * </ul>
     * </p>
     *
     * @param value value to add
     * @return true after successful insertion
     */
    public boolean add(int value) {

        Node newNode = new Node(value);

        if (last == null) {
            // First node in the list
            last = newNode;
            last.next = last;   // Circular link to itself
        } else {
            newNode.next = last.next; // new node → first
            last.next = newNode;      // old last → new node
            last = newNode;           // update tail
        }

        size++;
        return true;
    }

    /**
     * Removes the first occurrence of the specified value.
     *
     * <p>
     * Logic:
     * <ul>
     *   <li>Start from first node (last.next)</li>
     *   <li>Traverse until we come back to the start</li>
     *   <li>Handle:
     *     <ul>
     *       <li>Removing the only node</li>
     *       <li>Removing the last node</li>
     *       <li>Removing a middle node</li>
     *     </ul>
     *   </li>
     * </ul>
     * </p>
     *
     * @param value value to remove
     * @return true if removed, false otherwise
     */
    public boolean remove(int value) {

        if (last == null) {
            return false; // list is empty
        }

        Node current = last.next; // start from first
        Node previous = last;

        do {
            if (current.value == value) {

                /* ---------- CASE 1: ONLY ONE NODE ---------- */
                if (current == last && current.next == last) {
                    last = null;
                }
                /* ---------- CASE 2: REMOVING LAST NODE ---------- */
                else if (current == last) {
                    previous.next = current.next;
                    last = previous;
                }
                /* ---------- CASE 3: REMOVING FIRST / MIDDLE ---------- */
                else {
                    previous.next = current.next;
                }

                size--;
                return true;
            }

            previous = current;
            current = current.next;

        } while (current != last.next);

        return false; // value not found
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return size of list
     */
    public int getSize() {
        return size;
    }

    /**
     * Checks whether the list is empty.
     *
     * @return true if list has no elements
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns a string representation of the circular list.
     *
     * <p>
     * Format:
     * <pre>
     * 10 -> 20 -> 30 -> (back to start)
     * </pre>
     * </p>
     */
    @Override
    public String toString() {

        if (last == null) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        Node current = last.next; // start from first

        do {
            sb.append(current.value).append(" -> ");
            current = current.next;
        } while (current != last.next);

        sb.append("(back to start)");
        return sb.toString();
    }
}
