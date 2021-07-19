package collection.set;

import java.util.Calendar;

public class User {
    private String name;
    private String children;
    Calendar birthday;

    public User(String name, String children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
}
