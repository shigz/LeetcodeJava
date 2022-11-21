package shigz.learn.y22.m11;

/**
 * Created by 大史 on 2022/11/18
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * 示例:
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 */
public class CountSegments {

    public int countSegments(String s) {
        int result = 0;
        //记录当前统计的非空字符数量
        int charCount = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                //如果字符当前为空格
                //如果之前字符个数不为 0,则单次个数加 1 并重置字符个数
                if (0 < charCount) {
                    charCount = 0;
                    result++;
                }
                //当前字符不为空格,计数累计
            } else charCount++;
        }
        //字符个数不为 0,则单词个数加 1
        if (0 < charCount) result++;
        return result;
    }

}
