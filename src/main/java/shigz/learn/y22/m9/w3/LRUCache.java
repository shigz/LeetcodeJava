package shigz.learn.y22.m9.w3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 大史 on 2022/9/21
 */
public class LRUCache {

    private final int capacity;
    private final Integer[] keyArr;
    private final Map<Integer, Integer> valueMap = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        keyArr = new Integer[capacity];
        Arrays.fill(keyArr, null);
    }

    public int get(int key) {
        if (valueMap.containsKey(key)) {
            int index = capacity - 1;
            while (keyArr[index] == null || keyArr[index] != key) {
                index--;
            }
            while (index > 0) {
                keyArr[index] = keyArr[index - 1];
                index--;
            }
            keyArr[0] = key;
            return valueMap.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (!valueMap.containsKey(key)) {
            if (valueMap.size() == capacity) {
                valueMap.remove(keyArr[capacity - 1]);
            }
            int index = capacity - 1;
            while (index > 0) {
                keyArr[index] = keyArr[index - 1];
                index--;
            }
        } else {
            int index = capacity - 1;
            while (keyArr[index] == null || keyArr[index] != key) {
                index--;
            }
            while (index > 0) {
                keyArr[index] = keyArr[index - 1];
                index--;
            }
        }
        keyArr[0] = key;
        valueMap.put(key, value);
    }

}
