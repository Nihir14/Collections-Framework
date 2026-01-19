package collections;

import java.util.HashSet;

/**
 * Test_01_Set_HashSet is a learning-oriented test class
 * that demonstrates the behavior and internal working
 * of {@link java.util.HashSet}.
 *
 * <p>
 * This class helps understand:
 * <ul>
 *   <li>How HashSet stores elements</li>
 *   <li>How duplicates are detected</li>
 *   <li>Role of hashCode() and equals()</li>
 *   <li>Handling of null values</li>
 *   <li>Return value of add()</li>
 * </ul>
 * </p>
 *
 * <p>
 * Internally, HashSet uses:
 * <b>HashMap<E, Object></b>
 * </p>
 *
 * @author Nihir
 */
public class Test_01_Set_HashSet {

    /**
     * Entry point for HashSet behavior demonstration.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        /* -------------------------------------------------
         * 1. CREATE HASHSET
         * ------------------------------------------------- */

        HashSet<Object> hs = new HashSet<>();

        // Initial state
        System.out.println("Is Empty : " + hs.isEmpty()); // true
        System.out.println("Size     : " + hs.size());    // 0
        System.out.println("Set      : " + hs);           // []

        System.out.println();

        /* -------------------------------------------------
         * 2. ADDING ELEMENTS (add() METHOD)
         * ------------------------------------------------- */

        /*
         * Internally add(element) does:
         *
         * 1. Calls hashCode() of element
         * 2. Finds bucket index using hash
         * 3. If bucket is empty → store element → return true
         * 4. If bucket has elements:
         *      - call equals() to check duplicate
         *      - if equals() == true → DO NOT STORE → return false
         *      - else → store → return true
         */

        hs.add("a");        // stored
        hs.add("b");        // stored
        hs.add(5);          // stored
        hs.add(6.7);        // stored
        hs.add(true);       // stored
        hs.add(null);       // stored (HashSet allows ONE null)

        /*
         * Custom object insertion
         * Duplicate detection depends on:
         * - hashCode()
         * - equals()
         */
        hs.add(new A(5, 6));    // stored
        hs.add("a");            // duplicate → ignored
        hs.add(5);              // duplicate → ignored
        hs.add(new A(5, 6));    // duplicate if equals() is overridden
        hs.add(new A(7, 8));    // stored

        /*
         * Same object reference
         */
        A a4 = new A(3, 4);
        hs.add(a4);             // stored
        hs.add(a4);             // duplicate reference → ignored

        /*
         * Multiple null insertions
         */
        hs.add(null);           // duplicate null → ignored
        hs.add(null);           // ignored

        /* -------------------------------------------------
         * 3. FINAL STATE
         * ------------------------------------------------- */

        System.out.println("Final Set : " + hs);
        System.out.println("Size      : " + hs.size());
        System.out.println("Is Empty  : " + hs.isEmpty());
    }
}
