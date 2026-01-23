package linkedlist;

/**
 * CustomDoublyLinkedList is a custom implementation of a
 * Doubly Linked List data structure.
 *
 * <p>
 * In a Doubly Linked List, each node contains:
 * <ul>
 *   <li>Data (value)</li>
 *   <li>Reference to the next node</li>
 *   <li>Reference to the previous node</li>
 * </ul>
 * </p>
 *
 * <p>
 * This implementation maintains references to:
 * <ul>
 *   <li>first (head)</li>
 *   <li>last (tail)</li>
 * </ul>
 * which allows efficient insertion and deletion at both ends.
 * </p>
 *
 * <h3>Time Complexity</h3>
 * <ul>
 *   <li>Add at end → O(1)</li>
 *   <li>Get by index → O(n)</li>
 *   <li>Remove by value → O(n)</li>
 * </ul>
 *
 * <p>
 * Compared to a Singly Linked List, a Doubly Linked List:
 * <ul>
 *   <li>Uses more memory</li>
 *   <li>Allows backward traversal</li>
 *   <li>Makes deletion easier (no need to track previous manually)</li>
 * </ul>
 * </p>
 *
 * @author Nihir
 */
public class CustomDoublyLinkedList {

    /** Number of elements in the list */
    private int size;

    /** Reference to the first node (head) */
    private Node first;

    /** Reference to the last node (tail) */
    private Node last;

    /**
     * Node represents an element of the doubly linked list.
     *
     * <p>
     * Each node stores references to both:
     * <ul>
     *   <li>Next node</li>
     *   <li>Previous node</li>
     * </ul>
     * </p>
     */
    private class Node {

        /** Data stored in the node */
        private int value;

        /** Reference to the next node */
        private Node next;

        /** Reference to the previous node */
        private Node prev;

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
     * Adds a new value at the end of the list.
     *
     * <p>
     * Logic:
     * <ul>
     *   <li>If list is empty → first & last point to new node</li>
     *   <li>Else → link last node with new node from both sides</li>
     * </ul>
     * </p>
     *
     * @param value value to add
     * @return true after successful insertion
     */
    public boolean add(int value) {

        Node node = new Node(value);

        if (last == null) {          // empty list
            first = node;
        } else {
            last.next = node;        // forward link
            node.prev = last;        // backward link
        }

        last = node;                 // update tail
        size++;
        return true;
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
     * Returns the value at the given index.
     *
     * <p>
     * Traversal is required because this is not
     * an array-based structure.
     * </p>
     *
     * @param index index of element
     * @return value at index
     * @throws IndexOutOfBoundsException if index is invalid
     */
    public Integer get(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size
            );
        }

        Node current = first;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.value;
    }

    /**
     * Removes the first occurrence of the specified value.
     *
     * <p>
     * Removal is easier in a Doubly Linked List because
     * each node has access to its previous node.
     * </p>
     *
     * <p>
     * Cases handled:
     * <ul>
     *   <li>Empty list</li>
     *   <li>Removing first node</li>
     *   <li>Removing middle node</li>
     *   <li>Removing last node</li>
     * </ul>
     * </p>
     *
     * @param value value to remove
     * @return true if removed, false otherwise
     */
    public boolean remove(int value) {

        if (first == null) {
            return false;
        }

        /* ---------- CASE 1: REMOVE FIRST NODE ---------- */
        if (first.value == value) {

            first = first.next;

            if (first != null) {
                first.prev = null;
            } else {
                last = null; // list became empty
            }

            size--;
            return true;
        }

        /* ---------- CASE 2: REMOVE MIDDLE / LAST ---------- */

        Node current = first;

        while (current != null && current.value != value) {
            current = current.next;
        }

        if (current == null) {
            return false; // value not found
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            last = current.prev; // removing last node
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        }

        size--;
        return true;
    }

    /**
     * Returns a string representation of the list.
     *
     * <p>
     * Format:
     * <pre>
     * 10 <-> 20 <-> 30
     * </pre>
     * </p>
     */
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        Node current = first;

        while (current != null) {
            sb.append(current.value);

            if (current.next != null) {
                sb.append(" <-> ");
            }
            current = current.next;
        }

        return sb.toString();
    }
}
