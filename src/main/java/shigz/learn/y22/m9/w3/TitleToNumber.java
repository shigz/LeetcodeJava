package shigz.learn.y22.m9.w3;

/**
 * Created by 大史 on 2022/9/23
 */
public class TitleToNumber {

    public int titleToNumber(String columnTitle) {
        int result = 0;
        int index = 0;
        while (index < columnTitle.length()) {
            result = result * 26 + columnTitle.charAt(index) - 64;
            index++;
        }
        return result;
    }

}
