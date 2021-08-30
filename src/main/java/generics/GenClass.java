package generics;

import java.util.*;

public class GenClass<T> implements Comparator {
    private T value;

    public GenClass(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}

class Stats<T extends Number> {
    T[] nums;

    public Stats(T[] nums) {
        this.nums = nums;
    }

    double average() {
        double sum = 0D;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue();
        }
        return sum / nums.length;
    }

    boolean sameAvg(Stats<?> other) {
        if (average() == other.average()) {
            return true;
        }
        return false;
    }
}

class TowD {
    int x, y;

    TowD(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class ThreeD extends TowD {
    int z;

    ThreeD(int a, int b, int c) {
        super(a, b);
        z = c;
    }
}

class FourD extends ThreeD {
    int t;
    FourD(int a, int b, int c, int d) {
        super(a, b, c);
        t = d;
    }
}

class Coords<T extends TowD> {
    T[] coords;

    public Coords(T[] coords) {
        this.coords = coords;
    }

    static void showXY(Coords<? extends ThreeD> c) {
        System.out.println("Coords X Y:");
        for (int i = 0; i < c.coords.length; i++) {
            System.out.println(
                    c.coords[i].x
                        + " " + c.coords[i].y
                            + " " + c.coords[i].z
            );
        }
        System.out.println(" ");
    }
}

class GenSubClass {
    public static void main(String[] args) {
        Coords.showXY(new Coords<>(
               new ThreeD[] {
                       new ThreeD(1, 3, 4),
                       new ThreeD(1, 3, 4),
                       new ThreeD(1, 3, 4)
               }
        ));

        Stats<Integer> stats = new Stats<Integer>(new Integer[] {12, 2, 2});
        System.out.println(stats.average());
        Stats<Double> stats2 = new Stats<Double>(new Double[] {12d, 2d, 2d});
        System.out.println(stats2.average());

        System.out.println(stats.sameAvg(stats2));

        GenClass<String> genClass1 = new GenClass<String>("My name is Igor. Age: ");
        GenClass<Integer> genClass2 = new GenClass<Integer>(25);
        System.out.println(genClass1.getValue() + " " + genClass2.getValue());

        System.out.println("This is LinkedList");
        List<Integer> integerList = new LinkedList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(14);
        integerList.add(15);
        integerList.stream()
                .forEach(System.out::println);

    }
}

