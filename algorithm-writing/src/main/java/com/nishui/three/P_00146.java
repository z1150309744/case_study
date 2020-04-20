package com.nishui.three;

import java.util.HashMap;

/**
 * @Description LRU缓存机制
 * @Date 2020年04月11日 20时35分
 * @Created by yiwen
 */
public class P_00146 {

    class DoubleLinkedNode {
        Integer key, value;
        DoubleLinkedNode prev;
        DoubleLinkedNode next;

        public DoubleLinkedNode(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 双向链表
     **/
    class DoubleLinkedList {
        DoubleLinkedNode head, tail;
        int size;

        public DoubleLinkedList() {
            head = new DoubleLinkedNode(null, null);
            tail = new DoubleLinkedNode(null, null);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addFirst(DoubleLinkedNode node) {

            head.next.prev = node;
            node.next = head.next;

            head.next = node;
            node.prev = head;
            size++;
        }

        public DoubleLinkedNode removeLast() {
            if (tail.prev == head) {
                return null;
            }

            DoubleLinkedNode lastNode = tail.prev;
            remove(lastNode);
            return lastNode;
        }

        public void remove(DoubleLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
    }

    class LRUCache {

        HashMap<Integer, DoubleLinkedNode> cacheMap;
        DoubleLinkedList list;
        int capacity;
        int size;

        public LRUCache(int capacity) {
            cacheMap = new HashMap<>(capacity);
            list = new DoubleLinkedList();
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!cacheMap.containsKey(key)) {
                return -1;
            }

            DoubleLinkedNode node = cacheMap.get(key);
            list.remove(node);
            list.addFirst(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (cacheMap.containsKey(key)) {
                DoubleLinkedNode node = cacheMap.get(key);
                list.remove(node);

                node = new DoubleLinkedNode(key, value);
                list.addFirst(node);
                cacheMap.put(key, node);
            } else {
                if (size == capacity) {
                    DoubleLinkedNode node = list.removeLast();
                    cacheMap.remove(node.key);
                    size--;
                }

                DoubleLinkedNode node = new DoubleLinkedNode(key, value);
                list.addFirst(node);
                cacheMap.put(key, node);
                size++;
            }
        }
    }

}
