package collections;

import java.util.LinkedHashSet;

/**
 * Test_02_Set_LinkedHashSet is a learning-oriented test class
 * that demonstrates the behavior and internal working
 * of {@link java.util.LinkedHashSet}.
 *
 * <p>
 * This class helps understand:
 * <ul>
 *   <li>How LinkedHashSet stores elements</li>
 *   <li>How duplicates are detected</li>
 *   <li>How insertion order is preserved</li>
 *   <li>Difference between HashSet and LinkedHashSet</li>
 * </ul>
 * </p>
 *
 * <p>
 * Internally, LinkedHashSet is backed by:
 * <b>LinkedHashMap&lt;E, Object&gt;</b>
 * </p>
 *
 * <p>
 * LinkedHashSet maintains a <b>doubly linked list</b>
 * of entries, which preserves insertion order.
 * </p>
 *
 * @author Nihir
 */
public class Test_02_Set_LinkedHashSet {

    /**
     * Entry point for LinkedHashSet behavior demonstration.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        /* -------------------------------------------------
         * 1. CREATE LINKEDHASHSET
         * ------------------------------------------------- */

        LinkedHashSet<Object> lhs = new LinkedHashSet<>();

        // Initial state
        System.out.println("==== INITIAL STATE ====");
        System.out.println("Is Empty : " + lhs.isEmpty());
        System.out.println("Size     : " + lhs.size());
        System.out.println("Set      : " + lhs);

        System.out.println();

        /* -------------------------------------------------
         * 2. ADDING ELEMENTS
         * ------------------------------------------------- */

        System.out.println("==== ADDING ELEMENTS ====");

        lhs.add("a");
        lhs.add("b");
        lhs.add(5);
        lhs.add(6.7);
        lhs.add(true);
        lhs.add(null);
        lhs.add(new A(5, 6));
        lhs.add("a");              // duplicate
        lhs.add(5);                // duplicate
        lhs.add(new A(5, 6));      // duplicate if equals() is correct
        lhs.add(new A(7, 8));

        A a4 = new A(3, 4);
        lhs.add(a4);
        lhs.add(a4);               // duplicate reference

        lhs.add(null);             // duplicate null

        System.out.println("LinkedHashSet Content:");
        System.out.println(lhs);

        /* -------------------------------------------------
         * 3. OBSERVE ORDER
         * ------------------------------------------------- */

        System.out.println("\n==== ORDER OBSERVATION ====");
        System.out.println("Notice: Elements are printed");
        System.out.println("in the SAME order they were added.");

        /* -------------------------------------------------
         * 4. FINAL STATE
         * ------------------------------------------------- */

        System.out.println("\n==== FINAL STATE ====");
        System.out.println("Size     : " + lhs.size());
        System.out.println("Is Empty : " + lhs.isEmpty());
    }
}
