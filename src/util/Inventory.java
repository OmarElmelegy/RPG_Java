package util;

import java.util.ArrayList;
import java.util.Collections;

public class Inventory<T extends Comparable<T>> {

    private ArrayList<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
        System.out.println("Added an item to the bag.");
    }

    public T get(int index) {
        return items.get(index);
    }

    public int size() {
        return items.size();
    }

    // Inside Inventory<T>
    public void printItems() {
        System.out.println("--- INVENTORY ---");
        for (int i = 0; i < items.size(); i++) {
            // This automatically calls the toString() method we just wrote!
            System.out.println("[" + i + "] " + items.get(i));
        }
    }

    public void sortItems() {
        Collections.sort(items);
        System.out.println("Inventory sorted by Power!");
    }
}
