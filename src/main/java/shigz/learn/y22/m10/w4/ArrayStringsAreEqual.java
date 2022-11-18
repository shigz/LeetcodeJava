package shigz.learn.y22.m10.w4;

/**
 * Created by 大史 on 2022/11/1
 */
public class ArrayStringsAreEqual {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int index1 = 0;
        int index2 = 0;
        int wordIndex1 = 0;
        int wordIndex2 = 0;
        while (index1 < word1.length && index2 < word2.length) {
            if (wordIndex1 < word1[index1].length()) {
                if (wordIndex2 < word2[index2].length()) {
                    //当前两个字符串的当前元素有效,比较当前元素
                    if (word1[index1].charAt(wordIndex1) != word2[index2].charAt(wordIndex2)) return false;
                    wordIndex1++;
                    wordIndex2++;
                } else {
                    //word2 中下标为 index2 的数据 下标 wordIndex2 越界,移动到下一个字符串
                    index2++;
                    wordIndex2 = 0;
                }
            } else {
                //word1 中下标为 index1 的数据 下标 wordIndex1 越界,移动到下一个字符串
                index1++;
                wordIndex1 = 0;
                //需要同时进行判断,否则仅 index1 进行了移动,将导致最终结果不一致
                //word2 中下标为 index2 的数据 下标 wordIndex2 越界,移动到下一个字符串
                if (wordIndex2 >= word2[index2].length()) {
                    index2++;
                    wordIndex2 = 0;
                }
            }
        }
        //word1 和 word2 同时完成所有字符判断,结果为 true
        return index1 >= word1.length && index2 >= word2.length;
    }

}
