package solvingProblemsOfArray;

public class Test_01_NihirCollection {
    public static void main(String[] args) {
        NihirCollection nc = new NihirCollection();

        System.out.println("Capacity : " + nc.capacity());
        System.out.println("Size     : " + nc.size());
        System.out.println(nc);

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

        System.out.println(nc.contains("a"));

        System.out.println(nc.contains(new Example(2, 3)));
        System.out.println(nc.contains(null));

        System.out.println(nc.indexOf("a"));
        System.out.println(nc.indexOf(null));

        System.out.println(nc.lastIndexOf("a"));
        System.out.println(nc.lastIndexOf(null));
        System.out.println(nc.lastIndexOf("Yes"));

        System.out.println(nc.get(0));
        System.out.println(nc.get(5));
//        System.out.println(nc.get(20)); IndexOutOfBoundException

        System.out.println(nc.remove(3));
        System.out.println(nc.remove(null));
        System.out.println(nc.remove(null));
        System.out.println(nc.remove(null));
        System.out.println(nc.remove(null));

    }
}
