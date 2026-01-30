package cursorObjects;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * ============================================================
 * Test29_Stream_API
 * ============================================================
 *
 * This class demonstrates the usage of Java 8 Stream API
 * on a heterogeneous Collection (ArrayList<Object>).
 *
 * Key Concepts Covered:
 * ---------------------
 * 1. Creating Stream from Collection
 * 2. forEach() terminal operation
 * 3. filter() intermediate operation
 * 4. map() intermediate operation
 * 5. Processing String and Integer objects separately
 * 6. Even number filtering
 *
 * Important Notes:
 * ----------------
 * - Stream does NOT store data
 * - Stream does NOT modify original collection
 * - Stream can be consumed ONLY ONCE
 * - Operations are executed lazily
 *
 * Java Version:
 * -------------
 * Java 8+
 */
public class Test_06_Stream_API {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // Creating a heterogeneous ArrayList
        // ------------------------------------------------------------
        ArrayList<Object> al = new ArrayList<>();

        al.add("a");
        al.add(5);
        al.add("b");
        al.add(6);
        al.add("c");
        al.add(7);

        // ============================================================
        // 1. Retrieving and printing ALL elements
        // ============================================================
        System.out.println("---- All Elements ----");
        al.stream()
          .forEach(ele -> System.out.println(ele));

        System.out.println();

        // ============================================================
        // 2. Retrieving and printing ONLY String objects
        // ============================================================
        System.out.println("---- Only String Elements ----");
        al.stream()
          .filter(ele -> ele instanceof String)
          .forEach(ele -> System.out.println(ele));

        System.out.println();

        // ============================================================
        // 3. Retrieving and printing ONLY Integer objects
        // ============================================================
        System.out.println("---- Only Integer Elements ----");
        al.stream()
          .filter(ele -> ele instanceof Integer)
          .forEach(ele -> System.out.println(ele));

        System.out.println();

        // ============================================================
        // 4. Retrieving and printing ONLY EVEN Integer objects
        // ============================================================
        System.out.println("---- Only Even Integer Elements ----");
        al.stream()
          .filter(ele -> ele instanceof Integer)       // type safety
          .filter(ele -> ((int) ele) % 2 == 0)         // condition
          .forEach(ele -> System.out.println(ele));

        System.out.println();

        // ============================================================
        // 5. Converting String objects to UPPERCASE and printing
        // ============================================================
        System.out.println("---- String Elements in Upper Case ----");
        al.stream()
          .filter(ele -> ele instanceof String)        // select Strings
          .map(ele -> ((String) ele).toUpperCase())   // transformation
          .forEach(ele -> System.out.println(ele));
    }
}
