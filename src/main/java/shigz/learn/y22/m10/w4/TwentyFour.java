package shigz.learn.y22.m10.w4;

/**
 * Created by 大史 on 2022/10/25
 */
public class TwentyFour {

    private static int[] numArr = new int[4];
    private static int[] visitedArr = new int[4];

    public static void main(String[] args) {
        numArr[0] = 7;
        numArr[1] = 9;
        numArr[2] = 10;
        numArr[3] = 9;
        System.out.println(dfs(0, 0));
    }

    private static boolean dfs(int count, int currentValue) {
        if (currentValue == 24 && count == 4) return true;
        for (int i = 0; i < 4; i++) {
            if (visitedArr[i] == 0) {
                visitedArr[i] = 1;
                if (dfs(count + 1, currentValue * numArr[i]) || dfs(count + 1, currentValue + numArr[i]) || dfs(count + 1, currentValue - numArr[i]) || (currentValue % numArr[i] == 0 && dfs(count + 1, currentValue / numArr[i])))
                    return true;
                visitedArr[i] = 0;
            }
        }
        return false;
    }

}
