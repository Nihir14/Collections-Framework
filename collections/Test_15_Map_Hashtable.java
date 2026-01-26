package collections;

import java.util.Hashtable;
import java.util.Map;

/**
 * Test_15_Map_Hashtable demonstrates the behavior and
 * internal working of {@link java.util.Hashtable}.
 *
 * <p>
 * Hashtable is a legacy Map implementation introduced
 * in JDK 1.0.
 * </p>
 *
 * <h2>Key Characteristics</h2>
 * <ul>
 *   <li>Thread-safe (all methods synchronized)</li>
 *   <li>Does NOT allow null keys</li>
 *   <li>Does NOT allow null values</li>
 *   <li>Uses hash table internally</li>
 *   <li>Slower due to synchronization overhead</li>
 * </ul>
 *
 * <p>
 * Hashtable is considered obsolete for new development
 * and is replaced by {@link java.util.concurrent.ConcurrentHashMap}.
 * </p>
 *
 * @author Nihir
 */
public class Test_15_Map_Hashtable {

    /**
     * Entry point for Hashtable behavior demonstration.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        /* -------------------------------------------------
         * 1. CREATE HASHTABLE
         * ------------------------------------------------- */

        Hashtable<Object, Object> table = new Hashtable<>();

        System.out.println("Initial table : " + table);
        System.out.println("Size          : " + table.size());
        System.out.println();

        /* -------------------------------------------------
         * 2. PUT OPERATION
         * -------------------------------------------------
         *
         * put(key, value):
         * - Synchronized
         * - Returns old value if key exists
         */

        System.out.println("put(a,1) -> " + table.put("a", 1));
        System.out.println("put(b,2) -> " + table.put("b", 2));
        System.out.println("put(a,3) -> " + table.put("a", 3)); // replaces value

        System.out.println("\nAfter insertion:");
        System.out.println(table);
        System.out.println("Size : " + table.size());
        System.out.println();

        /* -------------------------------------------------
         * 3. NULL KEY / NULL VALUE (IMPORTANT!)
         * -------------------------------------------------
         *
         * Hashtable does NOT allow null keys or values.
         */

        // table.put(null, 10);   // ❌ NullPointerException
        // table.put("c", null);  // ❌ NullPointerException

        System.out.println("Hashtable does NOT allow null key/value");
        System.out.println();

        /* -------------------------------------------------
         * 4. CUSTOM OBJECT AS KEY (Ex)
         * -------------------------------------------------
         *
         * Hashtable uses:
         * - hashCode()
         * - equals()
         */

        Ex e1 = new Ex(5, 6);
        Ex e2 = new Ex(5, 6);

        table.put(e1, "EX-1");
        table.put(e2, "EX-2"); // duplicate logically → replaces value

        System.out.println("After adding Ex keys:");
        System.out.println(table);
        System.out.println("Size : " + table.size());
        System.out.println();

        /* -------------------------------------------------
         * 5. REMOVE OPERATION
         * ------------------------------------------------- */

        System.out.println("remove(a) -> " + table.remove("a"));

        System.out.println("\nAfter removal:");
        System.out.println(table);
        System.out.println("Size : " + table.size());
        System.out.println();

        /* -------------------------------------------------
         * 6. IMPORTANT MAP OPERATIONS
         * ------------------------------------------------- */

        System.out.println("containsKey(b)   : " + table.containsKey("b"));
        System.out.println("containsValue(2): " + table.containsValue(2));
        System.out.println("get(b)           : " + table.get("b"));

        System.out.println("\nIterating Hashtable:");
        for (Map.Entry<Object, Object> entry : table.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        /* -------------------------------------------------
         * 7. CLEAR
         * ------------------------------------------------- */

        table.clear();
        System.out.println("\nAfter clear(): " + table);
        System.out.println("Size : " + table.size());
    }
}
