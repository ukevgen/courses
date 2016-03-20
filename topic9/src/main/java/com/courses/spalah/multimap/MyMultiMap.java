package com.courses.spalah.multimap;

import java.util.*;

/**
 * Created by Администратор on 15.03.2016.
 */
public class MyMultiMap<K, V> implements MultiMap<K, V> {
    private Collection<V> value;
    private HashMap<K, Collection<V>> map = new HashMap<K, Collection<V>>();

    @Override
    public boolean put(K k, V v) {
        if (map.containsKey(k)) {
            value = map.get(k);
            value.add(v);
            map.put(k, value);

        } else {
            value = new ArrayList<V>();
            value.add(v);
            map.put(k, value);
        }
        return true;
    }

    @Override
    public Collection<V> get(K k) {
        if (map.containsKey(k))
            return map.get(k);
        else {
            value.clear();
            return value;
        }
    }

    @Override
    public Collection<V> removeAll(K k) {
        if (map.containsKey(k)) {
            Collection<V> list = map.remove(k);
            return list;
        } else
            return new ArrayList<V>();
    }

    @Override
    public boolean remove(K k, V v) {
        boolean b = false;
        // for (Map.Entry<K, Collection<V>> entry : map.entrySet()) {
        if (map.containsKey(k)) {
            value = map.get(k);
            if (value.contains(v)) {
                value.remove(v);
                map.put(k, value);
                b = true;
            }
        }

        return b;
    }

    @Override
    public Collection<V> allValues() {
        return all();
    }

    @Override
    public boolean containsValue(V v) {
        return all().contains(v);
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public int size() {
        return map.size();
    }

    private Collection<V> all() {
        ArrayList<V> list = new ArrayList<>();
        for (Map.Entry<K, Collection<V>> entry : map.entrySet()) {
            list.addAll(entry.getValue());
        }
        return list;
    }
}
