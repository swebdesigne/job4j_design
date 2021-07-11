package set;

import java.util.*;

public class UsageSet {
    public static void main(String[] args) {
        Set<String> strings = new HashSet<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");
        strings.add("two");

        Set<String> string1 = new HashSet<>();
        string1.add("four");
        string1.add("two");
        string1.add("five");
        string1.add("six");
        strings.addAll(string1);

        Set<String> string2 = Set.of("seven", "eight", "nine", "ten");
        strings.addAll(string2);
        for (String s : strings) {
            System.out.println("The current element is " + s);
        }

        System.out.println("=====================");
        strings.stream()
                .filter(s -> s.length() < 5)
                .forEach(st -> System.out.println("The current element is " + st));
        System.out.println("=====================");
        strings.remove("two");
        strings.removeAll(Set.of("nine", "six"));
        boolean rsl = strings.retainAll(Set.of("five"));
        System.out.println("rsl = " + rsl);
        strings.addAll(Set.of("eleven", "twelve"));
        strings.removeIf(s -> s.startsWith("e"));
        strings.removeIf(s -> s.endsWith("ive"));
        Iterator<String> it = strings.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
