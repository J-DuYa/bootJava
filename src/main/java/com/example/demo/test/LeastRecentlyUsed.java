package com.example.demo.test;

import java.util.HashMap;

public class LeastRecentlyUsed {
    public Integer limit;
    private Node head;
    private Node end;
    private HashMap<String, Node> hashMap;

    public LeastRecentlyUsed(Integer limit) {
        this.limit = limit;
        hashMap = new HashMap<String, Node>();
    }

    /**
     * 查询节点信息
     * @param {key} 节点的key值
     * */
    public String get (String key) {
        Node node = hashMap.get(key);
        if (node == null) {
            return null;
        }
        refreshNode(node);
        return node.value;
    }

    private String removeNode (Node node) {
        if (node == head && node == end) {
            head = null;
            end = null;
        } else if (node == head) {
            head = head.next;
            head.pre = null;
        } else if (node == end) {
            end = end.pre;
            end.next = null;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        return node.key;
    }

    public void remove (String key) {
        Node node = hashMap.get(key);
        removeNode(node);
        hashMap.remove(key);
    }

    /**
     * 更新节点信息
     * @param
     * */
    public void put (String key, String value) {
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
            refreshNode(node);
        }
    }

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

    private void refreshNode (Node node) {
        if (node == end) {
            return;
        }

        removeNode(node);
        addNode(node);
    }

    class Node {
        Node(String key, String value) {
            this.value = value;
            this.key = key;
        }

        public String key;
        public String value;
        public Node next;
        public Node pre;
    }

    public static void main(String[] args) {
        LeastRecentlyUsed leastRecentlyUsed = new LeastRecentlyUsed(2);
        leastRecentlyUsed.put("1号", "test --- 1");
        leastRecentlyUsed.put("2号", "test --- 2");
        leastRecentlyUsed.put("3号", "test --- 3");
        System.out.println(leastRecentlyUsed.get("1号"));
    }
}
