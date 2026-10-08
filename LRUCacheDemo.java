package lruCache;

public class LRUCacheDemo {
    public static void main(String[] args) {
        LRUCache<String, Integer> cache = new LRUCache<>(3);

        cache.put("a", 1);
        cache.put("b", 2);
        cache.put("c", 3);

        System.out.println(cache.get("a"));
        System.out.println(cache.get("b"));

        cache.put("d", 4);

        System.out.println(cache.get("c"));
        cache.remove("a");
        System.out.println(cache.get("a"));

    }
}