package org.bon.obfuscator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Tommi
 * Date: 06/11/2019
 * Time: 4.18
 */

public class ClassMappings {

    Map<String, String> mappings = new HashMap<>();

    public int size() {
        return mappings.size();
    }

    public boolean isEmpty() {
        return mappings.isEmpty();
    }

    public boolean containsKey(Object key) {
        return mappings.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return mappings.containsValue(value);
    }

    public String get(Object key) {
        return mappings.get(key);
    }

    public String map(String key, String value) {
        return mappings.put(key, value);
    }

    public String remove(Object key) {
        return mappings.remove(key);
    }

    public void clear() {
        mappings.clear();
    }

    public String putIfAbsent(String key, String value) {
        return mappings.putIfAbsent(key, value);
    }

    public String replace(String key, String value) {
        return mappings.replace(key, value);
    }

    public Set<Map.Entry<String, String>> getMappings() {
        return mappings.entrySet();
    }
}
