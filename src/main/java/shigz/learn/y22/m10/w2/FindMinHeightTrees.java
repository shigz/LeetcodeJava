package shigz.learn.y22.m10.w2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 大史 on 2022/10/10
 */
public class FindMinHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] in = new int[n];
        Map<Integer, List<Integer>> connect = new HashMap<>();
        for(int[] edge: edges) {
            in[edge[0]]++;
            in[edge[1]]++;
            List<Integer> l0 = connect.getOrDefault(edge[0], new ArrayList<>());
            l0.add(edge[1]);
            connect.put(edge[0], l0);
            List<Integer> l1 = connect.getOrDefault(edge[1], new ArrayList<>());
            l1.add(edge[0]);
            connect.put(edge[1], l1);
        }
        List<Integer> nodes = new ArrayList<>();
        for(int i = 0; i < n; i++)
            if(in[i] < 2)
                nodes.add(i);
        while(n > 2) {
            n -= nodes.size();
            List<Integer> nxt = new ArrayList<>();
            for(int node: nodes) {
                for(int other: connect.get(node)) {
                    in[other]--;
                    if(in[other] == 1)
                        nxt.add(other);
                }
            }
            nodes = nxt;
        }
        return nodes;
    }

}
