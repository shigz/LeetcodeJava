package shigz.learn.y22.m10.w4;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by 大史 on 2022/10/26
 */
public class Train {

    //采用 TreeSet,以保证输出结果按字典顺序
    private static final TreeSet<String> resultSet = new TreeSet<>();

    public static void main(String[] args) {
        int[] trainArr = new int[]{3,2,1};
        dfs(trainArr,0,new ArrayList<>(),new ArrayList<>());
        for (String trainOrder:resultSet) {
            System.out.println(trainOrder);
        }
    }

    private static void dfs(int[] numArr, int index, List<Integer> inList, List<Integer> outList) {
        if (index < numArr.length) {
            //记录当前站内火车数量
            int inCount = inList.size();
            //当前火车进站
            inList.add(numArr[index]);
            dfs(numArr, index + 1, inList, outList);
            //逐个将站内火车出站,之后当前火车进站并进行迭代
            for (int i = 0; i < inCount; i++) {
                //移除当前火车
                inList.remove(inList.size() - 1);
                //站内最好入站的火车出站
                outList.add(inList.remove(inList.size() - 1));
                //当前火车进站
                inList.add(numArr[index]);
                dfs(numArr, index + 1, inList, outList);
            }
            //将出站和入站队列还原
            inList.remove(0);
            for (int i = 0; i < inCount; i++) {
                inList.add(outList.remove(outList.size() - 1));
            }
        } else {
            //所有火车都已加入到进站或出站列表,添加结果到结果 Set
            StringBuilder sb = new StringBuilder();
            //顺序添加已出站火车列表
            for (int num : outList) {
                sb.append(num).append(" ");
            }
            //反序添加未出站火车列表
            for (int i = inList.size() - 1; i >= 0; i--) {
                sb.append(inList.get(i)).append(" ");
            }
            resultSet.add(sb.toString());
        }
    }

}
