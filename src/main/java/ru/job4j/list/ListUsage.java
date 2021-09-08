package ru.job4j.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ListUsage {
    public static void main(String[] args) {
        List<String> rsl = new ArrayList<>();
        rsl.add("one");
        rsl.add("two");
        rsl.add("three");
        ListUsage list = new ListUsage();
        list.output(rsl);
        rsl.add(1, "four");
        System.out.println();
        list.output(rsl);
        System.out.println();
        List<String> list1 = new ArrayList<>();
        list1.add("four");
        list1.add("five");
        rsl.addAll(list1);
        list.output(rsl);
        System.out.println("==========================");
        Iterator iterator = rsl.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("==========================");
        Iterator iterator2 = rsl.listIterator(3);
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
        System.out.println("==========================");
        rsl.replaceAll(String::toUpperCase);
        list.output(rsl);
        System.out.println("==========================");
        List<String> rsl2 = rsl.subList(2, 5);
        list.output(rsl2);
        System.out.println("==========================");
        rsl2.sort(Comparator.naturalOrder());
        list.output(rsl2);
    }

     void output(List<String> list) {
        list.stream()
                .map(x -> "Current the element is " + x)
                .forEach(System.out::println);
    }

}
