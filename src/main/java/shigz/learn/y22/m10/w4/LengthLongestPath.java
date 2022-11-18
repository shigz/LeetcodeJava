package shigz.learn.y22.m10.w4;

import java.util.Stack;

/**
 * Created by 大史 on 2022/11/1
 */
public class LengthLongestPath {

    public int lengthLongestPath(String input) {
        String[] pathArr = input.split("\\\n");
        int currentDirLength = 0;
        int result = 0;
        Stack<Integer> lengthStack = new Stack<>();
        for (String path : pathArr) {
            int level = 0;
            //统计 tab 符号个数
            //保留最后一个 /t 的 index
            int index = 0;
            int nextIndex = path.indexOf("\t");
            while (nextIndex >= 0) {
                level++;
                index = nextIndex + 1;
                nextIndex = path.indexOf("\t", index);
            }
            //仅保留比自身级别高的目录
            while (level < lengthStack.size()) {
                currentDirLength = currentDirLength - lengthStack.pop() - 1;
            }
            //当前文件或目录长度
            int currentLength = path.length() - index;
            if (path.contains(".")) {
                //为文件,计算当前绝对路径长度并更新最大长度
                result = Math.max(result, currentDirLength + currentLength);
            } else {
                //当前目录长度入栈
                lengthStack.add(currentLength);
                currentDirLength += currentLength + 1;
            }
        }
        return result;
    }

}
