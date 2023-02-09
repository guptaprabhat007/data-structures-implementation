package com.lruCache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUCache {

    static Integer MAX_CACHE_SIZE;
    Map<Integer, String> map;
    List<Integer> list;

    LRUCache(Integer cacheSize) {

        MAX_CACHE_SIZE = cacheSize;
        Map<Integer, String> map = new HashMap<>();
        List<Integer> list = new LinkedList<>();
    }

    public void put(Integer key, String value) {

        if (list.size() < MAX_CACHE_SIZE) {
            map.put(key, value);
            this.addFirst(list, key);
        } else {

            // LRU item to be evicted
            removeLast(list);
            map.put(key, value);
            this.addFirst(list, key);
        }
    }

    public String get(Integer key) {

        String value = map.containsKey(key) ? map.get(key) : null;
        if (value == null)
            return value;

        list.remove(key);
        this.addFirst(list, key);
        return value;
    }

    void addFirst(List list, Integer key) {
        list.add(0, key);
    }

    void removeLast(List list) {
        list.remove(list.size() - 1);
    }

    void removeFirst(List list) {
        list.remove(0);
    }
}
