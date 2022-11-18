package shigz.learn.y22.m10.w4;

import java.util.*;

/**
 * Created by 大史 on 2022/10/25
 */
public class GradeOrder {

    private static TreeMap<Integer, Queue<String>> gradeStudentQueueMap;

    public static void main(String[] args) {
        int order = 0;
        gradeStudentQueueMap = order == 1 ? new TreeMap<>() : new TreeMap<>(Comparator.reverseOrder());
        add("fang", 90);
        add("yang", 50);
        add("ning", 70);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer,Queue<String>> entry:gradeStudentQueueMap.entrySet()) {
            while (!entry.getValue().isEmpty()) {
                sb.append(entry.getValue().poll()).append(" ").append(entry.getKey()).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void add(String student,int grade) {
        if (gradeStudentQueueMap.containsKey(grade)) {
            gradeStudentQueueMap.get(grade).add(student);
        } else {
            Queue<String> studentQueue = new ArrayDeque<>();
            studentQueue.add(student);
            gradeStudentQueueMap.put(grade,studentQueue);
        }
    }

}
