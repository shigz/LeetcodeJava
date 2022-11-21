package shigz.learn.y22.m11;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 大史 on 2022/11/18
 * 基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。
 * 假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。
 * 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
 * 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。（变化后的基因必须位于基因库 bank 中）
 * 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。如果无法完成此基因变化，返回 -1 。
 * 注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。
 * 示例 1：
 * 输入：start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
 * 输出：1
 * 示例 2：
 * 输入：start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
 * 输出：2
 * 示例 3：
 * 输入：start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC","AACCCCCC"]
 * 输出：3
 * 提示：
 * start.length == 8
 * end.length == 8
 * 0 <= bank.length <= 10
 * bank[i].length == 8
 * start、end 和 bank[i] 仅由字符 ['A', 'C', 'G', 'T'] 组成
 */
public class MinMutation {

    public int minMutation(String startGene, String endGene, String[] bank) {
        List<String> targetList = new ArrayList<>();
        boolean haveEndGene = false;
        for (String target : bank) {
            targetList.add(target);
            if (target.equals(endGene)) haveEndGene = true;
        }
        if (haveEndGene) {
            List<char[]> srcList1 = new ArrayList<>();
            List<char[]> srcList2 = new ArrayList<>();
            int count = 1;
            srcList1.add(startGene.toCharArray());
            while (!srcList1.isEmpty()) {
                //从后向前遍历 target 列表,有与 srcList1 中基因序列为相近序列的,若为结束序列,返回当前 count,否则加入到 srcList2
                for (int index = targetList.size() - 1; index >= 0; index--) {
                    String target = targetList.get(index);
                    char[] targetCharArr = target.toCharArray();
                    for (char[] src : srcList1) {
                        if (isNearly(targetCharArr, src)) {
                            if (target.equals(endGene)) return count;
                            targetList.remove(index);
                            srcList2.add(targetCharArr);
                            break;
                        }
                    }
                }
                //清空源列表
                srcList1.clear();
                count++;
                if (!srcList2.isEmpty()) {
                    //从后向前遍历 target 列表,有与 srcList2 中基因序列为相近序列的,若为结束序列,返回当前 count,否则加入到 srcList1
                    for (int index = targetList.size() - 1; index >= 0; index--) {
                        String target = targetList.get(index);
                        char[] targetCharArr = target.toCharArray();
                        for (char[] src : srcList2) {
                            if (isNearly(targetCharArr, src)) {
                                if (target.equals(endGene)) return count;
                                targetList.remove(index);
                                srcList1.add(targetCharArr);
                                break;
                            }
                        }
                    }
                    //清空源列表
                    srcList2.clear();
                    count++;
                }
            }
        }
        return -1;
    }

    //判断两个基因序列是否为相近序列
    //由于基因序列都为 8 个字符长度,则仅判断不相同的基因序列个数
    private boolean isNearly(char[] geneArr1, char[] geneArr2) {
        int diff = 0;
        for (int i = 0; i < geneArr1.length; i++) {
            if (geneArr1[i] != geneArr2[i]) diff++;
        }
        return diff == 1;
    }

}
