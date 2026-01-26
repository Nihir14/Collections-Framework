package collections;

import java.util.IdentityHashMap;
import java.util.Map;

/**
 * Test_14_Map_IdentityHashMap demonstrates the behavior and
 * internal working of {@link java.util.IdentityHashMap}.
 *
 * <p>
 * IdentityHashMap is a special Map implementation where:
 * <ul>
 *   <li>Keys are compared using <b>==</b> (reference equality)</li>
 *   <li>equals() method is completely ignored</li>
 *   <li>hashCode() is also ignored</li>
 * </ul>
 * </p>
 *
 * <p>
 * This makes IdentityHashMap fundamentally different
 * from HashMap and LinkedHashMap.
 * </p>
 *
 * @author Nihir
 */
public class Test_14_Map_IdentityHashMap {

    /**
     * Entry point for IdentityHashMap demonstration.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        /* -------------------------------------------------
         * 1. CREATE IDENTITYHASHMAP
         * ------------------------------------------------- */

        IdentityHashMap<Object, String> map = new IdentityHashMap<>();

        System.out.println("Initial map : " + map);
        System.out.println();

        /* -------------------------------------------------
         * 2. STRING KEYS (== vs equals)
         * ------------------------------------------------- */

        String s1 = new String("java");
        String s2 = new String("java");

        System.out.println("s1.equals(s2) : " + s1.equals(s2)); // true
        System.out.println("s1 == s2      : " + (s1 == s2));   // false

        map.put(s1, "Value-1");
        map.put(s2, "Value-2");

        /*
         * HashMap → would treat s1 & s2 as same key
         * IdentityHashMap → treats them as different keys
         */

        System.out.println("\nIdentityHashMap with String keys:");
        System.out.println(map);
        System.out.println("Size : " + map.size());
        System.out.println();

        /* -------------------------------------------------
         * 3. SAME REFERENCE KEY
         * ------------------------------------------------- */

        String s3 = s1; // same reference

        System.out.println("s3 == s1 : " + (s3 == s1));

        System.out.println("put(s3, NewValue) -> " + map.put(s3, "NewValue"));

        /*
         * Since s3 and s1 refer to same object,
         * value is replaced.
         */

        System.out.println("\nAfter inserting same reference:");
        System.out.println(map);
        System.out.println("Size : " + map.size());
        System.out.println();

        /* -------------------------------------------------
         * 4. CUSTOM OBJECT KEYS (Ex)
         * -------------------------------------------------
         *
         * Ex overrides equals() and hashCode(),
         * but IdentityHashMap ignores them.
         */

        Ex e1 = new Ex(5, 6);
        Ex e2 = new Ex(5, 6);

        System.out.println("e1.equals(e2) : " + e1.equals(e2)); // true
        System.out.println("e1 == e2      : " + (e1 == e2));   // false

        map.put(e1, "EX-1");
        map.put(e2, "EX-2");

        System.out.println("\nIdentityHashMap with Ex keys:");
        System.out.println(map);
        System.out.println("Size : " + map.size());
        System.out.println();

        /* -------------------------------------------------
         * 5. NULL KEY AND NULL VALUE
         * -------------------------------------------------
         *
         * IdentityHashMap:
         * - Allows one null key
         * - Allows multiple null values
         */

        map.put(null, "NULL-KEY");
        map.put("X", null);

        System.out.println("After adding null key/value:");
        System.out.println(map);
        System.out.println();

        /* -------------------------------------------------
         * 6. IMPORTANT OPERATIONS
         * ------------------------------------------------- */

        System.out.println("containsKey(s1) : " + map.containsKey(s1));
        System.out.println("containsKey(s2) : " + map.containsKey(s2));
        System.out.println("get(s1)         : " + map.get(s1));
        System.out.println("get(s2)         : " + map.get(s2));

        System.out.println("\nIterating IdentityHashMap:");
        for (Map.Entry<Object, String> entry : map.entrySet()) {
            System.out.println(
                    System.identityHashCode(entry.getKey())
                    + " -> " + entry.getKey()
                    + " = " + entry.getValue()
            );
        }

        /* -------------------------------------------------
         * 7. REMOVE & CLEAR
         * ------------------------------------------------- */

        System.out.println("\nremove(s1) -> " + map.remove(s1));
        System.out.println(map);

        map.clear();
        System.out.println("\nAfter clear(): " + map);
        System.out.println("Size : " + map.size());
    }
}
