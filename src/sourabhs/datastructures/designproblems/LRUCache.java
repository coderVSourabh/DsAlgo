package sourabhs.datastructures.designproblems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sourabh
 */
public class LRUCache {

    private class Node {
        int key;
        int value;
        Node prev = null;
        Node next = null;
    }

    private Map<Integer, Node> cache = null;
    private int count, capacity;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);

        head = new Node();
        head.prev = null;
        tail = new Node();
        tail.next = null;

        head.next = tail;
        tail.prev = head;

    }

    public void put(int key, int value) {
        if(capacity != cache.size()){
            int a = 1;
        }
    }

    public int get(int key) {
        int res = -1;
        //if(map.get(key))
        return res;
    }

}
