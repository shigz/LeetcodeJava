package shigz.learn.y22.m10.w2;

import java.util.*;

/**
 * Created by 大史 on 2022/10/13
 */
public class FindItinerary {

    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> resultList = new ArrayList<>();
        Map<String, Map<String, Integer>> fromToCountMap = new HashMap<>();
        for (List<String> ticket : tickets) {
            if (fromToCountMap.containsKey(ticket.get(0))) {
                Map<String, Integer> toCountMap = fromToCountMap.get(ticket.get(0));
                toCountMap.put(ticket.get(1), toCountMap.getOrDefault(ticket.get(1), 0) + 1);

            } else {
                Map<String, Integer> toCountMap = new TreeMap<>();
                toCountMap.put(ticket.get(1), 1);
                fromToCountMap.put(ticket.get(0), toCountMap);
            }
        }
        dfs(fromToCountMap, "JFK", resultList);
        return resultList;
    }

    private boolean dfs(Map<String, Map<String, Integer>> fromToCountMap, String from, List<String> resultList) {
        if (fromToCountMap.containsKey(from)) {
            Map<String, Integer> toCountMap = fromToCountMap.get(from);
            resultList.add(from);
            for (String to : toCountMap.keySet()) {
                Integer count = toCountMap.get(to);
                if (0 < count) {
                    toCountMap.put(to, count - 1);
                    if (dfs(fromToCountMap, to, resultList)) return true;
                    toCountMap.put(to, count);
                }
            }
            if (isFinished(fromToCountMap, resultList)) {
                return true;
            } else {
                resultList.remove(resultList.size() - 1);
                return false;
            }
        } else {
            if (isFinished(fromToCountMap, resultList)) {
                resultList.add(from);
                return true;
            } else return false;
        }
    }

    private boolean isFinished(Map<String, Map<String, Integer>> fromToCountMap, List<String> resultList) {
        for (Map<String, Integer> toCountMap : fromToCountMap.values()) {
            for (Integer count : toCountMap.values()) {
                if (0 < count) return false;
            }
        }
        return true;
    }

}
