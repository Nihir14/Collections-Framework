package collections;

import java.util.EnumSet;

/**
 * Test_04_Set_EnumSet demonstrates the usage and internal
 * working principles of {@link java.util.EnumSet}.
 *
 * <p>
 * EnumSet is a specialized Set implementation designed
 * exclusively for enum types.
 * </p>
 *
 * <h2>Key Characteristics of EnumSet</h2>
 * <ul>
 *   <li>Only works with enum types</li>
 *   <li>Very fast (bit-vector based implementation)</li>
 *   <li>No duplicates allowed</li>
 *   <li>No null elements allowed</li>
 *   <li>Iteration order follows enum declaration order</li>
 * </ul>
 *
 * <p>
 * Internally, EnumSet uses a bit mask where each enum
 * constant represents one bit.
 * </p>
 *
 * <p>
 * This class demonstrates all major factory methods
 * and behaviors of EnumSet.
 * </p>
 *
 * @author Nihir
 */
public class Test_04_Set_EnumSet {

    /**
     * Entry point for EnumSet behavior demonstration.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        /* -------------------------------------------------
         * 1. noneOf() — Empty EnumSet
         * -------------------------------------------------
         *
         * Creates an empty EnumSet for the given enum type.
         * Internally, all bits are set to 0.
         */

        EnumSet<Color> color1 = EnumSet.noneOf(Color.class);
        System.out.println("noneOf(): " + color1);

        /* -------------------------------------------------
         * 2. allOf() — Full EnumSet
         * -------------------------------------------------
         *
         * Creates an EnumSet containing all enum constants.
         * Internally, all bits are set to 1.
         */

        EnumSet<Color> color2 = EnumSet.allOf(Color.class);
        System.out.println("allOf(): " + color2);

        /* -------------------------------------------------
         * 3. of() — Selected Constants
         * -------------------------------------------------
         *
         * Creates an EnumSet containing only specified
         * enum constants.
         */

        EnumSet<Color> color3 =
                EnumSet.of(Color.YELLOW, Color.ORANGE, Color.RED);
        System.out.println("of(): " + color3);

        /* -------------------------------------------------
         * 4. copyOf() — Copy Existing EnumSet
         * -------------------------------------------------
         *
         * Creates a new EnumSet with the same elements
         * as the provided EnumSet.
         */

        EnumSet<Color> color4 = EnumSet.copyOf(color3);
        System.out.println("copyOf(): " + color4);

        /* -------------------------------------------------
         * 5. complementOf() — Inverse Selection
         * -------------------------------------------------
         *
         * Creates an EnumSet containing all elements
         * NOT present in the given EnumSet.
         */

        EnumSet<Color> color5 = EnumSet.complementOf(color3);
        System.out.println("complementOf(): " + color5);

        /* -------------------------------------------------
         * 6. range() — Continuous Enum Range
         * -------------------------------------------------
         *
         * Creates an EnumSet containing all enum constants
         * between the given range (inclusive).
         *
         * IMPORTANT:
         * Order is based on enum declaration order.
         */

        EnumSet<Color> color6 =
                EnumSet.range(Color.BLUE, Color.ORANGE);
        System.out.println("range(): " + color6);

        /* -------------------------------------------------
         * 7. add() — Adding Elements
         * -------------------------------------------------
         *
         * EnumSet:
         * - Does NOT allow duplicates
         * - Does NOT allow null
         * - add() returns false if element already exists
         */

        color1.add(Color.YELLOW);
        color1.add(Color.BLUE);
        color1.add(Color.ORANGE);
        color1.add(Color.ORANGE); // duplicate → ignored

        System.out.println("After add(): " + color1);
    }
}
