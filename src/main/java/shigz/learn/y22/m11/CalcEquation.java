package shigz.learn.y22.m11;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 大史 on 2022/11/2
 */
public class CalcEquation {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> resultMap = new HashMap<>();
        double[] resultArr = new double[queries.size()];
        for (int i = 0; i < values.length; i++) {
            String first = equations.get(i).get(0);
            String second = equations.get(i).get(1);
            if (!resultMap.containsKey(first)) {
                resultMap.put(first, new HashMap<>());
            }
            if (!resultMap.containsKey(second)) {
                resultMap.put(second, new HashMap<>());
            }
            Map<String, Double> firstKeyValueMap = resultMap.get(first);
            Map<String, Double> secondKeyValueMap = resultMap.get(second);
            //记录第一个 key 除以第二个 key
            if (!firstKeyValueMap.containsKey(second)) {
                firstKeyValueMap.put(second, values[i]);
            }
            //遍历第二个 Key 和值的 Map,如 a / b = 2,b / c = 3,则 a / c = 3 * 2
            for (Map.Entry<String, Double> entry : secondKeyValueMap.entrySet()) {
                if (!firstKeyValueMap.containsKey(entry.getKey())) {
                    double value = values[i] * entry.getValue();
                    firstKeyValueMap.put(entry.getKey(), value);
                    resultMap.get(entry.getKey()).put(first, 1 / value);
                    for (String key :secondKeyValueMap.keySet()) {
                        if (!entry.getKey().equals(key) && !resultMap.get(entry.getKey()).containsKey(key)) {
                            resultMap.get(entry.getKey()).put(key, secondKeyValueMap.get(key) / secondKeyValueMap.get(entry.getKey()));
                            resultMap.get(key).put(entry.getKey(), secondKeyValueMap.get(entry.getKey()) / secondKeyValueMap.get(key));
                        }
                    }
                }
            }
            //记录第一个 key 除以第二个 key
            if (!secondKeyValueMap.containsKey(first)) {
                secondKeyValueMap.put(first, 1 / values[i]);
            }
            //遍历缓存的第一个 Key 和值的 Map,如 a / b = 2,a / c = 3, 则 b / c  = 2 / 3
            for (Map.Entry<String, Double> entry : firstKeyValueMap.entrySet()) {
                if (!secondKeyValueMap.containsKey(entry.getKey())) {
                    double value = entry.getValue() / values[i];
                    secondKeyValueMap.put(entry.getKey(), value);
                    resultMap.get(entry.getKey()).put(second, values[i] / entry.getValue());
                    for (String key :firstKeyValueMap.keySet()) {
                        if (!entry.getKey().equals(key) && !resultMap.get(entry.getKey()).containsKey(key)) {
                            resultMap.get(key).put(entry.getKey(), firstKeyValueMap.get(entry.getKey()) / firstKeyValueMap.get(key));
                            resultMap.get(entry.getKey()).put(key, firstKeyValueMap.get(key) / firstKeyValueMap.get(entry.getKey()));
                        }
                    }
                }
            }
        }
        //遍历结果
        for (int i = 0; i < queries.size(); i++) {
            resultArr[i] = getResult(queries.get(i), resultMap);
        }
        return resultArr;
    }

    private double getResult(List<String> query, Map<String, Map<String, Double>> resultMap) {
        String firstKey = query.get(0);
        String secondKey = query.get(1);
        if (resultMap.containsKey(firstKey)) {
            if (secondKey.equals(firstKey)) return 1.0;
            return resultMap.get(firstKey).getOrDefault(secondKey, -1.0);

        } else return -1.0;
    }

}
