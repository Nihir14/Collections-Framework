package linkedlist;

/**
 * CustomSinglyLinkedList is a custom implementation of a
 * Singly Linked List data structure.
 *
 * <p>
 * A Singly Linked List consists of nodes where each node
 * stores:
 * <ul>
 *   <li>Data (value)</li>
 *   <li>Reference to the next node</li>
 * </ul>
 * </p>
 *
 * <p>
 * This implementation maintains references to:
 * <ul>
 *   <li>first (head) node</li>
 *   <li>last (tail) node</li>
 * </ul>
 * to allow efficient insertion at the end.
 * </p>
 *
 * <p>
 * Time Complexity (common operations):
 * <ul>
 *   <li>Add (end) → O(1)</li>
 *   <li>Get (by index) → O(n)</li>
 *   <li>Remove (by value) → O(n)</li>
 *   <li>Reverse → O(n)</li>
 * </ul>
 * </p>
 *
 * @author Nihir
 */
public class CustomSinglyLinkedList {

    /** Number of elements present in the list */
    private int size;

    /** Reference to the first node (head) */
    private Node first;

    /** Reference to the last node (tail) */
    private Node last;

    /**
     * Node represents a single element in the linked list.
     *
     * <p>
     * It is defined as an inner class because:
     * <ul>
     *   <li>Node is tightly coupled with the list</li>
     *   <li>It should not be exposed outside</li>
     * </ul>
     * </p>
     */
    private class Node {

        /** Value stored in the node */
        private int value;

        /** Reference to the next node */
        private Node next;

        /**
         * Creates a node with value and next reference.
         *
         * @param value data to store
         * @param next reference to next node
         */
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        /**
         * Creates a node with value only.
         *
         * @param value data to store
         */
        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * Returns the first node of the list.
     *
     * @return head node
     */
    public Node getFirst() {
        return first;
    }

    /**
     * Returns the last node of the list.
     *
     * @return tail node
     */
    public Node getLast() {
        return last;
    }

    /**
     * Adds a new value at the end of the list.
     *
     * <p>
     * Logic:
     * <ul>
     *   <li>If list is empty → first & last point to new node</li>
     *   <li>Else → last.next points to new node</li>
     * </ul>
     * </p>
     *
     * @param value value to add
     * @return true after successful insertion
     */
    public boolean add(int value) {
        Node node = new Node(value);

        if (last == null) {           // list is empty
            first = node;
        } else {
            last.next = node;         // attach new node at end
        }

        last = node;                  // update tail
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
     * Returns the value at a given index.
     *
     * <p>
     * Since this is a linked list, traversal is required.
     * </p>
     *
     * @param index position of element
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

        // Move pointer index times
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.value;
    }

    /**
     * Removes the first occurrence of a given value.
     *
     * <p>
     * Logic:
     * <ul>
     *   <li>If list is empty → return false</li>
     *   <li>If value is at head → move head</li>
     *   <li>Else → bypass matching node</li>
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

        // Case 1: value at head
        if (first.value == value) {
            first = first.next;
            size--;

            if (first == null) {
                last = null; // list became empty
            }
            return true;
        }

        // Case 2: value in middle or end
        Node current = first;

        while (current.next != null && current.next.value != value) {
            current = current.next;
        }

        if (current.next == null) {
            return false; // value not found
        }

        current.next = current.next.next;
        size--;

        if (current.next == null) {
            last = current; // removed last node
        }

        return true;
    }

    /**
     * Returns a string representation of the list.
     *
     * <p>
     * Format:
     * <pre>
     * 10 -> 20 -> 30
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
                sb.append(" -> ");
            }
            current = current.next;
        }

        return sb.toString();
    }

    /**
     * Inserts a value at a given position using recursion.
     *
     * <p>
     * Each recursive call moves one node forward until
     * position becomes 0.
     * </p>
     *
     * @param node current node
     * @param value value to insert
     * @param position index position
     * @return updated node
     */
    public Node insertAtPositionRecursively(Node node,
                                            int value,
                                            int position) {

        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + position + ", Size: " + size
            );
        }

        // Base case: insert here
        if (position == 0) {
            Node newNode = new Node(value, node);
            size++;
            return newNode;
        }

        node.next = insertAtPositionRecursively(
                node.next, value, position - 1
        );

        return node;
    }

    /**
     * Reverses the list iteratively.
     *
     * <p>
     * Uses three pointers:
     * <ul>
     *   <li>previous</li>
     *   <li>current</li>
     *   <li>next</li>
     * </ul>
     * </p>
     */
    public void reverse() {

        Node previous = null;
        Node current = first;
        Node next;

        last = first; // old head becomes new tail

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        first = previous;
    }

    /**
     * Reverses the list using recursion.
     */
    public void reverseRecursively() {
        first = reverseRecursivelyHelper(first, null);
    }

    /**
     * Helper method for recursive reverse.
     *
     * @param current current node
     * @param previous previous node
     * @return new head of reversed list
     */
    private Node reverseRecursivelyHelper(Node current, Node previous) {

        if (current == null) {
            return previous;
        }

        Node next = current.next;
        current.next = previous;

        return reverseRecursivelyHelper(next, current);
    }
}
