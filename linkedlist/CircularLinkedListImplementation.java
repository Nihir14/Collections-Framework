package linkedlist;

public class CircularLinkedListImplementation {
    public static void main(String[] args) {
        CustomCircularLinkedList list = new CustomCircularLinkedList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("Original List: " + list);

        list.remove(3);
        System.out.println("After removing 3: " + list);

        System.out.println("Size of the list: " + list.getSize());
        System.out.println("Is the list empty? " + list.isEmpty());
    }
}