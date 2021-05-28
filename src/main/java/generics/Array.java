package generics;

public class Array {
    public static void main(String[] args) {
        int size = 10;
        SimpleArray arr = new SimpleArray<>(size);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        arr.add(7);
        arr.add(8);
        arr.add(9);
        arr.add(10);
        arr.set(0, 20);
        arr.remove(4);
        System.out.println();
        while (arr.hasNext()) {
            System.out.println(arr.next());
        }
        System.out.println();
        System.out.println(arr.get(5));
    }
}
