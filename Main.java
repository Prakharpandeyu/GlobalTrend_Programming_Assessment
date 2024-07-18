import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Iterator;

class LRUCache {
    private final int capacity;
    private final Map<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        // The third argument 'true' indicates that we want to maintain access order.
        this.cache = new LinkedHashMap<>(capacity, 0.75F, true);
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        if (cache.size() >= capacity && !cache.containsKey(key)) {
            // Remove the least recently used item (the first entry in the map).
            Iterator<Map.Entry<Integer, Integer>> iterator = cache.entrySet().iterator();
            iterator.next();
            iterator.remove();
        }
        cache.put(key, value);
    }
}

public class Main {
    public static void main(String[] args) {
        // Example usage:
        LRUCache cache = new LRUCache(2);
        cache.put(1, 10);
        cache.put(2, 20);
        System.out.println("Value for key 1: " + cache.get(1)); // Expected output: 10
        System.out.println("Value for key 2: " + cache.get(2)); // Expected output: 20
        cache.put(3, 30); // Evicts key 1
        System.out.println("Value for key 1: " + cache.get(1)); // Expected output: -1
        System.out.println("Value for key 3: " + cache.get(3)); // Expected output: 30
        System.out.println("Value for key 2: " + cache.get(2)); // Expected output: 20
    }
}
