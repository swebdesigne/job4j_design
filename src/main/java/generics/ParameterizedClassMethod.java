package generics;

import java.util.ArrayList;
import java.util.List;

public class ParameterizedClassMethod {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(10);
        list1.add(20);
        list1.add(5);
        int a = GenMethod.getSecondElement(list1);
        System.out.println(a);
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Igor");
        list2.add("Boris");
        list2.add("Alina");
        String b = GenMethod.getSecondElement(list2);
        System.out.println(b);
    }
}

class GenMethod {
    public static <T> T getSecondElement(ArrayList<T> al) {
        return al.get(1);
    }
}
