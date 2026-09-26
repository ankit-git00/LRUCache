# LRU Cache

A generic, fixed-size Least Recently Used (LRU) cache implemented with a hash map and doubly linked list.

## Design

- `HashMap<K, Node<K, V>>` finds an entry in O(1) average time.
- The linked-list head stores the most recently used entry; its tail stores the least recently used entry.
- `get` promotes a hit to most-recently-used.
- `put` updates and promotes an existing entry, or evicts the least-recently-used entry when capacity is exceeded.

All `get` and `put` operations take O(1) average time. The cache rejects capacities less than one.

## Run

From `java/src`:

```bash
javac -d out lruCache/*.java
java -cp out lruCache.LRUCacheDemo
```
