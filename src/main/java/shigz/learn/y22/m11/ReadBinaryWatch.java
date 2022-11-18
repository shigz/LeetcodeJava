package shigz.learn.y22.m11;

import shigz.learn.y22.m9.w4.SummaryRanges;

import java.util.*;

/**
 * Created by 大史 on 2022/11/3
 */
public class ReadBinaryWatch {

    private static final Map<Integer, List<String>> hourMatrix = new HashMap<Integer, List<String>>() {
        {
            put(0, Collections.singletonList("0"));
            put(1, Arrays.asList("1", "2", "4", "8"));
            put(2, Arrays.asList("3", "5", "6", "9", "10"));
            put(3, Arrays.asList("7", "11"));
        }
    };
    private static final Map<Integer, List<String>> minuteMatrix = new HashMap<Integer, List<String>>() {
        {
            put(0, Collections.singletonList("00"));
            put(1, Arrays.asList("01", "02", "04", "08", "16", "32"));
            put(2, Arrays.asList("03", "05", "06", "09", "10", "12", "17", "18", "20", "24", "31", "34", "36", "40", "48"));
            put(3, Arrays.asList("07", "11", "13", "14", "19", "21", "22", "25", "26", "28", "35", "37", "38", "41", "42", "44", "49", "50", "52", "56"));
            put(4, Arrays.asList("15", "23", "27", "29", "30", "39", "43", "45", "46", "51", "53", "54", "57", "58"));
            put(5, Arrays.asList("31", "47", "55", "59"));
        }
    };


    public List<String> readBinaryWatch(int turnedOn) {
        Set<String> resultSet = new TreeSet<>();
        int hourCount = 0;
        while (hourCount <= Math.min(turnedOn, 3)) {
            int minuteCount = turnedOn - hourCount;
            if (minuteCount >= 0 && minuteCount <= 5) {
                for (String hour : hourMatrix.get(hourCount)) {
                    for (String minutes : minuteMatrix.get(minuteCount)) {
                        resultSet.add(hour + ":" + minutes);
                    }
                }
            }
            hourCount++;
        }
        return new ArrayList<>(resultSet);
    }

}
