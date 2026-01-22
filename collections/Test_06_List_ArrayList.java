package collections;

import java.util.ArrayList;

/**
 * Test_06_List_ArrayList demonstrates the behavior and
 * internal working of {@link java.util.ArrayList}.
 *
 * <p>
 * ArrayList is a modern, non-synchronized, resizable
 * array implementation of the List interface.
 * </p>
 *
 * <h2>Key Characteristics of ArrayList</h2>
 * <ul>
 *   <li>Not thread-safe</li>
 *   <li>Fast performance</li>
 *   <li>Allows duplicates</li>
 *   <li>Allows null elements</li>
 *   <li>Maintains insertion order</li>
 * </ul>
 *
 * <p>
 * This class also highlights the differences between
 * ArrayList and Vector using practical examples.
 * </p>
 *
 * @author Nihir
 */
public class Test_06_List_ArrayList {

    /**
     * Entry point for ArrayList behavior demonstration.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        /* -------------------------------------------------
         * 1. CREATE ARRAYLIST
         * ------------------------------------------------- */

        ArrayList<Object> al = new ArrayList<>();

        System.out.println("==== INITIAL STATE ====");
        System.out.println("Size     : " + al.size());
        System.out.println("Elements : " + al);
        System.out.println();

        /* -------------------------------------------------
         * 2. ADD ELEMENTS
         * -------------------------------------------------
         *
         * ArrayList:
         * - Allows duplicates
         * - Allows null values
         * - Maintains insertion order
         */

        System.out.println("==== ADDING ELEMENTS ====");

        al.add("a");               System.out.println(al);
        al.add("b");               System.out.println(al);
        al.add("c");               System.out.println(al);
        al.add(5);                 System.out.println(al);
        al.add(6.7);               System.out.println(al);
        al.add(new Ex(5, 6));      System.out.println(al);
        al.add(new Sa(5, 6));      System.out.println(al);
        al.add("b");               System.out.println(al);
        al.add("a");               System.out.println(al);
        al.add(new Ex(5, 6));      System.out.println(al);
        al.add(5);                 System.out.println(al);
        al.add("b");               System.out.println(al);
        al.add(6.7);               System.out.println(al);
        al.add("b");               System.out.println(al);
        al.add(null);              System.out.println(al);
        al.add(null);              System.out.println(al);

        System.out.println("\nAfter additions:");
        System.out.println("Size : " + al.size());
        System.out.println();

        /* -------------------------------------------------
         * 3. CONTAINS OPERATION
         * -------------------------------------------------
         *
         * contains() internally uses equals()
         */

        System.out.println("==== CONTAINS CHECK ====");
        System.out.println("Contains Ex(5,6) : " + al.contains(new Ex(5, 6)));
        System.out.println("Contains Sa(5,6) : " + al.contains(new Sa(5, 6)));
        System.out.println("Contains null    : " + al.contains(null));
        System.out.println();

        /* -------------------------------------------------
         * 4. INDEX-BASED OPERATIONS
         * ------------------------------------------------- */

        System.out.println("==== INDEX OPERATIONS ====");

        System.out.println("Element at index 3 : " + al.get(3));

        Object old = al.set(3, 100);
        System.out.println("Replaced " + old + " with 100");
        System.out.println(al);

        al.add(2, "INSERTED");
        System.out.println("After inserting at index 2:");
        System.out.println(al);
        System.out.println();

        /* -------------------------------------------------
         * 5. REMOVE OPERATIONS
         * ------------------------------------------------- */

        System.out.println("==== REMOVE OPERATIONS ====");

        al.remove("b"); // removes first occurrence
        System.out.println("After removing first 'b':");
        System.out.println(al);

        Object removed = al.remove(0);
        System.out.println("Removed element at index 0 : " + removed);
        System.out.println(al);
        System.out.println();

        /* -------------------------------------------------
         * 6. SEARCH OPERATIONS
         * ------------------------------------------------- */

        System.out.println("==== SEARCH OPERATIONS ====");
        System.out.println("Index of 'a'      : " + al.indexOf("a"));
        System.out.println("Last index of 'b' : " + al.lastIndexOf("b"));
        System.out.println();

        /* -------------------------------------------------
         * 7. ITERATION
         * ------------------------------------------------- */

        System.out.println("==== ITERATION ====");
        for (Object obj : al) {
            System.out.print(obj + " | ");
        }
        System.out.println("\n");

        /* -------------------------------------------------
         * 8. CLEAR LIST
         * ------------------------------------------------- */

        System.out.println("==== CLEAR ====");
        al.clear();
        System.out.println("After clear:");
        System.out.println("Size     : " + al.size());
        System.out.println("Is Empty : " + al.isEmpty());
        System.out.println(al);
    }
}
