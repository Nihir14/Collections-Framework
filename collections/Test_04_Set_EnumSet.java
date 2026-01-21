package collections;

import java.util.EnumSet;

public class Test_04_Set_EnumSet {
    public static void main(String[] args) {

        EnumSet<Color> color1 = EnumSet.noneOf(Color.class);
        System.out.println(color1);

        EnumSet<Color> color2 = EnumSet.allOf(Color.class);
        System.out.println(color2);

        EnumSet<Color> color3 = EnumSet.of(Color.YELLOW, Color.ORANGE, Color.RED);
        System.out.println(color3);

        EnumSet<Color> color4 = EnumSet.copyOf(color3);
        System.out.println(color4);

        EnumSet<Color> color5 = EnumSet.complementOf(color3);
        System.out.println(color5);

        EnumSet<Color> color6 = EnumSet.range(Color.BLUE, Color.ORANGE);
        System.out.println(color6);

        color1.add(Color.YELLOW);
        color1.add(Color.BLUE);
        color1.add(Color.ORANGE);
        color1.add(Color.ORANGE);
        System.out.println(color1);
    }
}
