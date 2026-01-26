package collections;

import java.util.HashMap;
import java.util.Map;

/**
 * Test_09_Map_HashMap demonstrates the behavior and
 * internal working of {@link java.util.HashMap}.
 *
 * <p>
 * This class helps understand:
 * <ul>
 *   <li>How put() works internally</li>
 *   <li>How duplicate keys are handled</li>
 *   <li>Role of hashCode() and equals()</li>
 *   <li>Difference between reference and logical equality</li>
 *   <li>Handling of null keys and null values</li>
 * </ul>
 * </p>
 *
 * <p>
 * Internally, HashMap:
 * <ul>
 *   <li>Uses an array of buckets</li>
 *   <li>Uses hashCode() to find bucket</li>
 *   <li>Uses equals() to detect duplicate keys</li>
 * </ul>
 * </p>
 *
 * @author Nihir
 */
public class Test_09_Map_HashMap {

    /**
     * Entry point for HashMap behavior demonstration.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        /* -------------------------------------------------
         * 1. CREATE HASHMAP
         * ------------------------------------------------- */

        HashMap<Object, Object> map = new HashMap<>();

        System.out.println("Initial size : " + map.size());
        System.out.println("Initial map  : " + map);
        System.out.println();

        /* -------------------------------------------------
         * 2. PUT OPERATION (RETURN VALUE)
         * -------------------------------------------------
         *
         * put(key, value):
         * - Returns previous value if key already exists
         * - Returns null if key is new
         */

        System.out.println("put(a,5)  -> " + map.put("a", 5));
        System.out.println("put(b,6)  -> " + map.put("b", 6));
        System.out.println("put(a,7)  -> " + map.put("a", 7)); // replaces value

        System.out.println("\nMap after string keys:");
        System.out.println(map);
        System.out.println("Size : " + map.size());
        System.out.println();

        /* -------------------------------------------------
         * 3. CUSTOM OBJECT AS KEY (Ex)
         * -------------------------------------------------
         *
         * Ex overrides equals() and hashCode()
         * → logically equal keys behave as duplicates
         */

        Ex ex1 = new Ex(5, 6);

        System.out.println("put(new Ex(5,6),10) -> " + map.put(new Ex(5, 6), 10));
        System.out.println("put(new Ex(5,6),10) -> " + map.put(new Ex(5, 6), 10));
        System.out.println("put(new Ex(5,6),10) -> " + map.put(new Ex(5, 6), 10));
        System.out.println("put(ex1,10)         -> " + map.put(ex1, 10));

        System.out.println("\nMap after Ex keys:");
        System.out.println(map);
        System.out.println("Size : " + map.size());
        System.out.println();

        /* -------------------------------------------------
         * 4. REMOVE OPERATION
         * -------------------------------------------------
         *
         * remove(key):
         * - Uses hashCode + equals
         * - Returns removed value or null
         */

        System.out.println("remove(new Ex(5,6)) -> " + map.remove(new Ex(5, 6)));
        System.out.println("remove(ex1)         -> " + map.remove(ex1));

        System.out.println("\nMap after removing Ex:");
        System.out.println(map);
        System.out.println("Size : " + map.size());
        System.out.println();

        /* -------------------------------------------------
         * 5. CUSTOM OBJECT AS KEY (Sa)
         * -------------------------------------------------
         *
         * Sa overrides equals() + hashCode()
         */

        System.out.println("put(new Sa(5,6),10) -> " + map.put(new Sa(5, 6), 10));
        System.out.println("put(new Sa(5,6),10) -> " + map.put(new Sa(5, 6), 10));
        System.out.println("put(new Sa(5,6),10) -> " + map.put(new Sa(5, 6), 10));

        System.out.println("\nMap after Sa keys:");
        System.out.println(map);
        System.out.println("Size : " + map.size());

        System.out.println("remove(new Sa(5,6)) -> " + map.remove(new Sa(5, 6)));

        System.out.println("\nMap after removing Sa:");
        System.out.println(map);
        System.out.println("Size : " + map.size());
        System.out.println();

        /* -------------------------------------------------
         * 6. NULL KEY AND NULL VALUE
         * -------------------------------------------------
         *
         * HashMap allows:
         * - One null key
         * - Multiple null values
         */

        System.out.println("put(null,null) -> " + map.put(null, null));
        System.out.println(map);

        System.out.println("put(null,10)   -> " + map.put(null, 10));
        System.out.println(map);
        System.out.println();

        /* -------------------------------------------------
         * 7. ADDITIONAL IMPORTANT OPERATIONS
         * ------------------------------------------------- */

        System.out.println("==== ADDITIONAL OPERATIONS ====");

        System.out.println("containsKey(\"a\") : " + map.containsKey("a"));
        System.out.println("containsValue(7)  : " + map.containsValue(7));

        System.out.println("get(\"a\")         : " + map.get("a"));
        System.out.println("get(\"x\")         : " + map.get("x")); // null

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
