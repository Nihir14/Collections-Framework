package collections;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Test_10_Map_LinkedHashMap demonstrates the behavior and
 * internal working of {@link java.util.LinkedHashMap}.
 *
 * <p>
 * LinkedHashMap is a subclass of HashMap that maintains
 * a predictable iteration order.
 * </p>
 *
 * <h2>Key Characteristics</h2>
 * <ul>
 *   <li>Maintains insertion order (by default)</li>
 *   <li>Allows one null key</li>
 *   <li>Allows multiple null values</li>
 *   <li>Not synchronized</li>
 *   <li>Slightly slower than HashMap (extra links)</li>
 * </ul>
 *
 * <p>
 * Internally, LinkedHashMap:
 * <ul>
 *   <li>Uses HashMap for storage</li>
 *   <li>Maintains a doubly linked list of entries</li>
 *   <li>Iteration happens using linked list, not buckets</li>
 * </ul>
 * </p>
 *
 * @author Nihir
 */
public class Test_10_Map_LinkedHashMap {

    /**
     * Entry point for LinkedHashMap behavior demonstration.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        /* -------------------------------------------------
         * 1. CREATE LINKEDHASHMAP
         * ------------------------------------------------- */

        LinkedHashMap<Object, Object> map = new LinkedHashMap<>();

        System.out.println("Initial size : " + map.size());
        System.out.println("Initial map  : " + map);
        System.out.println();

        /* -------------------------------------------------
         * 2. PUT OPERATION (INSERTION ORDER MAINTAINED)
         * ------------------------------------------------- */

        System.out.println("put(a,5)  -> " + map.put("a", 5));
        System.out.println("put(b,6)  -> " + map.put("b", 6));
        System.out.println("put(c,7)  -> " + map.put("c", 7));
        System.out.println("put(a,9)  -> " + map.put("a", 9)); // replaces value

        System.out.println("\nMap after String keys:");
        System.out.println(map); // insertion order preserved
        System.out.println("Size : " + map.size());
        System.out.println();

        /* -------------------------------------------------
         * 3. CUSTOM OBJECT AS KEY (Ex)
         * -------------------------------------------------
         *
         * Duplicate detection depends on:
         * hashCode() + equals()
         */

        Ex ex1 = new Ex(5, 6);

        System.out.println("put(new Ex(5,6),10) -> " + map.put(new Ex(5, 6), 10));
        System.out.println("put(new Ex(5,6),20) -> " + map.put(new Ex(5, 6), 20));
        System.out.println("put(ex1,30)         -> " + map.put(ex1, 30));

        System.out.println("\nMap after Ex keys:");
        System.out.println(map);
        System.out.println("Size : " + map.size());
        System.out.println();

        /* -------------------------------------------------
         * 4. REMOVE OPERATION
         * ------------------------------------------------- */

        System.out.println("remove(new Ex(5,6)) -> " + map.remove(new Ex(5, 6)));

        System.out.println("\nMap after removal:");
        System.out.println(map);
        System.out.println("Size : " + map.size());
        System.out.println();

        /* -------------------------------------------------
         * 5. CUSTOM OBJECT AS KEY (Sa)
         * ------------------------------------------------- */

        System.out.println("put(new Sa(1,1),100) -> " + map.put(new Sa(1, 1), 100));
        System.out.println("put(new Sa(2,2),200) -> " + map.put(new Sa(2, 2), 200));
        System.out.println("put(new Sa(1,1),300) -> " + map.put(new Sa(1, 1), 300));

        System.out.println("\nMap after Sa keys:");
        System.out.println(map);
        System.out.println("Size : " + map.size());
        System.out.println();

        /* -------------------------------------------------
         * 6. NULL KEY AND NULL VALUE
         * ------------------------------------------------- */

        System.out.println("put(null,null) -> " + map.put(null, null));
        System.out.println("put(null,50)   -> " + map.put(null, 50));

        System.out.println("\nMap with null key:");
        System.out.println(map);
        System.out.println();

        /* -------------------------------------------------
         * 7. IMPORTANT MAP OPERATIONS
         * ------------------------------------------------- */

        System.out.println("==== IMPORTANT OPERATIONS ====");

        System.out.println("get(\"a\")          : " + map.get("a"));
        System.out.println("containsKey(\"b\")  : " + map.containsKey("b"));
        System.out.println("containsValue(200) : " + map.containsValue(200));

        System.out.println("\nIterating using entrySet():");
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\nKey Set : " + map.keySet());
        System.out.println("Values  : " + map.values());

        System.out.println("\nIs map empty? " + map.isEmpty());

        map.clear();
        System.out.println("\nAfter clear(): " + map);
        System.out.println("Size : " + map.size());
    }
}
