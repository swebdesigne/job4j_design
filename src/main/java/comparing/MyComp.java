package comparing;

import java.util.*;


public class MyComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);
    }
}

class CompDemo {
    public static void main(String[] args) {
        String[] arr = {"1", "2"};
        arr = Arrays.stream(arr)
                .sorted((a, b) -> b.compareTo(a))
                .toArray(String[]::new);
        Arrays.stream(arr).forEach(System.out::println);

        TreeSet<String> treeSet = new TreeSet<>((a, b) -> b.compareTo(a));
        treeSet.add("C");
        treeSet.add("A");
        treeSet.add("B");
        treeSet.add("E");
        treeSet.add("F");
        treeSet.add("D");
        System.out.println(treeSet);
    }
}
