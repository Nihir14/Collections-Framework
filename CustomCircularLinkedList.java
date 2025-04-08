public class CustomCircularLinkedList {

    private Node last;
    private int size;

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public boolean add(int value) {
        Node newNode = new Node(value);
        if (last == null) {
            last = newNode;
            last.next = last; // Point to itself
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
        size++;
        return true;
    }

    public boolean remove(int value) {
        if (last == null) {
            return false; // List is empty
        }

        Node current = last.next;
        Node previous = last;

        do {
            if (current.value == value) {
                if (current == last) {
                    if (last.next == last) {
                        last = null; // Only one element in the list
                    } else {
                        previous.next = current.next;
                        last = previous;
                    }
                } else {
                    previous.next = current.next;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        } while (current != last.next);

        return false; // Value not found
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        if (last == null) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        Node current = last.next;

        do {
            sb.append(current.value).append(" -> ");
            current = current.next;
        } while (current != last.next);

        sb.append("(back to start)");
        return sb.toString();
    }
}