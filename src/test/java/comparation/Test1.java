package comparation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Test1 {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(4, "Igor", "Sivolobov", 22));
        list.add(new Employee(2, "Alina", "Sivolobova", 32));
        list.add(new Employee(3, "Boris", "Sivolobov", 50));
        System.out.println(list);
        Collections.sort(list, new IdComparator());
        System.out.println(list);
    }
}

class Employee {
    Integer id;
    String name;
    String surname;
    int salary;

    public Employee(int id, String name, String surname, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", surname='" + surname + '\''
                + ", salary=" + salary
                + '}';
    }

}

class IdComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.surname.compareTo(o2.surname);
    }


}
