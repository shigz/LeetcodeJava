package shigz.learn.y22.m10.w2;

/**
 * Created by 大史 on 2022/10/9
 */
public class CanWinNim {

    public boolean canWinNim(int n) {
        if (n > 3) {
            boolean[] winArr = new boolean[n];
            winArr[0] = true;
            winArr[1] = true;
            winArr[2] = true;
            int index = 3;
            while (index < n) {
                winArr[index] = !(winArr[index - 1] && winArr[index - 2] && winArr[index - 3]);
                index++;
            }
            return winArr[n - 1];
        } else return true;
    }

}
