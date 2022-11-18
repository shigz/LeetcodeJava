package shigz.learn.y22.m9.w4;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 大史 on 2022/9/27
 */
public class CanFinish {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer>[] cantSetArr = new HashSet[numCourses];
        for (int[] prerequisite : prerequisites) {
            int start = prerequisite[0];
            int end = prerequisite[1];
            if (start == end) return false;
            if (null != cantSetArr[start] &&cantSetArr[start].contains(end)) return false;
            if (cantSetArr[end] == null) {
                cantSetArr[end] = new HashSet<>();
            }
            cantSetArr[end].add(start);
            addCant(cantSetArr, cantSetArr[end], start);
        }
        return true;
    }

    private void addCant(Set<Integer>[] cantSetArr, Set<Integer> cantSet, int index) {
        if (cantSetArr[index] != null) {
            for (int num : cantSetArr[index]) {
                cantSet.add(num);
                addCant(cantSetArr, cantSet, num);
            }
        }
    }

}
