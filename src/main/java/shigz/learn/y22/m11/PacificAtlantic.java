package shigz.learn.y22.m11;

import java.util.*;

/**
 * Created by 大史 on 2022/11/9
 */
public class PacificAtlantic {

    private final int[][] offsets = new int[][]{
            new int[]{0, -1},
            new int[]{0, 1},
            new int[]{1, 0},
            new int[]{-1, 0},
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> resultList = new ArrayList<>();
        int maxCount = m * n;
        int[] pacificArr = new int[maxCount];
        int[] atlanticArr = new int[maxCount];
        Queue<Integer> pacificQueue = new ArrayDeque<>();
        Queue<Integer> atlanticQueue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            pacificQueue.add(i);
            pacificArr[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            int index = i * n;
            pacificQueue.add(index);
            pacificArr[index] = 1;
        }
        int preIndex = n * (m - 1);
        for (int i = 0; i < n; i++) {
            int index = preIndex + i;
            atlanticArr[index] = 1;
            atlanticQueue.add(index);
        }
        for (int i = 0; i < m - 1; i++) {
            int index = i * n + n - 1;
            atlanticArr[index] = 1;
            atlanticQueue.add(index);
        }
        while (!pacificQueue.isEmpty()) {
            int count = pacificQueue.size();
            for (int i = 0; i < count; i++) {
                int index = pacificQueue.poll();
                int x = index / n;
                int y = index % n;
                for (int[] offset : offsets) {
                    int newX = x + offset[0];
                    int newY = y + offset[1];
                    if (newX >= 0 && newY >= 0 && newX < m && newY < n) {
                        int newIndex = newX * n + newY;
                        if (pacificArr[newIndex] == 0 && heights[newX][newY] >= heights[x][y]) {
                            pacificArr[newIndex] = 1;
                            pacificQueue.add(newIndex);
                        }
                    }
                }
            }
        }
        while (!atlanticQueue.isEmpty()) {
            int count = atlanticQueue.size();
            for (int i = 0; i < count; i++) {
                int index = atlanticQueue.poll();
                int x = index / n;
                int y = index % n;
                for (int[] offset : offsets) {
                    int newX = x + offset[0];
                    int newY = y + offset[1];
                    if (newX >= 0 && newY >= 0 && newX < m && newY < n) {
                        int newIndex = newX * n + newY;
                        if (atlanticArr[newIndex] == 0 && heights[newX][newY] >= heights[x][y]) {
                            atlanticArr[newIndex] = 1;
                            atlanticQueue.add(newIndex);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < maxCount; i++) {
            if (atlanticArr[i] == 1 && pacificArr[i] == 1) {
                resultList.add(Arrays.asList(i / n, i % n));
            }
        }
        return resultList;
    }

}
