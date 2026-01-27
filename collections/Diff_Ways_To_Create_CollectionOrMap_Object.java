package collections;

import java.util.*;

/**
 * Diff_Ways_To_Create_CollectionOrMap_Object
 *
 * <p>
 * This class demonstrates the THREE MAIN and MOST IMPORTANT
 * approaches to create Collection and Map objects in Java.
 * </p>
 *
 * <h2>Covered Approaches</h2>
 * <ol>
 *   <li>Using new keyword + constructor</li>
 *   <li>Using interface reference (programming to interface)</li>
 *   <li>Using factory methods: List.of(), Set.of(), Map.of()</li>
 * </ol>
 *
 * <p>
 * For each approach, examples are shown for:
 * <ul>
 *   <li>List</li>
 *   <li>Set</li>
 *   <li>Map</li>
 * </ul>
 *
 * <p>
 * All invalid operations and runtime errors are
 * intentionally kept as commented lines for learning.
 * </p>
 *
 * @author Nihir
 */
public class Diff_Ways_To_Create_CollectionOrMap_Object {

    public static void main(String[] args) {

        /* =========================================================
         * APPROACH 1: USING new KEYWORD + CONSTRUCTOR
         * (Traditional & Fully Mutable)
         * ========================================================= */

        /* ---------------- LIST ---------------- */
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(10);
        list1.add(20);
        list1.add(10);   // duplicates allowed
        list1.add(null); // null allowed
        System.out.println("Approach 1 - List : " + list1);

        /* ---------------- SET ---------------- */
        HashSet<Integer> set1 = new HashSet<>();
        set1.add(10);
        set1.add(10);    // duplicate ignored
        set1.add(null);  // null allowed
        System.out.println("Approach 1 - Set  : " + set1);

        /* ---------------- MAP ---------------- */
        HashMap<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("A", 2);   // value replaced
        map1.put(null, 3);  // one null key allowed
        System.out.println("Approach 1 - Map  : " + map1);



        /* =========================================================
         * APPROACH 2: USING INTERFACE REFERENCE
         * (BEST PRACTICE – PROGRAM TO INTERFACE)
         * ========================================================= */

        /* ---------------- LIST ---------------- */
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(null);
        System.out.println("Approach 2 - List : " + list2);

        // Implementation can be changed easily
        // List<Integer> list2 = new LinkedList<>();

        /* ---------------- SET ---------------- */
        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(1); // duplicate ignored
        System.out.println("Approach 2 - Set  : " + set2);

        /* ---------------- MAP ---------------- */
        Map<String, String> map2 = new HashMap<>();
        map2.put("key", "value");
        System.out.println("Approach 2 - Map  : " + map2);



        /* =========================================================
         * APPROACH 3: USING List.of(), Set.of(), Map.of()
         * (Java 9+ IMMUTABLE COLLECTIONS)
         * ========================================================= */

        /* ---------------- LIST ---------------- */
        List<Integer> list3 = List.of(10, 20, 30);
        System.out.println("Approach 3 - List : " + list3);

        // ❌ list3.add(40);        // UnsupportedOperationException
        // ❌ list3.remove(10);     // UnsupportedOperationException
        // ❌ List.of(10, 10);      // IllegalArgumentException (duplicate)
        // ❌ List.of(10, null);    // NullPointerException


        /* ---------------- SET ---------------- */
        Set<Integer> set3 = Set.of(1, 2, 3);
        System.out.println("Approach 3 - Set  : " + set3);

        // ❌ set3.add(4);          // UnsupportedOperationException
        // ❌ Set.of(1, 1);         // IllegalArgumentException (duplicate)
        // ❌ Set.of(1, null);      // NullPointerException


        /* ---------------- MAP ---------------- */
        Map<String, Integer> map3 = Map.of(
                "A", 1,
                "B", 2
        );
        System.out.println("Approach 3 - Map  : " + map3);

        // ❌ map3.put("C", 3);     // UnsupportedOperationException
        // ❌ Map.of("A", 1, "A", 2); // IllegalArgumentException (duplicate key)
        // ❌ Map.of(null, 1);      // NullPointerException
        // ❌ Map.of("A", null);    // NullPointerException


        /* =========================================================
         * FINAL NOTE
         * =========================================================
         *
         * ✔ Approach 1 & 2 → Mutable
         * ✔ Approach 2 → Best design practice
         * ✔ Approach 3 → Immutable (safe, fast, error-prone if misused)
         */
    }
}
