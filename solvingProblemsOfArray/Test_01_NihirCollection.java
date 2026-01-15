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
        nc.add(65);
        nc.add(67.97);

        System.out.println("Capacity : " + nc.capacity());
        System.out.println("Size     : " + nc.size());
        System.out.println(nc);

        nc.add("a");
        nc.add("b");
        nc.add("c");
        nc.add("d");
        nc.add("e");
        nc.add(65);
        nc.add(67.97);

        System.out.println("Capacity : " + nc.capacity());
        System.out.println("Size     : " + nc.size());
        System.out.println(nc);
    }
}
