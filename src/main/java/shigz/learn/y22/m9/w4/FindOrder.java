package shigz.learn.y22.m9.w4;

import java.util.*;

/**
 * Created by 大史 on 2022/9/27
 */
public class FindOrder {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> postSetMap = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            if (!postSetMap.containsKey(prerequisite[1])) {
                postSetMap.put(prerequisite[1], new HashSet<>());
            }
            postSetMap.get(prerequisite[1]).add(prerequisite[0]);
        }
        int[] resultArr = new int[numCourses];
        int index = numCourses - 1;
        Queue<Integer> removeQueue = new LinkedList<>();
        while (index >= 0) {
            Integer nextCourse = getNextCourse(index, numCourses, resultArr, postSetMap);
            if (nextCourse == null) return new int[]{};
            resultArr[index] = nextCourse;
            clearCourse(postSetMap, nextCourse, removeQueue);
            index--;
        }
        return resultArr;
    }

    private void clearCourse(Map<Integer, Set<Integer>> postSetMap, int course, Queue<Integer> removeQueue) {
        postSetMap.remove(course);
        for (Map.Entry<Integer, Set<Integer>> entry : postSetMap.entrySet()) {
            entry.getValue().remove(course);
            if (0 == entry.getValue().size()) {
                removeQueue.add(entry.getKey());
            }
        }
        while (0 < removeQueue.size()) {
            postSetMap.remove(removeQueue.poll());
        }
    }

    private Integer getNextCourse(int index, int numCourses, int[] resultArr, Map<Integer, Set<Integer>> postSetMap) {
        int result = 0;
        while (result < numCourses) {
            if (notUsed(result,index,numCourses,resultArr) && !postSetMap.containsKey(result)) return result;
            result++;
        }
        return null;
    }

    private boolean notUsed(int result, int index, int numCourses, int[] resultArr) {
        for (int k = index + 1; k < numCourses; k++) {
            if (resultArr[k] == result) return false;
        }
        return true;
    }

}
