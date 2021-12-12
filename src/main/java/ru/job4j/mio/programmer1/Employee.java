package ru.job4j.mio.programmer1;

import java.io.Serializable;

public class Employee implements Serializable {
    static final long serialVersionUID = 1;
    int age;
    Car car;
    String name;
    transient double salary;
    transient String department;

    public Employee(String name, String department, int age, double salary, Car car) {
        this.age = age;
        this.car = car;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employees{"
                + "name='" + name + '\''
                + ", department='" + department + '\''
                + ", age=" + age
                + ", salary=" + salary
                + ", car=" + car
                + '}';
    }
}
