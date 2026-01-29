package cursorObjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * ==========================================================
 * FOR-EACH LOOP (Enhanced for loop)
 * ==========================================================
 *
 * - Introduced in Java 1.5
 * - Internally uses Iterator
 * - Works only on:
 *      1) Array
 *      2) Iterable objects (Collection classes)
 *
 * Syntax:
 * for (dataType var : arrayOrIterable) {
 *     // logic
 * }
 *
 * ==========================================================
 * RELATION BETWEEN ITERATOR & FOR-EACH
 * ==========================================================
 *
 * for-each is internally converted to:
 *
 * Iterator itr = collection.iterator();
 * while (itr.hasNext()) {
 *     Object obj = itr.next();
 * }
 *
 * ==========================================================
 */
public class Test_04_ForEachLoop {

    public static void main(String[] args) {

        /*----------------------------------------
         * Example 1: ArrayList with mixed objects
         *----------------------------------------*/
        ArrayList<Object> al = new ArrayList<>();
        al.add("a1");
        al.add(51);
        al.add("b1");
        al.add(61);
        al.add("c1");
        al.add(71);

        System.out.println("ArrayList using for-each:");
        for (Object obj : al) {
            if (obj instanceof String s) {
                System.out.println(s.toUpperCase());
            } else {
                System.out.println(obj);
            }
        }

        /*----------------------------------------
         * Example 2: Equivalent Iterator code
         *----------------------------------------*/
        System.out.println("\nSame output using Iterator:");
        Iterator<Object> itr = al.iterator();
        while (itr.hasNext()) {
            Object obj = itr.next();
            System.out.println(obj);
        }

        /*----------------------------------------
         * RULE #1:
         * Variable type must be same as
         * itr.next() return type OR its superclass
         *----------------------------------------*/
        ArrayList<String> al2 = new ArrayList<>();
        al2.add("java");
        al2.add("spring");

        for (String s : al2) { }     // ✅ valid
        for (Object o : al2) { }     // ✅ valid
        // for (Integer i : al2) { } // ❌ CE

        /*----------------------------------------
         * RULE #2:
         * Object must be Array or Iterable
         *----------------------------------------*/
        String[] sa = {"A", "B", "C"};
        for (String s : sa) { }      // ✅ valid

        int[] ia = {1, 2, 3};
        for (int i : ia) { }         // ✅ valid

        // String s1 = "Hari";
        // for (char c : s1) { }      // ❌ CE (String not Iterable)

        /*----------------------------------------
         * RULE #3:
         * Separator must be colon (:)
         *----------------------------------------*/
        // for (String s, al2) { }    // ❌ CE
        // for (String s; al2) { }    // ❌ CE
        // for (String s = al2) { }   // ❌ CE

        /*----------------------------------------
         * RULE #4:
         * Variable must be declared inside for
         *----------------------------------------*/
        // String s;
        // for (s : al2) { }          // ❌ CE

        /*----------------------------------------
         * Example 3: LinkedHashSet
         *----------------------------------------*/
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(10);
        lhs.add(20);
        lhs.add(30);

        for (int i : lhs) {
            System.out.println(i);
        }

        /*----------------------------------------
         * Example 4: LinkedHashMap
         *----------------------------------------*/
        LinkedHashMap<Integer, String> lhm = new LinkedHashMap<>();
        lhm.put(1, "Java");
        lhm.put(2, "Spring");

        // ❌ for-each directly on Map not allowed
        // for (int i : lhm) { }

        // ✅ keys
        for (int key : lhm.keySet()) { }

        // ✅ values
        for (String value : lhm.values()) { }

        // ✅ entries
        for (Map.Entry<Integer, String> entry : lhm.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
