package cursorObjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * ============================================================
 * Test_05_ForEachMethod
 * ============================================================
 *
 * This class explains ALL iteration techniques in Java:
 *
 * 1. Iterator (Explicit iteration)
 * 2. Enhanced for-loop (for-each loop)
 * 3. forEach() method (Java 8 – Functional programming)
 *
 * ------------------------------------------------------------
 * IMPORTANT THEORY
 * ------------------------------------------------------------
 *
 * ✔ for-each loop internally uses Iterator
 * ✔ forEach() method internally uses Iterator + Consumer
 * ✔ Collection implements Iterable
 *
 * Iterable<T> provides:
 *     default void forEach(Consumer<? super T> action)
 *
 * So finally:
 *   forEach() → Iterator → hasNext() → next()
 *
 * ------------------------------------------------------------
 */
public class Test_05_ForEachMethod {

    public static void main(String[] args) {

        ArrayList<Object> al = new ArrayList<>();

        al.add("a1");
        al.add(51);
        al.add("b1");
        al.add(61);
        al.add("c1");
        al.add(71);

        System.out.println("Original Collection : " + al);
        System.out.println();

        // =====================================================
        // 1️⃣ ITERATOR (Explicit Iteration)
        // =====================================================
        System.out.println("1) Iterator (Explicit Iteration)");

        Iterator<Object> itr = al.iterator();
        while (itr.hasNext()) {
            Object obj = itr.next();
            System.out.println(obj);
        }

        System.out.println();

        // =====================================================
        // 2️⃣ ENHANCED FOR LOOP (for-each)
        // =====================================================
        /**
         * Syntax:
         * for (variableDeclaration : array / Iterable) {
         *     logic
         * }
         *
         * Rules:
         * 1. Variable type must be same or superclass of element type
         * 2. Right side must be array or Iterable
         * 3. Separator must be ':' (not ; , =)
         * 4. Variable must be declared inside for-loop
         */
        System.out.println("2) Enhanced for-loop");

        for (Object obj : al) {
            System.out.println(obj);
        }

        System.out.println();

        // Example with logic
        System.out.println("Enhanced for-loop with logic");

        for (Object obj : al) {
            if (obj instanceof String s) {
                System.out.println(s.toUpperCase());
            } else {
                System.out.println(obj);
            }
        }

        System.out.println();

        // ❌ INVALID EXAMPLES (Compilation Errors)
        /*
        for (Integer i : al) { }        // Rule #1 violation
        for (Object o ; al) { }         // Rule #3 violation
        String s = "Hari";
        for (char ch : s) { }           // String is NOT Iterable
        */

        // =====================================================
        // 3️⃣ forEach() METHOD (Java 8 – Implicit Iteration)
        // =====================================================
        /**
         * Introduced in Java 8
         * Uses Functional Programming
         * Uses Consumer Functional Interface
         *
         * Signature:
         * void forEach(Consumer<? super T> action)
         *
         * Consumer<T> has:
         *     void accept(T t)
         */
        System.out.println("3) forEach() method (Lambda)");

        al.forEach(obj -> System.out.println(obj));

        System.out.println();

        // forEach with block logic
        System.out.println("forEach() with logic");

        al.forEach(obj -> {
            if (obj instanceof String s) {
                System.out.println(s.toUpperCase());
            } else {
                System.out.println(obj);
            }
        });

        System.out.println();

        // =====================================================
        // INTERNAL WORKING (IMPORTANT FOR INTERVIEWS)
        // =====================================================
        /**
         * Internally forEach() works like this:
         *
         * public default void forEach(Consumer<? super T> action) {
         *     Iterator<T> itr = iterator();
         *     while (itr.hasNext()) {
         *         T obj = itr.next();
         *         action.accept(obj);
         *     }
         * }
         *
         * So:
         * forEach() → iterator() → hasNext() → next() → accept()
         */

        // =====================================================
        // SUMMARY (REMEMBER THIS)
        // =====================================================
        /**
         * Iterator        → Explicit, more control, can remove()
         * for-each loop   → Cleaner syntax, read-only
         * forEach()       → Functional style, lambda based
         *
         * Fail-fast:
         *   Iterator, for-each
         *
         * Fail-safe:
         *   forEach() on CopyOnWriteArrayList
         */
    }
}
