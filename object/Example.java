package object;

public class Example {
    int x=10;
    int y=20;

    @Override
    public int hashCode() {
        return x+y;
    }
}
