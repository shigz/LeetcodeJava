package shigz.learn.y22.m10.w2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 大史 on 2022/10/13
 */
public class IsSelfCrossing {

    public boolean isSelfCrossing(int[] distance) {
        int n = distance.length;
        for (int i = 3; i < n; ++i) {
            // 第 1 类路径交叉的情况
            if (distance[i] >= distance[i - 2] && distance[i - 1] <= distance[i - 3]) {
                return true;
            }

            // 第 2 类路径交叉的情况
            if (i == 4 && (distance[3] == distance[1]
                    && distance[4] >= distance[2] - distance[0])) {
                return true;
            }

            // 第 3 类路径交叉的情况
            if (i >= 5 && (distance[i - 3] - distance[i - 5] <= distance[i - 1]
                    && distance[i - 1] <= distance[i - 3]
                    && distance[i] >= distance[i - 2] - distance[i - 4]
                    && distance[i - 2] > distance[i - 4])) {
                return true;
            }
        }
        return false;
    }

}
