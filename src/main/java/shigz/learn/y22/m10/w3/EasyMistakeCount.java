package shigz.learn.y22.m10.w3;

import java.util.*;

/**
 * Created by 大史 on 2022/10/19
 */
public class EasyMistakeCount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue<String> latestKeyQueue = new LinkedList<>();
        Set<String> deleteKeySet = new HashSet<>();
        Map<String,Integer> keyCountMap = new HashMap<>();
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String key = getKey(in.nextLine());
            if (!deleteKeySet.contains(key)) {
                if (keyCountMap.containsKey(key)) {
                    keyCountMap.put(key,1 + keyCountMap.get(key));
                } else {
                    if (latestKeyQueue.size() >= 8) {
                        String deleteKey = latestKeyQueue.poll();
                        deleteKeySet.add(deleteKey);
                        keyCountMap.remove(deleteKey);
                    }
                    latestKeyQueue.add(key);
                    keyCountMap.put(key,1);
                }
            }

        }
        while (0 < latestKeyQueue.size()) {
            String key = latestKeyQueue.poll();
            System.out.println(key + " " + keyCountMap.get(key));
        }
    }

    private static String getKey(String str) {
        int startIndex = str.lastIndexOf("\\") + 1;
        int spaceIndex = str.indexOf(" ", startIndex);
        if (startIndex + 16 < spaceIndex) {
            startIndex = spaceIndex - 16;
        }
        return str.substring(startIndex);
    }

}
