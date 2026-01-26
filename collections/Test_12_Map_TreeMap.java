package collections;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Test_12_Map_TreeMap demonstrates the behavior and
 * internal working of {@link java.util.TreeMap}.
 *
 * <p>
 * TreeMap is a Map implementation that stores keys
 * in <b>sorted order</b>.
 * </p>
 *
 * <h2>Key Characteristics</h2>
 * <ul>
 *   <li>Keys are sorted (natural or custom order)</li>
 *   <li>Does NOT allow null keys</li>
 *   <li>Allows multiple null values</li>
 *   <li>Implements NavigableMap</li>
 *   <li>Internally uses Red-Black Tree</li>
 * </ul>
 *
 * <p>
 * TreeMap uses:
 * <ul>
 *   <li>compareTo() OR</li>
 *   <li>Comparator.compare()</li>
 * </ul>
 * for sorting and duplicate key detection.
 * </p>
 *
 * @author Nihir
 */
public class Test_12_Map_TreeMap {

    public static void main(String[] args) {

        /* -------------------------------------------------
         * 1. TREE MAP WITH NATURAL ORDERING (Integer keys)
         * ------------------------------------------------- */

        TreeMap<Integer, String> map = new TreeMap<>();

        map.put(3, "Three");
        map.put(1, "One");
        map.put(4, "Four");
        map.put(2, "Two");

        System.out.println("Natural sorted TreeMap:");
        System.out.println(map); // sorted by key
        System.out.println();

        /* -------------------------------------------------
         * 2. DUPLICATE KEY
         * -------------------------------------------------
         *
         * Duplicate key replaces value
         */

        System.out.println("put(2, \"TWO\") -> " + map.put(2, "TWO"));
        System.out.println(map);
        System.out.println();

        /* -------------------------------------------------
         * 3. NULL KEY BEHAVIOR
         * -------------------------------------------------
         *
         * TreeMap does NOT allow null keys
         */

        // map.put(null, "X"); // ❌ NullPointerException

        map.put(5, null); // ✅ null value allowed
        System.out.println("After adding null value:");
        System.out.println(map);
        System.out.println();

        /* -------------------------------------------------
         * 4. CUSTOM OBJECT AS KEY (Sa implements Comparable)
         * ------------------------------------------------- */

        TreeMap<Sa, Integer> saMap = new TreeMap<>();

        saMap.put(new Sa(5, 6), 100);
        saMap.put(new Sa(3, 4), 200);
        saMap.put(new Sa(4, 2), 300);
        saMap.put(new Sa(5, 6), 400); // duplicate key (compareTo == 0)

        System.out.println("TreeMap with Sa keys (Comparable):");
        System.out.println(saMap);
        System.out.println();

        /* -------------------------------------------------
         * 5. TREE MAP WITH CUSTOM COMPARATOR
         * -------------------------------------------------
         *
         * Sorting Sa objects by y (descending)
         */

        TreeMap<Sa, Integer> saMapDesc =
                new TreeMap<>((s1, s2) -> s2.getY() - s1.getY());

        saMapDesc.put(new Sa(5, 6), 100);
        saMapDesc.put(new Sa(3, 4), 200);
        saMapDesc.put(new Sa(4, 2), 300);
        saMapDesc.put(new Sa(5, 6), 400); // duplicate by comparator

        System.out.println("TreeMap with custom Comparator:");
        System.out.println(saMapDesc);
        System.out.println();

        /* -------------------------------------------------
         * 6. IMPORTANT NAVIGABLE MAP METHODS
         * ------------------------------------------------- */

        System.out.println("==== NAVIGABLE OPERATIONS ====");

        System.out.println("firstKey()  : " + map.firstKey());
        System.out.println("lastKey()   : " + map.lastKey());

        System.out.println("lowerKey(3) : " + map.lowerKey(3));
        System.out.println("higherKey(3): " + map.higherKey(3));

        System.out.println("floorKey(3) : " + map.floorKey(3));
        System.out.println("ceilingKey(3): " + map.ceilingKey(3));

        System.out.println();

        /* -------------------------------------------------
         * 7. RANGE OPERATIONS
         * ------------------------------------------------- */

        System.out.println("subMap(2,4)     : " + map.subMap(2, 4));
        System.out.println("headMap(3)     : " + map.headMap(3));
        System.out.println("tailMap(3)     : " + map.tailMap(3));
        System.out.println();

        /* -------------------------------------------------
         * 8. ITERATION
         * ------------------------------------------------- */

        System.out.println("Iterating TreeMap:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        /* -------------------------------------------------
         * 9. REMOVE & CLEAR
         * ------------------------------------------------- */

        System.out.println("\nremove(3) -> " + map.remove(3));
        System.out.println(map);

        map.clear();
        System.out.println("\nAfter clear(): " + map);
        System.out.println("Size : " + map.size());
    }
}
