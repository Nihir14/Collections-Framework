package collections;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * Test_13_Map_WeakHashMap demonstrates the behavior and
 * internal working of {@link java.util.WeakHashMap}.
 *
 * <p>
 * WeakHashMap is a special Map implementation where:
 * <ul>
 *   <li>Keys are stored as <b>Weak References</b></li>
 *   <li>Entries are automatically removed by Garbage Collector</li>
 *   <li>Only keys are weak, values are strong</li>
 * </ul>
 * </p>
 *
 * <h2>Key Characteristics</h2>
 * <ul>
 *   <li>Allows null key (only one)</li>
 *   <li>Allows null values</li>
 *   <li>Not synchronized</li>
 *   <li>Used for memory-sensitive caching</li>
 * </ul>
 *
 * <p>
 * WeakHashMap is mainly used when you want entries
 * to be removed automatically when keys are no longer used.
 * </p>
 *
 * @author Nihir
 */
public class Test_13_Map_WeakHashMap {

    /**
     * Entry point for WeakHashMap demonstration.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) throws InterruptedException {

        /* -------------------------------------------------
         * 1. CREATE WEAKHASHMAP
         * ------------------------------------------------- */

        WeakHashMap<Object, String> weakMap = new WeakHashMap<>();

        System.out.println("Initial map : " + weakMap);
        System.out.println();

        /* -------------------------------------------------
         * 2. ADD ENTRIES
         * -------------------------------------------------
         *
         * Keys stored as weak references
         */

        Object key1 = new Object();
        Object key2 = new Object();

        weakMap.put(key1, "Value-1");
        weakMap.put(key2, "Value-2");

        System.out.println("After insertion:");
        System.out.println(weakMap);
        System.out.println("Size : " + weakMap.size());
        System.out.println();

        /* -------------------------------------------------
         * 3. REMOVE STRONG REFERENCE TO KEY
         * -------------------------------------------------
         *
         * key1 is made eligible for GC
         */

        key1 = null;

        /*
         * Request Garbage Collection
         * (GC is NOT guaranteed immediately)
         */
        System.gc();

        // Give GC some time
        Thread.sleep(1000);

        System.out.println("After GC (key1 reference lost):");
        System.out.println(weakMap);
        System.out.println("Size : " + weakMap.size());
        System.out.println();

        /* -------------------------------------------------
         * 4. NULL KEY & NULL VALUE
         * ------------------------------------------------- */

        weakMap.put(null, "NULL_KEY");
        weakMap.put("A", null);

        System.out.println("After adding null key and null value:");
        System.out.println(weakMap);
        System.out.println();

        /* -------------------------------------------------
         * 5. IMPORTANT OPERATIONS
         * ------------------------------------------------- */

        System.out.println("containsKey(key2) : " + weakMap.containsKey(key2));
        System.out.println("get(key2)         : " + weakMap.get(key2));

        System.out.println("\nIterating WeakHashMap:");
        for (Map.Entry<Object, String> entry : weakMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        /* -------------------------------------------------
         * 6. CLEAR
         * ------------------------------------------------- */

        weakMap.clear();
        System.out.println("\nAfter clear(): " + weakMap);
        System.out.println("Size : " + weakMap.size());
    }
}
