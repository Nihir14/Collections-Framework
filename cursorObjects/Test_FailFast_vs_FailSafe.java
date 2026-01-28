package cursorObjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <h1>Fail-Fast vs Fail-Safe Demonstration</h1>
 *
 * <p>
 * This class demonstrates the behavioral difference between
 * <b>Fail-Fast</b> and <b>Fail-Safe</b> iterators using:
 * </p>
 *
 * <ul>
 *   <li>{@link java.util.ArrayList} → Fail-Fast</li>
 *   <li>{@link java.util.concurrent.CopyOnWriteArrayList} → Fail-Safe</li>
 * </ul>
 *
 * <h2>Key Concepts</h2>
 * <ul>
 *   <li>Fail-Fast iterator throws {@link java.util.ConcurrentModificationException}</li>
 *   <li>Fail-Safe iterator works on a snapshot of the collection</li>
 *   <li>Fail-Safe does NOT reflect modifications during iteration</li>
 * </ul>
 *
 * <p>
 * This example is useful for:
 * <ul>
 *   <li>Interview preparation</li>
 *   <li>Understanding iterator internals</li>
 *   <li>Multithreading concepts</li>
 * </ul>
 * </p>
 *
 * @author Nihir
 * @since Java 1.5
 */
public class Test_FailFast_vs_FailSafe {

    public static void main(String[] args) {

        /* =========================================================
         * FAIL-FAST EXAMPLE (ArrayList)
         * ========================================================= */

        System.out.println("---- FAIL-FAST : ArrayList ----");

        ArrayList<Integer> failFastList = new ArrayList<>();
        failFastList.add(10);
        failFastList.add(20);
        failFastList.add(30);

        Iterator<Integer> failFastItr = failFastList.iterator();

        try {
            while (failFastItr.hasNext()) {
                Integer value = failFastItr.next();
                System.out.println(value);

                // ❌ Structural modification during iteration
                failFastList.add(40); // Throws ConcurrentModificationException
            }
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }

        System.out.println();


        /* =========================================================
         * FAIL-SAFE EXAMPLE (CopyOnWriteArrayList)
         * ========================================================= */

        System.out.println("---- FAIL-SAFE : CopyOnWriteArrayList ----");

        CopyOnWriteArrayList<Integer> failSafeList = new CopyOnWriteArrayList<>();
        failSafeList.add(10);
        failSafeList.add(20);
        failSafeList.add(30);

        Iterator<Integer> failSafeItr = failSafeList.iterator();

        while (failSafeItr.hasNext()) {
            Integer value = failSafeItr.next();
            System.out.println(value);

            // ✅ Allowed: works on snapshot
            failSafeList.add(40);
        }

        System.out.println("Final List : " + failSafeList);
    }
}
