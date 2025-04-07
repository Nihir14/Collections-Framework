public class DoublyLinkedListImplementation {
    public static void main(String[] args) {
        CustomDoublyLinkedList list = new CustomDoublyLinkedList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("Original List: " + list);

        list.remove(3);
        System.out.println("After removing 3: " + list);

        System.out.println("Element at index 2: " + list.get(2));
        System.out.println("Size of the list: " + list.getSize());
        System.out.println("Is the list empty? " + list.isEmpty());
    }
}