package solvingProblemsOfArray;

import java.util.Objects;

public class Example {
    private int x;
    private int y;

    public Example(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Example example = (Example) o;
        return x == example.x && y == example.y;
    }

    @Override
    public String toString() {
        return "Example{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
