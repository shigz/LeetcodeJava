package shigz.learn.y22.m9.w3;

import java.util.List;

/**
 * Created by 大史 on 2022/9/21
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] resultArr = new boolean[s.length()];
        int index = 0;
        while (index < s.length()) {
            for (String word :wordDict) {
                int startIndex = index + 1 - word.length();
                if (startIndex >= 0) {
                    if (isEqualsFrom(s,word, startIndex)) {
                        if (startIndex == 0 || resultArr[startIndex - 1]) {
                            resultArr[index] = true;
                            break;
                        }
                    }
                }
            }
            index++;
        }
        return resultArr[s.length() - 1];
    }

    private boolean isEqualsFrom(String s, String word, int index) {
        int j = 0;
        while (j < word.length()) {
            if (s.charAt(index + j) != word.charAt(j)) return false;
            j++;
        }
        return true;
    }

    private boolean isMatchFrom(String s, List<String> wordDict, int index) {
        if (index < s.length()) {
            for (String word : wordDict) {
                if (isEqualsFrom(s, word, index)) {
                    if (isMatchFrom(s, wordDict, index + word.length())) return true;
                }
            }
            return false;
        } else return true;
    }

    //暴力解法,复杂情况下超时
    public boolean firstTry(String s, List<String> wordDict) {
        return isMatchFrom(s, wordDict, 0);
    }

}
