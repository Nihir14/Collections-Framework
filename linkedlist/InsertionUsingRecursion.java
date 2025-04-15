package linkedlist;

public class InsertionUsingRecursion {
    public static void main(String[] args) {
        CustomSinglyLinkedList list = new CustomSinglyLinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        System.out.println(list);
        list.insertAtPositionRecursively(list.getFirst(),35, 3);
        System.out.println(list);
    }

}
