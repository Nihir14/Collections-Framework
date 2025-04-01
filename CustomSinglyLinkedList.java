public class CustomSinglyLinkedList {

    private int size;

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    private Node first;
    private Node last;

    private class Node {
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public boolean add(int value) {
        Node node = new Node(value);
        if (last == null) {
            first = node;
        } else {
            last.next = node;
        }
        last = node;
        size++;
        return true;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Integer get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    public boolean remove(int value) {
        if (first == null) {
            return false;
        }
        if (first.value == value) {
            first = first.next;
            size--;
            if (first == null) {
                last = null;
            }
            return true;
        }
        Node current = first;
        while (current.next != null && current.next.value != value) {
            current = current.next;
        }
        if (current.next == null) {
            return false;
        }
        current.next = current.next.next;
        size--;
        if (current.next == null) {
            last = current;
        }
        return true;
    }

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



    public Node insertAtPositionRecursively(Node node, int value, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Index: " + position + ", Size: " + size);
        }
        if (position == 0) {
            Node newNode = new Node(value, node);
            size++;
            return newNode;
        }
        node.next = insertAtPositionRecursively(node.next, value, position - 1);
        return node;
    }
}