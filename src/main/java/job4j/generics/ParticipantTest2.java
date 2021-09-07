package job4j.generics;

import java.util.ArrayList;

public class ParticipantTest2 {
    public static void main(String[] args) {
        ArrayList<?> list = new ArrayList<Integer>();
        ArrayList<Double> list1 = new ArrayList<>();
        list1.add(3.14);
        list1.add(3.15);
        showListInfo(list1);
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Alina");
        list2.add("Igor");
        list2.add("Boris");
        showListInfo(list2);
    }

    static void showListInfo(ArrayList<?> list) {
        System.out.println("My list contains the elements " + list);
    }
}
