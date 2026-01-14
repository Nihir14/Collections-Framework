package object;

public class Test_01_HashCode {

    public static void main(String[] args) {
        Example example1 = new Example();
        Example example2 = new Example();


        System.out.println(System.identityHashCode(example1));
        System.out.println(System.identityHashCode(example2));
        System.out.println(example1.hashCode());
        System.out.println(example2.hashCode());

        example1.x = 20;

        System.out.println(System.identityHashCode(example1));
        System.out.println(System.identityHashCode(example2));
        System.out.println(example1.hashCode());
        System.out.println(example2.hashCode());

    }



}
