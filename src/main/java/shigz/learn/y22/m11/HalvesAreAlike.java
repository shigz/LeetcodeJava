package shigz.learn.y22.m11;

/**
 * Created by 大史 on 2022/11/11
 */
public class HalvesAreAlike {

    public boolean halvesAreAlike(String s) {
        int count = 0;
        char[] charArr = s.toCharArray();
        //前一半元音个数 +1
        //元音列表
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < charArr.length >> 1; i++) {
            if (vowels.indexOf(charArr[i]) >= 0) count++;
        }
        //后一半元音个数 -1
        for (int i = charArr.length >> 1; i < charArr.length; i++) {
            if (vowels.indexOf(charArr[i]) >= 0) count--;
        }
        //若元音个数最终为 0,则前后两半元音个数相同
        return count == 0;
    }

}
