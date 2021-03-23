package Algorithms3;

import java.util.HashMap;
import java.util.Map;

public class t146 {
    static class LRUCache {

        class Node {
            int key;
            int value;
            Node pre;
            Node next;

            Node() {

            }

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        Map<Integer, Node> cache = new HashMap<>();
        int size;
        int capacity;
        Node head, tail;


        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.next = head;
        }

        public int get(int key) {
            Node node = cache.get(key);
            if (node != null) {
                moveToHead(node);
                return node.value;
            }
            return -1;

        }

        public void put(int key, int value) {
            Node node = cache.get(key);
            if (node == null) {
                node = new Node(key, value);
                addToHead(node);
                cache.put(key, node);
                if (size < capacity) {
                    ++size;
                } else {
                    Node tail = removeTail();
                    cache.remove(tail.key);
                }
            } else {
                node.value = value;
                moveToHead(node);
            }
        }

        public void addToHead(Node node) {
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
        }

        public void removeNode(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        public Node removeTail() {
            Node pre = tail.pre;
            removeNode(tail.pre);
            return pre;
        }

        public void moveToHead(Node node) {
            removeNode(node);
            addToHead(node);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
    }
}
