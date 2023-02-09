package com.lruCache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class CacheItem<K, V> {

    private K key;
    private V value;
    private CacheItem prev, next;

    public CacheItem(K key, V value) {
        this.value = value;
        this.key = key;
    }

    public CacheItem getPrev() {
        return prev;
    }

    public void setPrev(CacheItem prev) {
        this.prev = prev;
    }

    public CacheItem getNext() {
        return next;
    }

    public void setNext(CacheItem next) {
        this.next = next;
    }

    public V getValue() {
        return this.value;
    }

    public K getKey() {
        return this.key;
    }

    public String toString(){

        return "key: "+ key + " value: "+ value;
    }
}

class Cache<K, V> {

    private Map<K, CacheItem> map;
    private List<CacheItem> list;
    private CacheItem first, last;
    private int size;
    private final int MAX_CAPACITY;

    public Cache(int capacity) {

        MAX_CAPACITY = capacity;
        map = new HashMap<>(MAX_CAPACITY);
        list = new LinkedList<>();
    }

    public String toString(){

        Set<Map.Entry<K, CacheItem>> entrySet = map.entrySet();
        for (Map.Entry<K, CacheItem> entry : entrySet) {
            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
        }
        return super.toString();
    }

    /**
     * Time complexity: O(1)
     */
    public void put(K key, V value) {

        if (this.size == MAX_CAPACITY) {
            // remove first Node
            map.remove(first.getKey());
            deleteNode(first);
            size--;
        }

        CacheItem cacheItem = addNode(key, value);
        map.put(key, cacheItem);
    }

    /**
     * Time complexity: O(1)
     */
    public V get(K key) {

        if (!map.containsKey(key))
            return null;

        CacheItem<K, V> cacheItem = map.get(key);
        deleteNode(cacheItem);
        cacheItem = addNode(cacheItem.getKey(), cacheItem.getValue());
        return cacheItem.getValue();

    }

    private void deleteNode(CacheItem cacheItem) {

        if (first == cacheItem)
            first = cacheItem.getNext();
        else if (last == cacheItem)
            last = cacheItem.getPrev();


        CacheItem prev = cacheItem.getPrev();
        CacheItem next = cacheItem.getNext();

        if (next != null)
            next.setPrev(prev);
        if (prev != null)
            prev.setNext(next);

        list.remove(cacheItem);
        size--;
    }

    private CacheItem addNode(K key, V value) {

        CacheItem cacheItem = new CacheItem(key, value);
        if (this.size == 0) {
            first = cacheItem;
            last = cacheItem;

        } else {
            last.setNext(cacheItem);
            cacheItem.setPrev(last);
            last = cacheItem;
        }
        size++;
        return cacheItem;
    }

    public int size() {
        return size;
    }
}

public class CacheImpl {

    public static void main(String[] args) {

        Cache<Integer, String> cache = new Cache(3);
        cache.put(1, "One");
        System.out.println(cache);
        cache.put(2, "Two");
        System.out.println(cache);
        cache.put(3, "Three");
        System.out.println(cache);
        cache.get(1);
        System.out.println(cache);
        cache.get(2);
        System.out.println(cache);
        cache.put(4, "Four");
        System.out.println(cache);




    }

}




