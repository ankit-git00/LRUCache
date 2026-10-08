package lruCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
    int capacity;
    Map<K, Node<K,V >> map;
    DoubleLinkedList<K,V> linkedList;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        linkedList = new DoubleLinkedList<>();
    }

    public V get(K key) {
        if(!map.containsKey(key)){
            return null;
        }

        Node<K,V> node = map.get(key);
        linkedList.moveToFront(node);
        return node.value;
    }

    public void put(K key, V value) {
        if(!map.containsKey(key)){
            if(map.size() == capacity){
            Node<K,V> last = linkedList.removeLast();
            if(last != null){
                map.remove(last.key);
            }
            }
            Node<K,V> node= new Node<>(key,value);
            map.put(key,node);
            linkedList.addToFront(node);
        }

        else{
            Node<K,V> node= map.get(key);
            node.value = value;
            map.put(key,node);
            linkedList.moveToFront(map.get(key));
        }
    }

    public void remove(K key) {
        if(!map.containsKey(key)){
            return;
        }
        Node<K,V> node= map.get(key);
        linkedList.remove(node);
        map.remove(key);
    }
}