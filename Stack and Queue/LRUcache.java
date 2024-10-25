import java.util.*;

class Node {
    int key, value;
    Node next;
    Node prev;

    Node(int key, int value, Node prev) {
        this.key = key;
        this.value = value;
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "Node [key=" + key + ", value=" + value + "]";
    }
}

class Cache {
    private Map<Integer, Node> caches;
    private int capacity;
    private int size;
    private Node head, tail;

    Cache(int capacity) {
        this.capacity = capacity;
        caches = new HashMap<>();
        head = new Node(-1, -1, null);
        tail = new Node(-1, -1, head);
        head.next = tail;
    }

    public void put(int key, int value) {
        Node node;
        if (caches.containsKey(key)) {
            node = caches.get(key);
            node.value = value; // Update value
            deleteNode(node);
        } else {
            node = new Node(key, value, null);
            if (size >= capacity) {
                // Remove the LRU item
                caches.remove(tail.prev.key);
                deleteNode(tail.prev);
            }
        }
        insertAfterHead(node);
    }

    public int get(int key) {
        if (!caches.containsKey(key)) {
            return -1; // Not found
        }
        Node node = caches.get(key);
        deleteNode(node);
        insertAfterHead(node);
        return node.value; // Return the value
    }

    private void insertAfterHead(Node node) {
        caches.put(node.key, node);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        size++;
    }

    private void deleteNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
        caches.remove(node.key);
        size--;
    }
}

public class LRUcache {
    public static void main(String[] args) {
        Cache cache = new Cache(2);
        cache.put(1, 1); // cache is {1=1}
        cache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(cache.get(1));    // return 1
        cache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(cache.get(2));    // returns -1 (not found)
        cache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(cache.get(1));    // return -1 (not found)
        System.out.println(cache.get(3));    // return 3
        System.out.println(cache.get(4));    // return 4
    }
}
