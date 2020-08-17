package com.example.demo.test;

import java.util.HashMap;

/**
 * LRU算法 least recently used
 * */
public class LRU {
    private int limit;
    private HashMap<String, Node> hashMap;
    private Node head;
    private Node end;

    public LRU (int limit) {
        this.limit = limit;
        hashMap = new HashMap<String, Node>();
    }

    class Node {
        public String key;
        public String value;
        public Node pre;
        public Node next;

        public Node (String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    // 添加节点信息
    public void put(String key, String value) {
        Node node = hashMap.get(key);

        if (node == null) {
            if (hashMap.size() >= limit) {
                String oldKey = removeNode(head);
                hashMap.remove(oldKey);
            }
            node = new Node(key, value);
            addNode(node);
            hashMap.put(key, node);
        } else {
            node.value = value;
            removeNode(node);
        }
    }

    private String removeNode (Node node) {
        if (head == node && end == node) {
            head = null;
            end = null;
        } else if (head == node) {
            head = head.next;
            head.pre = null;
        } else if (end == node) {
            end = end.pre;
            end.next = null;
        } else {
            node.next.pre = node.pre;
            node.pre.next = node.next;
        }

        return node.value;
    }

    // 新增节点
    private void addNode (Node node) {
        if (end != null) {
            end.next = node;
            node.pre = end;
            node.next = null;
        }

        end = node;

        if (head == null) {
            head = node;
        }
    }

    // get
    public String get (String key) {
        Node node = hashMap.get(key);
        if (node == null) {
            return null;
        }

        return node.value;
    }

    // remove
    public void remove (String key) {
        Node node = hashMap.get(key);
        removeNode(node);
        hashMap.remove(key);
    }

    public static void main(String[] args) {
        LRU lru = new LRU(4);
        lru.put("1", "1号");
        System.out.println(lru.get("1"));
    }
}
