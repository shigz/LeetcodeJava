package shigz.learn.y22.m10.w2;

import java.util.*;

/**
 * Created by 大史 on 2022/10/12
 */
public class CountRangeSum {

    int m;
    int[] tr = new int[100010 * 3];

    int lowbit(int x) {
        return x & -x;
    }

    void add(int x, int v) {
        for (int i = x; i <= m; i += lowbit(i)) tr[i] += v;
    }

    int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i)) ans += tr[i];
        return ans;
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        Set<Long> set = new HashSet<>();
        long s = 0;
        set.add(s);
        for (int i : nums) {
            s += i;
            set.add(s);
            set.add(s - lower);
            set.add(s - upper);
        }
        List<Long> list = new ArrayList<>(set);
        Collections.sort(list);
        Map<Long, Integer> map = new HashMap<>();
        for (long x : list) map.put(x, ++m);
        s = 0;
        int ans = 0;
        add(map.get(s), 1);
        for (int i : nums) {
            s += i;
            int a = map.get(s - lower), b = map.get(s - upper) - 1;
            ans += query(a) - query(b);
            add(map.get(s), 1);
        }
        return ans;
    }

}
