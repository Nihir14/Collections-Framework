package collections;

import java.util.EnumMap;
import java.util.Map;

/**
 * Test_11_Map_EnumMap demonstrates the behavior and
 * internal working of {@link java.util.EnumMap}.
 *
 * <p>
 * EnumMap is a specialized Map implementation designed
 * specifically for enum keys.
 * </p>
 *
 * <h2>Key Characteristics</h2>
 * <ul>
 *   <li>Only enum keys are allowed</li>
 *   <li>Very fast (array-based internally)</li>
 *   <li>Maintains enum declaration order</li>
 *   <li>Does NOT allow null keys</li>
 *   <li>Allows null values</li>
 * </ul>
 *
 * <p>
 * EnumMap is preferred over HashMap when keys are enums
 * due to better performance and lower memory usage.
 * </p>
 *
 * @author Nihir
 */
public class Test_11_Map_EnumMap {

    /**
     * Entry point for EnumMap behavior demonstration.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        /* -------------------------------------------------
         * 1. CREATE ENUMMAP
         * -------------------------------------------------
         *
         * EnumMap requires the enum class type
         * at the time of creation.
         */

        EnumMap<FoodItems, Integer> menu =
                new EnumMap<>(FoodItems.class);

        System.out.println("Initial Map : " + menu);
        System.out.println("Size        : " + menu.size());
        System.out.println();

        /* -------------------------------------------------
         * 2. PUT OPERATION
         * -------------------------------------------------
         *
         * Internally:
         * - Enum ordinal() is used as array index
         * - No hashing required
         */

        System.out.println("put(IDLY,30)  -> " + menu.put(FoodItems.IDLY, 30));
        System.out.println("put(DOSA,50)  -> " + menu.put(FoodItems.DOSA, 50));
        System.out.println("put(WADA,25)  -> " + menu.put(FoodItems.WADA, 25));
        System.out.println("put(BONDA,20)-> " + menu.put(FoodItems.BONDA, 20));

        System.out.println("\nMenu after insertion:");
        System.out.println(menu);
        System.out.println("Size : " + menu.size());
        System.out.println();

        /* -------------------------------------------------
         * 3. DUPLICATE KEY (ENUM CONSTANT)
         * -------------------------------------------------
         *
         * Duplicate enum key replaces value
         */

        System.out.println("put(IDLY,35) -> " + menu.put(FoodItems.IDLY, 35));

        System.out.println("\nAfter updating IDLY price:");
        System.out.println(menu);
        System.out.println();

        /* -------------------------------------------------
         * 4. ORDER PRESERVATION
         * -------------------------------------------------
         *
         * Iteration order follows enum declaration order,
         * NOT insertion order.
         */

        System.out.println("==== ITERATION (ENUM ORDER) ====");
        for (Map.Entry<FoodItems, Integer> entry : menu.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println();

        /* -------------------------------------------------
         * 5. GET / CONTAINS OPERATIONS
         * ------------------------------------------------- */

        System.out.println("get(DOSA)           : " + menu.get(FoodItems.DOSA));
        System.out.println("containsKey(PURI)  : " + menu.containsKey(FoodItems.PURI));
        System.out.println("containsValue(25)  : " + menu.containsValue(25));
        System.out.println();

        /* -------------------------------------------------
         * 6. REMOVE OPERATION
         * ------------------------------------------------- */

        System.out.println("remove(WADA) -> " + menu.remove(FoodItems.WADA));

        System.out.println("\nAfter removing WADA:");
        System.out.println(menu);
        System.out.println("Size : " + menu.size());
        System.out.println();

        /* -------------------------------------------------
         * 7. NULL KEY VS NULL VALUE
         * -------------------------------------------------
         *
         * EnumMap:
         * ❌ null key NOT allowed
         * ✅ null value allowed
         */

        // menu.put(null, 100); // ❌ NullPointerException

        System.out.println("put(UPMA,null) -> " + menu.put(FoodItems.UPMA, null));
        System.out.println(menu);
        System.out.println();

        /* -------------------------------------------------
         * 8. ADDITIONAL IMPORTANT OPERATIONS
         * ------------------------------------------------- */

        System.out.println("Key Set   : " + menu.keySet());
        System.out.println("Values   : " + menu.values());

        System.out.println("Is Empty : " + menu.isEmpty());

        menu.clear();
        System.out.println("\nAfter clear(): " + menu);
        System.out.println("Size : " + menu.size());
    }
}
