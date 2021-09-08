package ru.job4j.collection.set;

import java.util.HashSet;
import java.util.Set;
import java.util.*;

import static java.util.Objects.hash;

public class User {
    private String name;
    private String children;
    Calendar birthday;

    public User(String name, String children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass() || obj == null) {
            return false;
        }
        User user = (User) obj;
        return name.equals(user.name)
                && children.equals(user.children)
                && birthday.equals(user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    public static void main(String[] args) {
        User user1 = new User("Igor", "yes", new GregorianCalendar(2017, 11, 12));
        User user2 = new User("Igor", "yes", new GregorianCalendar(2017, 11, 12));

        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());
        for (User u : map.keySet()) {
            System.out.println("name = " + u.name);
            System.out.println("children = " + u.children);
            System.out.println("birthday = " + u.birthday.getTime());
            System.out.println("");
            System.out.println(u.hashCode());
        }
        System.out.println(user1.equals(user2));
        System.out.println(hash(user1.hashCode()) == hash(user2.hashCode()));
        Set<Integer> set = new HashSet<>();
        set.add(5);
        set.add(3);
        set.add(7);
        set.add(10);
        set.add(2);

        Set<Integer> set2 = new HashSet<>();
        set.add(5);
        set.add(4);
        set.add(1);
        set.add(10);
        set.add(2);

        Set<Integer> set3 = new HashSet<>(set);
        set3.retainAll(set2);
        System.out.println(set2);
    }
}
