package collections;

import java.util.Vector;

/**
 * Test_05_List_Vector demonstrates the usage and internal
 * working of {@link java.util.Vector}.
 *
 * <p>
 * Vector is a legacy List implementation that is:
 * <ul>
 *   <li>Thread-safe (synchronized)</li>
 *   <li>Resizable array-based collection</li>
 *   <li>Allows duplicates</li>
 *   <li>Allows null elements</li>
 * </ul>
 * </p>
 *
 * <p>
 * Internally, Vector is similar to ArrayList but:
 * <ul>
 *   <li>All public methods are synchronized</li>
 *   <li>Capacity grows differently</li>
 * </ul>
 * </p>
 *
 * <p>
 * This class demonstrates:
 * <ul>
 *   <li>Capacity vs size</li>
 *   <li>Duplicate handling</li>
 *   <li>equals() usage in contains()</li>
 *   <li>Additional Vector operations</li>
 * </ul>
 * </p>
 *
 * @author Nihir
 */
public class Test_05_List_Vector {

    /**
     * Entry point for Vector behavior demonstration.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        /* -------------------------------------------------
         * 1. CREATE VECTOR
         * ------------------------------------------------- */

        Vector<Object> v = new Vector<>();

        System.out.println("==== INITIAL STATE ====");
        System.out.println("Capacity : " + v.capacity()); // default = 10
        System.out.println("Size     : " + v.size());
        System.out.println("Elements : " + v);
        System.out.println();

        /* -------------------------------------------------
         * 2. ADD ELEMENTS (DUPLICATES ALLOWED)
         * ------------------------------------------------- */

        System.out.println("==== ADDING ELEMENTS ====");

        v.add("a");               System.out.println(v);
        v.add("b");               System.out.println(v);
        v.add("c");               System.out.println(v);
        v.add(5);                 System.out.println(v);
        v.add(6.7);               System.out.println(v);
        v.add(new Ex(5, 6));      System.out.println(v);
        v.add(new Sa(5, 6));      System.out.println(v);
        v.add("b");               System.out.println(v);
        v.add("a");               System.out.println(v);
        v.add(new Ex(5, 6));      System.out.println(v);
        v.add(5);                 System.out.println(v);
        v.add("b");               System.out.println(v);
        v.add(6.7);               System.out.println(v);
        v.add("b");               System.out.println(v);

        System.out.println("\nAfter additions:");
        System.out.println("Capacity : " + v.capacity());
        System.out.println("Size     : " + v.size());
        System.out.println();

        /* -------------------------------------------------
         * 3. CONTAINS OPERATION
         * -------------------------------------------------
         *
         * contains() internally uses equals()
         */

        System.out.println("==== CONTAINS CHECK ====");
        System.out.println("Contains Ex(5,6) : " + v.contains(new Ex(5, 6)));
        System.out.println("Contains Sa(5,6) : " + v.contains(new Sa(5, 6)));
        System.out.println();

        /* -------------------------------------------------
         * 4. INDEX-BASED OPERATIONS
         * ------------------------------------------------- */

        System.out.println("==== INDEX OPERATIONS ====");
        System.out.println("Element at index 3 : " + v.get(3));

        Object old = v.set(3, 100);
        System.out.println("Replaced " + old + " with 100");
        System.out.println(v);

        v.add(2, "INSERTED");
        System.out.println("After inserting at index 2:");
        System.out.println(v);

        System.out.println();

        /* -------------------------------------------------
         * 5. REMOVE OPERATIONS
         * ------------------------------------------------- */

        System.out.println("==== REMOVE OPERATIONS ====");

        v.remove("b"); // removes first occurrence
        System.out.println("After removing 'b':");
        System.out.println(v);

        Object removed = v.remove(0);
        System.out.println("Removed element at index 0 : " + removed);
        System.out.println(v);

        System.out.println();

        /* -------------------------------------------------
         * 6. SEARCH OPERATIONS
         * ------------------------------------------------- */

        System.out.println("==== SEARCH OPERATIONS ====");
        System.out.println("Index of 'a'       : " + v.indexOf("a"));
        System.out.println("Last index of 'b'  : " + v.lastIndexOf("b"));
        System.out.println();

        /* -------------------------------------------------
         * 7. ITERATION
         * ------------------------------------------------- */

        System.out.println("==== ITERATION ====");
        for (Object obj : v) {
            System.out.print(obj + " | ");
        }
        System.out.println("\n");

        /* -------------------------------------------------
         * 8. CLEAR VECTOR
         * ------------------------------------------------- */

        System.out.println("==== CLEAR ====");
        v.clear();
        System.out.println("After clear:");
        System.out.println("Size     : " + v.size());
        System.out.println("Is Empty : " + v.isEmpty());
        System.out.println(v);
    }
}
