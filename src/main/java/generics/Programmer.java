package generics;

import java.util.*;

public class Programmer extends Person {

    public Programmer(String name, int age, Date birthday) {
        super(name, age, birthday);
    }

    public static void main(String[] args) {
        List<Person> per = List.of(new Person("name", 21, new Date(913716000000L)));
        new GenericUsage().printRsl(per);

        List<Programmer> pro = List.of(new Programmer("name123", 23, new Date(913716000000L)));
        new GenericUsage().printInfo(pro);
    }
}
