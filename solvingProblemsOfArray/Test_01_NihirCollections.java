package solvingProblemsOfArray;

/**
 * Test_01_NihirCollection demonstrates and validates
 * the functionality of the {@link NihirCollections} class.
 *
 * <p>
 * This test class covers:
 * <ul>
 *   <li>Capacity and size checks</li>
 *   <li>Adding different data types</li>
 *   <li>Handling null values</li>
 *   <li>Search operations (contains, indexOf, lastIndexOf)</li>
 *   <li>Get, remove, add at index, and set operations</li>
 * </ul>
 * </p>
 *
 * <p>
 * This class is intended for learning, debugging,
 * and understanding the internal working of a custom collection.
 * </p>
 *
 * @author Nihir
 */
public class Test_01_NihirCollections {

    /**
     * Entry point for testing NihirCollection.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        // Create collection instance
        NihirCollections nc = new NihirCollections();

        // Initial state
        System.out.println("---- Initial State ----");
        System.out.println("Capacity : " + nc.capacity());
        System.out.println("Size     : " + nc.size());
        System.out.println(nc);

        // Adding elements of different types
        System.out.println("\n---- Adding Elements ----");
        nc.add("a");
        nc.add("b");
        nc.add("c");
        nc.add("d");
        nc.add("e");
        nc.add(null);
        nc.add(65);
        nc.add(67.97);
        nc.add(new Example(2, 3));

        System.out.println("Capacity : " + nc.capacity());
        System.out.println("Size     : " + nc.size());
        System.out.println(nc);

        // Trigger capacity expansion
        System.out.println("\n---- Adding More Elements (Resize) ----");
        nc.add("a");
        nc.add("b");
        nc.add("c");
        nc.add("d");
        nc.add("e");
        nc.add(65);
        nc.add(null);
        nc.add(new Example(2, 3));

        System.out.println("Capacity : " + nc.capacity());
        System.out.println("Size     : " + nc.size());
        System.out.println(nc);

        // contains() checks
        System.out.println("\n---- contains() Checks ----");
        System.out.println("Contains 'a'          : " + nc.contains("a"));
        System.out.println("Contains Example(2,3) : " + nc.contains(new Example(2, 3)));
        System.out.println("Contains null         : " + nc.contains(null));

        // indexOf() checks
        System.out.println("\n---- indexOf() Checks ----");
        System.out.println("Index of 'a'    : " + nc.indexOf("a"));
        System.out.println("Index of null   : " + nc.indexOf(null));

        // lastIndexOf() checks
        System.out.println("\n---- lastIndexOf() Checks ----");
        System.out.println("Last index of 'a'   : " + nc.lastIndexOf("a"));
        System.out.println("Last index of null  : " + nc.lastIndexOf(null));
        System.out.println("Last index of 'Yes' : " + nc.lastIndexOf("Yes"));

        // get() checks
        System.out.println("\n---- get() Checks ----");
        System.out.println("Element at index 0 : " + nc.get(0));
        System.out.println("Element at index 5 : " + nc.get(5));
        // nc.get(20); // IndexOutOfBoundsException

        // remove() checks
        System.out.println("\n---- remove() Checks ----");
        System.out.println("Removed index 3 : " + nc.remove(3));
        System.out.println("Removed null    : " + nc.remove(null));
        System.out.println("Removed null    : " + nc.remove(null));
        System.out.println("Removed null    : " + nc.remove(null));
        System.out.println("Removed null    : " + nc.remove(null));

        System.out.println("\nCollection after removals:");
        System.out.println(nc);

        // add at index
        System.out.println("\n---- add(index, element) ----");
        nc.add(2, null);
        System.out.println(nc);

        // set() check
        System.out.println("\n---- set(index, element) ----");
        System.out.println("Old value at index 2 : " + nc.set(2, 87));
        System.out.println(nc);
    }
}
