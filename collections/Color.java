package collections;

public enum Color {
    RED, GREEN, BLUE, YELLOW, ORANGE, BLACK
}

/**
 *  public final class Color extends Enum {
 *
 *      private static final Color[] $values;
 *
 *      public Color[] values() {
 *          return values.clone();
 *      }
 *
 *
 *      public static final Color RED;
 *      public static final Color GREEN;
 *      public static final Color BLUE;
 *      public static final Color YELLOW;
 *      public static final Color ORANGE;
 *      public static final Color BLACK;
 *
 *      private Color(String name, int ordinal) {
 *          super(name, ordinal);
 *      }
 *
 *      static {
 *          RED = new Color("RED", 0);
 *          GREEN = new Color("GREEN", 0);
 *          BLUE = new Color("BLUE", 0);
 *          YELLOW = new Color("YELLOW", 0);
 *          ORANGE = new Color("ORANGE", 0);
 *          BLACK = new Color("BLACK", 0);
 *
 *          values = new Color[] {RED, GREEN, BLUE, YELLOW, ORANGE, BLACK};
 *      }
 *  }
 *
 *
 *
 *
 * */