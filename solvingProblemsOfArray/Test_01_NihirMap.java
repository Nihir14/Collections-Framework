package solvingProblemsOfArray;

/**
 * Test_02_NihirMap_FullSupport demonstrates
 * all supported operations of {@link NihirMap}.
 *
 * <p>
 * Covered operations:
 * <ul>
 *   <li>size(), capacity(), isEmpty()</li>
 *   <li>put() – insert & replace mode</li>
 *   <li>get()</li>
 *   <li>containsKey(), containsValue()</li>
 *   <li>remove()</li>
 *   <li>clear()</li>
 *   <li>Dynamic resizing</li>
 * </ul>
 * </p>
 *
 * This class is intended for:
 * <ul>
 *   <li>Learning</li>
 *   <li>Debugging</li>
 *   <li>Interview explanation</li>
 * </ul>
 *
 * @author Nihir
 */
public class Test_01_NihirMap {

    public static void main(String[] args) {

        NihirMap map = new NihirMap();

        /* ---------------- INITIAL STATE ---------------- */
        System.out.println("==== INITIAL STATE ====");
        System.out.println("Is Empty : " + map.isEmpty());
        System.out.println("Size     : " + map.size());
        System.out.println("Capacity : " + map.capacity());
        System.out.println(map);

        /* ---------------- PUT OPERATION ---------------- */
        System.out.println("\n==== PUT OPERATION ====");
        map.put(1, "Java");
        map.put(2, "Spring");
        map.put(3, "Hibernate");
        map.put(4, "Docker");
        map.put(5, "Kubernetes");

        System.out.println("After inserting entries:");
        System.out.println("Size     : " + map.size());
        System.out.println("Capacity : " + map.capacity());
        System.out.println(map);

        /* ---------------- PUT (REPLACE MODE) ---------------- */
        System.out.println("\n==== PUT (REPLACE VALUE) ====");
        map.put(3, "JPA"); // replacing value for key=3
        System.out.println("After replacing key 3:");
        System.out.println(map);

        /* ---------------- GET OPERATION ---------------- */
        System.out.println("\n==== GET OPERATION ====");
        System.out.println("Value for key 2 : " + map.get(2));
        System.out.println("Value for key 10: " + map.get(10)); // null

        /* ---------------- CONTAINS CHECKS ---------------- */
        System.out.println("\n==== CONTAINS CHECKS ====");
        System.out.println("Contains key 1       : " + map.containsKey(1));
        System.out.println("Contains key 100     : " + map.containsKey(100));
        System.out.println("Contains value Java  : " + map.containsValue("Java"));
        System.out.println("Contains value Python: " + map.containsValue("Python"));

        /* ---------------- REMOVE OPERATION ---------------- */
        System.out.println("\n==== REMOVE OPERATION ====");
        System.out.println("Removed value for key 4 : " + map.remove(4));
        System.out.println("Removed value for key 9 : " + map.remove(9)); // null

        System.out.println("After removals:");
        System.out.println("Size : " + map.size());
        System.out.println(map);

        /* ---------------- RESIZE TEST ---------------- */
        System.out.println("\n==== DYNAMIC RESIZE TEST ====");
        map.put(6, "AWS");
        map.put(7, "Azure");
        map.put(8, "GCP");
        map.put(9, "Linux");
        map.put(10, "CI/CD");
        map.put(11, "Microservices");

        System.out.println("After exceeding initial capacity:");
        System.out.println("Size     : " + map.size());
        System.out.println("Capacity : " + map.capacity());
        System.out.println(map);

        /* ---------------- CLEAR OPERATION ---------------- */
        System.out.println("\n==== CLEAR OPERATION ====");
        map.clear();
        System.out.println("After clear():");
        System.out.println("Is Empty : " + map.isEmpty());
        System.out.println("Size     : " + map.size());
        System.out.println(map);
    }
}
