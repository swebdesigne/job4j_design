package collection.set;

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
    public int hashCode() {
        return Objects.hashCode(name);
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
        System.out.println(hash(user1.hashCode()) == hash(user2.hashCode()));
    }
}
