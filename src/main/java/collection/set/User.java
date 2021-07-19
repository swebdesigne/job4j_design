package collection.set;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private String children;
    Calendar birthday;

    public User(String name, String children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        User user1 = new User("Igor", "yes", new GregorianCalendar(2017, 11 , 12));
        User user2 = new User("Igor", "yes", new GregorianCalendar(2017, 11 , 12));

        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());
        for (User u : map.keySet()) {
            System.out.println("name = " + u.name);
            System.out.println("children = " + u.children);
            System.out.println("birthday = " + u.birthday.getTime());
            System.out.println("");
        }
    }
}
