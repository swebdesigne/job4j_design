package collection.queue;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListEx {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("Igor");
        queue.add("Boris");
        queue.add("Alina");
        System.out.println(queue);
        System.out.println(queue.remove());
        System.out.println(queue);
    }
}
