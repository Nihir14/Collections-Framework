package linkedlist;

public class LinkedListImplementation {
    public static void main(String[] args) {
        CustomSinglyLinkedList list = new CustomSinglyLinkedList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("Original List: " + list);
        list.reverseRecursively();
        System.out.println("Reversed List: " + list);


        list.insertAtPositionRecursively(list.getFirst(), 10, 2);
        System.out.println(list);
    }
}
