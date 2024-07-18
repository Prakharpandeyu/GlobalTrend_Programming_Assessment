import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModificationExample {

    public static void main(String[] args) {
        // Creating a list with initial elements
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Demonstrating ConcurrentModificationException
        try {
            for (String fruit : list) {
                if (fruit.equals("Banana")) {
                    list.remove(fruit); // This line will throw ConcurrentModificationException
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Caught ConcurrentModificationException: " + e.getMessage());
        }

        // Resetting the list to its initial state for proper removal demonstration
        list.clear();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Proper way to remove elements using an iterator
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            if (fruit.equals("Banana")) {
                iterator.remove(); // Using iterator's remove method to avoid exception
            }
        }

        System.out.println("Final list: " + list);
    }
}
