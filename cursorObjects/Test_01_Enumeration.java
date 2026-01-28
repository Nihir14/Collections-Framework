package cursorObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/**
 * Test_01_Enumeration
 *
 * <p>
 * This class demonstrates the working of
 * {@link java.util.Enumeration} cursor object.
 * </p>
 *
 * <h2>Important Points about Enumeration</h2>
 * <ul>
 *   <li>Enumeration is a <b>cursor object</b></li>
 *   <li>It is a <b>legacy interface</b> (introduced in Java 1.0)</li>
 *   <li>Used mainly with legacy classes:
 *       <ul>
 *           <li>Vector</li>
 *           <li>Hashtable</li>
 *       </ul>
 *   </li>
 *   <li>It supports only <b>read operations</b></li>
 *   <li>Not fail-fast</li>
 * </ul>
 *
 * <h2>Methods provided by Enumeration</h2>
 * <ol>
 *   <li>boolean hasMoreElements()</li>
 *   <li>E nextElement()</li>
 * </ol>
 *
 * <p>
 * For retrieving objects using Enumeration,
 * we must perform two steps repeatedly:
 * <ol>
 *   <li>Check whether element is available</li>
 *   <li>Retrieve element and move cursor forward</li>
 * </ol>
 * </p>
 *
 * @author Nihir
 */
public class Test_01_Enumeration {

    public static void main(String[] args) {

        /* =====================================================
         * 1. ENUMERATION WITH VECTOR (LEGACY COLLECTION)
         * ===================================================== */

        Vector<Object> v1 = new Vector<>();

        v1.add("a");
        v1.add(5);
        v1.add("b");
        v1.add(6);
        v1.add("c");
        v1.add(7);

        System.out.println("Vector Elements:");
        System.out.println(v1);
        System.out.println();

        /* -------- Normal retrieval using for-loop -------- */
        System.out.println("Using for-loop:");
        for (int i = 0; i < v1.size(); i++) {
            System.out.print(v1.get(i) + " ");
        }
        System.out.println("\n");

        /* -------- Retrieval using Enumeration -------- */
        System.out.println("Using Enumeration on Vector:");

        // Factory method of Vector
        Enumeration<Object> e1 = v1.elements();

        while (e1.hasMoreElements()) {
            System.out.print(e1.nextElement() + " ");
        }
        System.out.println("\n");


        /* =====================================================
         * 2. ENUMERATION WITH HASHTABLE (LEGACY MAP)
         * ===================================================== */

        Hashtable<Object, Object> ht = new Hashtable<>();
        ht.put("a", 1);
        ht.put("b", 2);
        ht.put("c", 3);

        System.out.println("Hashtable Keys:");

        // Factory method of Hashtable
        Enumeration<Object> e2 = ht.keys();

        while (e2.hasMoreElements()) {
            System.out.print(e2.nextElement() + " ");
        }
        System.out.println("\n");

        System.out.println("Hashtable Values:");

        Enumeration<Object> e3 = ht.elements();

        while (e3.hasMoreElements()) {
            System.out.print(e3.nextElement() + " ");
        }
        System.out.println("\n");


        /* =====================================================
         * 3. ENUMERATION WITH COLLECTIONS FRAMEWORK OBJECTS
         * =====================================================
         *
         * Collections.enumeration(Collection c)
         * → converts Collection to Enumeration
         */

        ArrayList<Object> al = new ArrayList<>();

        al.add("a");
        al.add(5);
        al.add("b");
        al.add(6);
        al.add("c");
        al.add(7);

        System.out.println("ArrayList Elements:");
        System.out.println(al);

        System.out.println("Using Enumeration via Collections:");

        Enumeration<Object> e4 = Collections.enumeration(al);

        while (e4.hasMoreElements()) {
            System.out.print(e4.nextElement() + " ");
        }

        System.out.println("\n");

        /* =====================================================
         * END
         * ===================================================== */
    }
}
