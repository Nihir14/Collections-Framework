package retrieving;

import java.util.ArrayList;

/**
 * Get
 *
 * <p>
 * This class demonstrates:
 * <ul>
 *   <li>How objects are stored in ArrayList</li>
 *   <li>How to retrieve elements safely</li>
 *   <li>Random vs Sequential access</li>
 *   <li>Index rules</li>
 *   <li>Why Object reference is used</li>
 *   <li>Safe type casting using instanceof</li>
 * </ul>
 *
 * <p>
 * All common mistakes are explained using comments,
 * but no line causes Compile-Time or Runtime errors.
 * </p>
 */
public class Get {

    public static void main(String[] args) {

        /* =====================================================
         * 1. CREATION OF ARRAYLIST (HETEROGENEOUS DATA)
         * ===================================================== */

        ArrayList<Object> al = new ArrayList<>();

        al.add("a");   // index 0
        al.add(5);     // index 1
        al.add("b");   // index 2
        al.add(6);     // index 3
        al.add("c");   // index 4
        al.add(7);     // index 5

        System.out.println("ArrayList : " + al);
        System.out.println();

        /* =====================================================
         * 2. WAYS TO RETRIEVE OBJECTS
         * =====================================================
         *
         * 1. Random access  -> get(index)
         * 2. Sequential access -> loop
         */

        /* ---------------- RANDOM ACCESS ---------------- */

        System.out.println("Random Access:");
        System.out.println(al.get(0));
        System.out.println(al.get(4));
        System.out.println(al.get(3));
        System.out.println();

        // ❌ Rule #1: index must be >= 0 and < size()
        // System.out.println(al.get(-1)); // RE: IndexOutOfBoundsException
        // System.out.println(al.get(6));  // RE: IndexOutOfBoundsException


        /* ---------------- SEQUENTIAL ACCESS ---------------- */

        System.out.println("Sequential Access (Dynamic):");
        for (int i = 0; i < al.size(); i++) {
            System.out.println(al.get(i));
        }

        System.out.println();

        /* =====================================================
         * 3. RULE #2: RETURN TYPE OF get()
         * =====================================================
         *
         * get() always returns Object because
         * ArrayList is declared as ArrayList<Object>
         */

        Object obj = al.get(0);   // Correct
        System.out.println("Retrieved Object : " + obj);

        // ❌ Compile-time error
        // String s = al.get(0);


        /* =====================================================
         * 4. RULE #3: OBJECT-SPECIFIC METHODS
         * =====================================================
         *
         * Object reference cannot directly call
         * child-specific methods
         */

        // ❌ Compile-time error
        // System.out.println(obj.toUpperCase());


        /* =====================================================
         * 5. RULE #4: TYPE CASTING USING instanceof (SAFE WAY)
         * ===================================================== */

        if (obj instanceof String) {
            String s = (String) obj;
            System.out.println("Uppercase (old style) : " + s.toUpperCase());
        }

        /* ---------------- JAVA 14+ STYLE ---------------- */

        if (obj instanceof String s) {
            System.out.println("Uppercase (Java 14+)  : " + s.toUpperCase());
        }

        System.out.println();

        /* =====================================================
         * 6. CLASS CAST EXCEPTION (WHY instanceof IS IMPORTANT)
         * =====================================================
         *
         * If we blindly cast without checking type,
         * it may lead to ClassCastException
         */

        Object obj2 = al.get(1); // Integer

        if (obj2 instanceof String s) {
            System.out.println(s.toUpperCase());
        } else {
            System.out.println("obj2 is NOT a String, it is: "
                    + obj2.getClass().getSimpleName());
        }

        /* =====================================================
         * END
         * ===================================================== */
    }
}
