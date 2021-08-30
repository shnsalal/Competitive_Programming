import java.util.*;

public class LRUCacheProgram {
    public static void main(String[] args) {
        LRUCache<Integer> cache = new LRUCache<>();
        cache.add(1);
        cache.add(2);
        cache.add(3);
        cache.add(4);
        cache.add(5);
        cache.add(5);
        cache.add(5);
        cache.add(5);
        System.out.println(cache.get(5));
    }
}

class LRUCache<T> {
    int size;
    Map<T, Node<T>> map;
    Node<T> head;
    Node<T> tail;
    Node<T> current;

    public LRUCache(int size) {
        this.size = size;
        map = new HashMap<>(this.size);
    }

    public LRUCache() {
        map = new HashMap<>();
    }

    public T get(T item) {
        if (map.containsKey(item)) {
            if (map.size() == 1) {
                Node<T> temp = map.get(item);
                return temp.data;
            } else {
                Node<T> temp = map.get(item);
                map.remove(item);
                modifyLRUCache(temp, item);
                return temp.data;
            }
        } else {
            return null;
        }
    }

    public void add(T item) {
        Node<T> node = new Node<>(item);
        if (head == null) {
            head = node;
            tail = node;
            map.put(item, node);
        } else {
            if (map.containsKey(item)) {
                Node<T> temp = map.get(item);
                map.remove(item);
                modifyLRUCache(temp, item);
            } else {
                tail.next = node;
                node.previous = tail;
                tail = node;
                map.put(item, node);
            }
        }
    }

    private void modifyLRUCache(Node<T> temp, T item) {
        if (temp.previous == null) {
            head = head.next;
            head.previous = null;
            add(item);
        } else if (temp.next != null && temp.previous != null) {
            temp.previous.next = temp.next;
            temp.next.previous = temp.previous;
            add(item);
        } else if (temp.next == null) {
            add(item);
        }
    }
}

class Node<T> {
    T data;
    Node<T> next;
    Node<T> previous;

    public Node(T data) {
        this.data = data;
    }
}