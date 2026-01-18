package collections;

import java.util.HashSet;

public class Test_01_Set_HashSet {
    static void main(String[] args) {
        HashSet<Object> hashSet = new HashSet<>();

        System.out.println("size : " + hashSet.size());
        System.out.println("eles : " + hashSet);

        System.out.println(hashSet.add("Nihir"));;

        System.out.println("size : " + hashSet.size());
        System.out.println("eles : " + hashSet);
    }
}
