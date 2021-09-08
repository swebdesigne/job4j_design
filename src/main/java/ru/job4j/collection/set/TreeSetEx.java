package ru.job4j.collection.set;

import java.util.Objects;
import java.util.TreeSet;

public class TreeSetEx {
    public static void main(String[] args) {
        TreeSet<Student> treeSet = new TreeSet();
        Student st1 = new Student("Igor", 5);
        Student st2 = new Student("Boris", 1);
        Student st3 = new Student("Alina", 4);
        treeSet.add(st1);
        treeSet.add(st2);
        treeSet.add(st3);
        System.out.println(treeSet);
    }

}

class Student implements Comparable<Student> {
    String name;
    int course;

    public Student(String name, int course) {
        this.name = name;
        this.course = course;
    }

    @Override
    public int compareTo(Student o) {
        return course - o.course;
    }

    @Override
    public String toString() {
        return "Student = " + name
                + " course = " + course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return course == student.course && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, course);
    }
}