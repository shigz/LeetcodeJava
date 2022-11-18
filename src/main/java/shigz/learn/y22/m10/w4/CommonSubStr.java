package shigz.learn.y22.m10.w4;

/**
 * Created by 大史 on 2022/10/26
 */
public class CommonSubStr {

    public static void main(String[] args) {
        System.out.println(maxLength("asdfas", "werasdfaswer"));
    }

    private static int maxLength(String shortStr, String longStr) {
        char[] shortCharArr = shortStr.toCharArray();
        char[] longCharArr = longStr.toCharArray();
        int result = 0;
        int index = 0;
        while (index < shortCharArr.length) {
            for (int i = 0; i < longCharArr.length; i++) {
                result = Math.max(result, equalsLength(shortCharArr, longCharArr, index, i));
                //如果当前匹配长度为短数组剩下的最长长度,直接结束
                if (result == shortCharArr.length - index) return result;
            }
            index++;
        }
        return result;
    }

    //递归获取从指定索引开始的两个字符数组字符相同的长度
    private static int equalsLength(char[] shortCharArr, char[] longCharArr, int shortStartIndex, int longStartIndex) {
        if (shortStartIndex < shortCharArr.length && longStartIndex < longCharArr.length && shortCharArr[shortStartIndex] == longCharArr[longStartIndex]) {
            return 1 + equalsLength(shortCharArr, longCharArr, shortStartIndex + 1, longStartIndex + 1);
        } else return 0;
    }

}
